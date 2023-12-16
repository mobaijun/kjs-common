@echo off

REM 获取用户输入的工作目录
set /p WORK_DIR=请输入工作目录：

REM 验证用户输入的工作目录是否存在
if not exist "%WORK_DIR%" (
    echo 错误：工作目录不存在，请重新输入。
    exit /b 1
)

REM 进入用户指定的工作目录
cd /d %WORK_DIR%

REM 用户输入代理配置
:GET_HTTP_PROXY_PORT
set /p HTTP_PROXY_PORT=请输入HTTP代理端口号：

REM 验证代理端口是否为数字
setlocal enabledelayedexpansion
set "nonnumeric=!HTTP_PROXY_PORT!"
for /l %%a in (0,1,9) do set "nonnumeric=!nonnumeric:%%a=!"
if defined nonnumeric (
    echo 错误：输入的不是合法的端口号，请重新输入。
    endlocal
    goto GET_HTTP_PROXY_PORT
)

REM 配置代理
git config --global http.proxy 127.0.0.1:%HTTP_PROXY_PORT%
git config --global https.proxy 127.0.0.1:%HTTP_PROXY_PORT%

REM 执行 Git 操作
echo 执行 git pull 操作
git pull

echo 执行 git add 操作
git add .

REM 用户输入提交注释
set /p COMMIT_MESSAGE=请输入提交注释：

REM 验证提交注释是否为空
if "%COMMIT_MESSAGE%"=="" (
    echo 错误：提交注释不能为空，请重新输入。
    exit /b 1
)

echo 执行 git commit 操作
git commit -m "%COMMIT_MESSAGE%"

echo 执行 git push 操作
git push

REM 用户选择关闭或下一步
set /p CHOICE=请输入数字选择：1. 关闭  2. 执行下一步

if "%CHOICE%"=="1" (
    echo 用户选择关闭
    REM 取消代理配置
    git config --global --unset http.proxy
    git config --global --unset https.proxy
    pause
) else (
    echo 用户选择执行下一步
    REM 在这里添加下一步的操作
    pause
)

endlocal