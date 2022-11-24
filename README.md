<h1 align="center">
    kjs-common
</h1>
<p align="center">
    <strong>JAVA开发，常用工具集(默认集成 Hutool，Lombok，MapStruct ) </strong>
</p>
<p align="center">
    <a target="_blank" href="https://search.maven.org/artifact/com.mobaijun/kjs-common">
        <img src="https://img.shields.io/maven-central/v/com.mobaijun/kjs-common.svg?style=flat&logo=Apache Maven"
             alt="kjs-common"/>
    </a>
    <a target="_blank" href="https://www.apache.org/licenses/LICENSE-2.0.html">
        <img src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat&logo=apache" alt="apache">
    </a>
    <a target="_blank" href="https://www.oracle.com/technetwork/java/javase/downloads/index.html">
        <img src="https://img.shields.io/badge/JDK-1.8+-green.svg?style=flat&logo=Oracle" alt="jdk">
    </a>
    <a target="_blank" href='https://github.com/mobaijun/kjs-common'>
        <img src="https://img.shields.io/github/stars/mobaijun/kjs-common.svg?style=flat&logo=GitHub"
             alt="github star">
    </a>
    <a target="_blank" href='https://github.com/mobaijun/kjs-common'>
        <img src="https://komarev.com/ghpvc/?username=mobaijun&color=orange" alt="profile">
    </a>
</p>

## 概述

kjs-common ，是一个Java开发基础工具类库，对项目开发中常用的工具进行封装，如：加密、http 请求、API 接口等。 目的是帮助开发者更快速、更快捷的开发。

本项目集成了项目中常用的优秀开源工具类：

* hutool-all （最全工具类）
* lombok （简化实体类）
* mapstruct （简化参数传递）

