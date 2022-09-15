# ksj-core

本项目集成了项目中常用的工具类：
* hutool-all （最全工具类）
* lombok （简化实体类）
* mapstruct （简化参数传递）

## 源码目录结构

~~~bash
|-- LICENSE.txt
|-- NOTICE.txt
|-- pom.xml
|-- README.md
`-- src
    `-- main
        `-- java
            `-- com
                `-- mobaijun
                    `-- common
                        |-- annotation
                        |   |-- BusinessLog.java
                        |   |-- ChineseDescription.java
                        |   |-- DataScope.java
                        |   |-- DataSource.java
                        |   |-- Excel.java
                        |   |-- Excels.java
                        |   |-- Log.java
                        |   |-- OperateLog.java
                        |   |-- package-info.java
                        |   |-- RedisLimiting.java
                        |   |-- RedisLock.java
                        |   |-- RepeatSubmit.java
                        |   `-- Wrapper.java
                        |-- base
                        |   |-- BaseWrapper.java
                        |   |-- controller
                        |   |   |-- BaseController.java
                        |   |   `-- package-info.java
                        |   `-- package-info.java
                        |-- cache
                        |   `-- map
                        |       |-- HashMapSingletonCacheUtils.java
                        |       `-- package-info.java
                        |-- code
                        |   |-- package-info.java
                        |   `-- UnicodeUtils.java
                        |-- common
                        |   |-- DefaultValues.java
                        |   `-- package-info.java
                        |-- download
                        |   |-- DownloadUtils.java
                        |   `-- package-info.java
                        |-- enums
                        |   |-- BooleanEnum.java
                        |   |-- client
                        |   |   |-- package-info.java
                        |   |   `-- SourceEnum.java
                        |   |-- database
                        |   |   |-- DataSourceStatusEnum.java
                        |   |   |-- DataSourceType.java
                        |   |   |-- Order.java
                        |   |   `-- package-info.java
                        |   |-- dict
                        |   |   |-- DictSelectTagHeadEnum.java
                        |   |   |-- DictTypeClassEnum.java
                        |   |   |-- DictTypeEnum.java
                        |   |   `-- package-info.java
                        |   |-- Env.java
                        |   |-- file
                        |   |   |-- BucketAuthEnum.java
                        |   |   |-- FileLocationEnum.java
                        |   |   |-- FileStatusEnum.java
                        |   |   |-- ImageType.java
                        |   |   `-- package-info.java
                        |   |-- http
                        |   |   |-- FieldMetadataTypeEnum.java
                        |   |   |-- FieldTypeEnum.java
                        |   |   |-- package-info.java
                        |   |   `-- ParamTypeEnum.java
                        |   |-- log
                        |   |   |-- BusinessStatus.java
                        |   |   |-- BusinessType.java
                        |   |   |-- LoginType.java
                        |   |   |-- LogStatus.java
                        |   |   |-- LogType.java
                        |   |   `-- package-info.java
                        |   |-- message
                        |   |   |-- MessageReadFlagEnum.java
                        |   |   `-- package-info.java
                        |   |-- package-info.java
                        |   |-- sms
                        |   |   |-- package-info.java
                        |   |   |-- SendStatusEnum.java
                        |   |   `-- SmsTypeEnum.java
                        |   |-- StatusEnum.java
                        |   |-- Status.java
                        |   |-- timer
                        |   |   |-- package-info.java
                        |   |   `-- TimerJobStatusEnum.java
                        |   |-- user
                        |   |   |-- AccountStatus.java
                        |   |   |-- IsMenu.java
                        |   |   |-- MenuStatus.java
                        |   |   |-- OnlineStatus.java
                        |   |   |-- OperatorType.java
                        |   |   |-- package-info.java
                        |   |   `-- SexEnum.java
                        |   `-- YesOrNotEnum.java
                        |-- exception
                        |   |-- AbstractExceptionEnum.java
                        |   |-- BaseException.java
                        |   |-- CustomException.java
                        |   |-- FileException.java
                        |   |-- package-info.java
                        |   |-- ToolBoxException.java
                        |   `-- UtilException.java
                        |-- function
                        |   |-- package-info.java
                        |   |-- ResultMethod.java
                        |   `-- VoidMethod.java
                        |-- lambda
                        |   |-- LambdaExceptionUtils.java
                        |   `-- package-info.java
                        |-- MoBaiJun.java
                        |-- result
                        |   |-- AbstractTip.java
                        |   |-- enums
                        |   |   |-- HttpStatus.java
                        |   |   `-- package-info.java
                        |   |-- ErrorTip.java
                        |   |-- package-info.java
                        |   |-- R.java
                        |   `-- SuccessTip.java
                        `-- util
                            |-- BrowserUtils.java
                            |-- classs
                            |   |-- ClassUtils.java
                            |   |-- package-info.java
                            |   `-- ReflectionUtils.java
                            |-- collection
                            |   |-- ArrayUtils.java
                            |   |-- CollectionUtils.java
                            |   |-- CountMap.java
                            |   |-- MultiKeyHashMap.java
                            |   `-- package-info.java
                            |-- constant
                            |   |-- Constant.java
                            |   |-- DateConstant.java
                            |   |-- FileConstant.java
                            |   |-- JdkConstant.java
                            |   |-- LicenseConstant.java
                            |   |-- NumberConstant.java
                            |   |-- package-info.java
                            |   |-- ShiroConstants.java
                            |   |-- StringConstant.java
                            |   |-- SymbolConstant.java
                            |   |-- ThreadConstant.java
                            |   `-- UserConstant.java
                            |-- converter
                            |   |-- Converter.java
                            |   |-- MoneyCoverUtils.java
                            |   `-- package-info.java
                            |-- cron
                            |   |-- CronUtils.java
                            |   |-- package-info.java
                            |   `-- TaskScheduleModel.java
                            |-- date
                            |   |-- DateUtils.java
                            |   `-- package-info.java
                            |-- ExtensionLoader.java
                            |-- file
                            |   |-- FileUtils.java
                            |   |-- MimeTypeUtils.java
                            |   |-- package-info.java
                            |   `-- PicFileTypeUtils.java
                            |-- GPSUtils.java
                            |-- html
                            |   |-- EscapeUtils.java
                            |   |-- HtmlFilter.java
                            |   `-- package-info.java
                            |-- http
                            |   |-- HttpUtils.java
                            |   |-- IpUtils.java
                            |   `-- package-info.java
                            |-- image
                            |   |-- GeneratorImage.java
                            |   `-- package-info.java
                            |-- io
                            |   |-- package-info.java
                            |   `-- ZipUtils.java
                            |-- jdbc
                            |   |-- JdbcDriverUtils.java
                            |   `-- package-info.java
                            |-- JdkUtils.java
                            |-- LanguageUtil.java
                            |-- LicenseTitleAppenderUtils.java
                            |-- log
                            |   |-- LogManager.java
                            |   `-- package-info.java
                            |-- MacAddressUtils.java
                            |-- MavenUtils.java
                            |-- network
                            |   |-- NetUtils.java
                            |   `-- package-info.java
                            |-- number
                            |   |-- MoneyUtils.java
                            |   |-- NumberUtils.java
                            |   `-- package-info.java
                            |-- ObjectUtils.java
                            |-- package-info.java
                            |-- page
                            |   |-- package-info.java
                            |   `-- PageResult.java
                            |-- pass
                            |   |-- AESUtils.java
                            |   |-- CRC16.java
                            |   |-- DesUtils.java
                            |   |-- package-info.java
                            |   `-- RsaUtils.java
                            |-- PrintUtils.java
                            |-- RandUtils.java
                            |-- RedirectUrlBuildUtils.java
                            |-- reflect
                            |   |-- package-info.java
                            |   `-- ReflectUtils.java
                            |-- regx
                            |   |-- package-info.java
                            |   |-- RegxConstant.java
                            |   `-- RegxUtils.java
                            |-- RunTimeUtils.java
                            |-- seo
                            |   |-- package-info.java
                            |   `-- PostUrlUtils.java
                            |-- sql
                            |   |-- package-info.java
                            |   `-- SqlUtils.java
                            |-- StartCalcUtils.java
                            |-- stream
                            |   |-- package-info.java
                            |   `-- StreamUtils.java
                            |-- StrFormatter.java
                            |-- StringUtils.java
                            |-- system
                            |   |-- Arith.java
                            |   |-- DiskUtils.java
                            |   |-- package-info.java
                            |   |-- Server.java
                            |   |-- SysCpu.java
                            |   |-- SysFile.java
                            |   |-- SysJvm.java
                            |   |-- SysMem.java
                            |   `-- System.java
                            |-- text
                            |   |-- CharsetKit.java
                            |   |-- package-info.java
                            |   |-- StrConvert.java
                            |   `-- WafUtils.java
                            |-- thread
                            |   |-- ExecutorServiceUtils.java
                            |   |-- package-info.java
                            |   |-- RemoveThreadLocalApi.java
                            |   |-- ThreadPrint.java
                            |   `-- Threads.java
                            |-- thunder
                            |   |-- package-info.java
                            |   `-- ThunderUtils.java
                            |-- TimeUtils.java
                            |-- tool
                            |   |-- MapBeanUtils.java
                            |   `-- package-info.java
                            |-- ToolUtils.java
                            |-- tree
                            |   |-- AbstractMenuNode.java
                            |   |-- INode.java
                            |   `-- package-info.java
                            |-- uid
                            |   |-- IdWorker.java
                            |   |-- Md5Utils.java
                            |   |-- package-info.java
                            |   |-- UUID.java
                            |   `-- UuidUtils.java
                            `-- UrlParamsUtil.java
~~~

> 所有依赖会同步更新最新版本

## 快速开始

本仓库已经同步发布 maven 中央仓库，内置自定义工具类，欢迎使用，欢迎 star

<div style="position: relative; padding: 30% 45%;">
    <iframe style="position: absolute; width: 100%; height: 100%; left: 0; top: 0;"
            src="https://mvnrepository.com/artifact/com.mobaijun/kjs-common" frameborder="1" scrolling="yes" width="320"
            height="240">
    </iframe>
</div>

如需使用，引入如下依赖即可
```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

## 贡献

* 如果你也想参加这个项目，请 fork 本仓库，修改完毕提交 pr ，审核后会同步至本仓库。

~~~bash
$ mvn clean deploy -DskipTests -P sonatype-release
~~~