目标：`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> 注意：kjs-common 基于 JDK1.8 开发，如果你的 JDK 版本过低，请找到相应的工具类，复制相关代码，进行使用。

## 发展

> 本项目计划在 2.0 版本支持 JDK 17 及以上版本，2.0 以内版本以 JDK 8 为基石，这表示未来 2.X 版本不会兼容 JDK 17 以下的项目，如果是
> JDK 17 以内项目推荐使用 2.0 以内版本

## 目录

~~~bash
--------------------------------------------------------------------------------------------
|_ .gitignore
|_ LICENSE.txt
|_ NOTICE.txt
|_ README.md
|_ kjs-common.iml
|_ pom.xml
com
   |_ mobaijun
   |          |_ common
   |          |        |_ MoBaiJun.java
   |          |        |_ annotation
   |          |        |            |_ package-info.java
   |          |        |            |_ datasource
   |          |        |            |            |_ DataScope.java
   |          |        |            |            |_ DataSource.java
   |          |        |            |            |_ package-info.java
   |          |        |            |_ i18n
   |          |        |            |      |_ ChineseDescription.java
   |          |        |            |      |_ package-info.java
   |          |        |            |_ log
   |          |        |            |     |_ BusinessLog.java
   |          |        |            |     |_ Log.java
   |          |        |            |     |_ OperateLog.java
   |          |        |            |     |_ package-info.java
   |          |        |            |_ poi
   |          |        |            |     |_ Excel.java
   |          |        |            |     |_ Excels.java
   |          |        |            |     |_ package-info.java
   |          |        |            |_ redis
   |          |        |            |       |_ RedisLimiting.java
   |          |        |            |       |_ RedisLock.java
   |          |        |            |       |_ package-info.java
   |          |        |_ cache
   |          |        |       |_ map
   |          |        |       |     |_ HashMapSingletonCacheUtils.java
   |          |        |       |     |_ package-info.java
   |          |        |_ code
   |          |        |      |_ UnicodeUtils.java
   |          |        |      |_ package-info.java
   |          |        |_ common
   |          |        |        |_ DefaultValues.java
   |          |        |        |_ package-info.java
   |          |        |_ download
   |          |        |          |_ DownloadUtils.java
   |          |        |          |_ package-info.java
   |          |        |_ enums
   |          |        |       |_ BooleanEnum.java
   |          |        |       |_ EPlatformEnum.java
   |          |        |       |_ Env.java
   |          |        |       |_ LoginTypeEnum.java
   |          |        |       |_ MenuTypeEnum.java
   |          |        |       |_ Status.java
   |          |        |       |_ StatusEnum.java
   |          |        |       |_ YesOrNotEnum.java
   |          |        |       |_ package-info.java
   |          |        |       |_ client
   |          |        |       |        |_ SourceEnum.java
   |          |        |       |        |_ package-info.java
   |          |        |       |_ database
   |          |        |       |          |_ DataSourceStatusEnum.java
   |          |        |       |          |_ DataSourceType.java
   |          |        |       |          |_ Order.java
   |          |        |       |          |_ package-info.java
   |          |        |       |_ dict
   |          |        |       |      |_ DictSelectTagHeadEnum.java
   |          |        |       |      |_ DictTypeClassEnum.java
   |          |        |       |      |_ DictTypeEnum.java
   |          |        |       |      |_ package-info.java
   |          |        |       |_ file
   |          |        |       |      |_ BucketAuthEnum.java
   |          |        |       |      |_ FileLocationEnum.java
   |          |        |       |      |_ FileStatusEnum.java
   |          |        |       |      |_ ImageType.java
   |          |        |       |      |_ package-info.java
   |          |        |       |_ http
   |          |        |       |      |_ ContentTypeEnum.java
   |          |        |       |      |_ FieldMetadataTypeEnum.java
   |          |        |       |      |_ FieldTypeEnum.java
   |          |        |       |      |_ HttpRequestEnum.java
   |          |        |       |      |_ ParamTypeEnum.java
   |          |        |       |      |_ RenderType.java
   |          |        |       |      |_ ResponseHeader.java
   |          |        |       |      |_ package-info.java
   |          |        |       |_ log
   |          |        |       |     |_ BusinessStatus.java
   |          |        |       |     |_ BusinessType.java
   |          |        |       |     |_ LogStatus.java
   |          |        |       |     |_ LogType.java
   |          |        |       |     |_ LoginType.java
   |          |        |       |     |_ package-info.java
   |          |        |       |_ message
   |          |        |       |         |_ MessageReadFlagEnum.java
   |          |        |       |         |_ package-info.java
   |          |        |       |_ sms
   |          |        |       |     |_ SendStatusEnum.java
   |          |        |       |     |_ SmsTypeEnum.java
   |          |        |       |     |_ package-info.java
   |          |        |       |_ timer
   |          |        |       |       |_ TimerJobStatusEnum.java
   |          |        |       |       |_ package-info.java
   |          |        |       |_ user
   |          |        |       |      |_ AccountStatus.java
   |          |        |       |      |_ IsMenu.java
   |          |        |       |      |_ MenuStatus.java
   |          |        |       |      |_ OnlineStatus.java
   |          |        |       |      |_ OperatorType.java
   |          |        |       |      |_ SexEnum.java
   |          |        |       |      |_ package-info.java
   |          |        |_ exception
   |          |        |           |_ AbstractExceptionEnum.java
   |          |        |           |_ BaseException.java
   |          |        |           |_ CustomException.java
   |          |        |           |_ FileException.java
   |          |        |           |_ ToolBoxException.java
   |          |        |           |_ UtilException.java
   |          |        |           |_ package-info.java
   |          |        |_ function
   |          |        |          |_ JudgeFunction.java
   |          |        |          |_ ResultMethod.java
   |          |        |          |_ VoidMethod.java
   |          |        |          |_ package-info.java
   |          |        |          |_ impl
   |          |        |          |      |_ IfFunction.java
   |          |        |          |      |_ package-info.java
   |          |        |_ lambda
   |          |        |        |_ LambdaExceptionUtils.java
   |          |        |        |_ package-info.java
   |          |        |_ result
   |          |        |        |_ AbstractTip.java
   |          |        |        |_ ErrorTip.java
   |          |        |        |_ R.java
   |          |        |        |_ SuccessTip.java
   |          |        |        |_ package-info.java
   |          |        |        |_ enums
   |          |        |        |       |_ HttpStatus.java
   |          |        |        |       |_ package-info.java
   |          |        |_ util
   |          |        |      |_ BrowserUtils.java
   |          |        |      |_ ExtensionLoader.java
   |          |        |      |_ GPSUtils.java
   |          |        |      |_ JdkUtils.java
   |          |        |      |_ LanguageUtil.java
   |          |        |      |_ LicenseTitleAppenderUtils.java
   |          |        |      |_ MacAddressUtils.java
   |          |        |      |_ MavenUtils.java
   |          |        |      |_ ObjectUtils.java
   |          |        |      |_ PrintUtils.java
   |          |        |      |_ RandUtils.java
   |          |        |      |_ RedirectUrlBuildUtils.java
   |          |        |      |_ RunTimeUtils.java
   |          |        |      |_ StartCalcUtils.java
   |          |        |      |_ StrFormatter.java
   |          |        |      |_ StringUtils.java
   |          |        |      |_ TimeUtils.java
   |          |        |      |_ ToolUtils.java
   |          |        |      |_ UrlParamsUtil.java
   |          |        |      |_ package-info.java
   |          |        |      |_ classs
   |          |        |      |        |_ CheckToolClass.java
   |          |        |      |        |_ ClassUtils.java
   |          |        |      |        |_ ReflectionUtils.java
   |          |        |      |        |_ package-info.java
   |          |        |      |_ collection
   |          |        |      |            |_ ArrayUtils.java
   |          |        |      |            |_ CollectionUtils.java
   |          |        |      |            |_ CountMap.java
   |          |        |      |            |_ MultiKeyHashMap.java
   |          |        |      |            |_ package-info.java
   |          |        |      |_ constant
   |          |        |      |          |_ Constant.java
   |          |        |      |          |_ DateConstant.java
   |          |        |      |          |_ FileConstant.java
   |          |        |      |          |_ JdkConstant.java
   |          |        |      |          |_ LicenseConstant.java
   |          |        |      |          |_ NumberConstant.java
   |          |        |      |          |_ ShiroConstants.java
   |          |        |      |          |_ StringConstant.java
   |          |        |      |          |_ SymbolConstant.java
   |          |        |      |          |_ ThreadConstant.java
   |          |        |      |          |_ UserConstant.java
   |          |        |      |          |_ package-info.java
   |          |        |      |_ converter
   |          |        |      |           |_ Converter.java
   |          |        |      |           |_ MoneyCoverUtils.java
   |          |        |      |           |_ package-info.java
   |          |        |      |_ cron
   |          |        |      |      |_ CronUtils.java
   |          |        |      |      |_ TaskScheduleModel.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ date
   |          |        |      |      |_ LocalDateUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ file
   |          |        |      |      |_ FileUtils.java
   |          |        |      |      |_ MimeTypeUtils.java
   |          |        |      |      |_ PicFileTypeUtils.java
   |          |        |      |      |_ ReadDirectoryUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ html
   |          |        |      |      |_ EscapeUtils.java
   |          |        |      |      |_ HtmlFilter.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ http
   |          |        |      |      |_ HttpUtils.java
   |          |        |      |      |_ IpUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ image
   |          |        |      |       |_ GeneratorImage.java
   |          |        |      |       |_ package-info.java
   |          |        |      |_ io
   |          |        |      |    |_ ZipUtils.java
   |          |        |      |    |_ package-info.java
   |          |        |      |_ jdbc
   |          |        |      |      |_ JdbcDriverUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ network
   |          |        |      |         |_ NetUtils.java
   |          |        |      |         |_ package-info.java
   |          |        |      |_ number
   |          |        |      |        |_ BigDecimalChain.java
   |          |        |      |        |_ MoneyUtils.java
   |          |        |      |        |_ NumberUtils.java
   |          |        |      |        |_ package-info.java
   |          |        |      |_ pass
   |          |        |      |      |_ AESUtils.java
   |          |        |      |      |_ CRC16.java
   |          |        |      |      |_ DesUtils.java
   |          |        |      |      |_ RsaUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ reflect
   |          |        |      |         |_ ReflectUtils.java
   |          |        |      |         |_ package-info.java
   |          |        |      |_ regx
   |          |        |      |      |_ RegxConstant.java
   |          |        |      |      |_ RegxUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ seo
   |          |        |      |     |_ PostUrlUtils.java
   |          |        |      |     |_ package-info.java
   |          |        |      |_ sql
   |          |        |      |     |_ SqlUtils.java
   |          |        |      |     |_ package-info.java
   |          |        |      |_ stream
   |          |        |      |        |_ StreamUtils.java
   |          |        |      |        |_ package-info.java
   |          |        |      |_ system
   |          |        |      |        |_ Arith.java
   |          |        |      |        |_ DiskUtils.java
   |          |        |      |        |_ Server.java
   |          |        |      |        |_ SysCpu.java
   |          |        |      |        |_ SysFile.java
   |          |        |      |        |_ SysJvm.java
   |          |        |      |        |_ SysMem.java
   |          |        |      |        |_ System.java
   |          |        |      |        |_ package-info.java
   |          |        |      |_ text
   |          |        |      |      |_ CharsetKit.java
   |          |        |      |      |_ StrConvert.java
   |          |        |      |      |_ WafUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ thread
   |          |        |      |        |_ ExecutorServiceUtils.java
   |          |        |      |        |_ RemoveThreadLocalApi.java
   |          |        |      |        |_ ThreadPrint.java
   |          |        |      |        |_ Threads.java
   |          |        |      |        |_ package-info.java
   |          |        |      |_ thunder
   |          |        |      |         |_ ThunderUtils.java
   |          |        |      |         |_ package-info.java
   |          |        |      |_ tool
   |          |        |      |      |_ MapBeanUtils.java
   |          |        |      |      |_ package-info.java
   |          |        |      |_ tree
   |          |        |      |      |_ TreeConstant.java
   |          |        |      |      |_ TreeNode.java
   |          |        |      |      |_ TreeNodeConfig.java
   |          |        |      |      |_ TreeNodeConvert.java
   |          |        |      |      |_ TreeNodeMap.java
   |          |        |      |      |_ TreeUtils.java
   |          |        |      |      |_ package-info.java
--------------------------------------------------------------------------------------------
~~~

> 所有依赖会同步更新最新版本

## 快速开始

如需使用，引入如下依赖即可

### maven

```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### Gradle

~~~xml
implementation 'com.mobaijun:kjs-common:latest.version'
~~~

### 中央仓库

本仓库已经同步发布 [maven 中央仓库](https://mvnrepository.com/artifact/com.mobaijun/kjs-common)，欢迎使用，欢迎 start

<iframe height=850 width=90% src="https://search.maven.org/search?q=mobaijun" frameborder=0 allowfullscreen></iframe>


## 贡献

* 如果你也想参加这个项目，请 fork 本仓库，修改完毕提交 pr ，审核后会同步至本仓库。

~~~bash
$ mvn clean deploy -DskipTests -P sonatype-release
~~~

## 趋势

![](https://starchart.cc/mobaijun/kjs-common.svg)
