---
# ksj-core

本项目集成了项目中常用的工具类：
* hutool-all （最全工具类）
* lombok （简化实体类）
* mapstruct （简化参数传递）
* commons-lang3（Apache工具包）

* 源码目录结构

~~~javascript
│  .gitignore
│  LICENSE
│  pom.xml
│  README.md
├─.github
│  └─workflows
│          gitee-synchronize.yml
└─src
    └─main
        └─java
            └─com
                └─mobaijun
                    └─common
                        │  MoBaiJun.java
                        ├─annotation
                        │      BusinessLog.java
                        │      ChineseDescription.java
                        │      DataScope.java
                        │      DataSource.java
                        │      Excel.java
                        │      Excels.java
                        │      Log.java
                        │      OperateLog.java
                        │      RedisLimiting.java
                        │      RedisLock.java
                        │      RepeatSubmit.java
                        │      Wrapper.java
                        ├─base
                        │  │  BaseWrapper.java
                        │  └─controller
                        │          BaseController.java
                        ├─cache
                        │  └─map
                        │          HashMapSingletonCacheUtils.java
                        ├─code
                        │      UnicodeUtils.java
                        ├─common
                        │      DefaultValues.java
                        ├─download
                        │      DownloadUtils.java
                        ├─enums
                        │  │  BooleanEnum.java
                        │  │  EnumUtils.java
                        │  │  Env.java
                        │  │  Status.java
                        │  │  StatusEnum.java
                        │  │  YesOrNotEnum.java
                        │  ├─client
                        │  │      SourceEnum.java
                        │  ├─database
                        │  │      DataSourceStatusEnum.java
                        │  │      DataSourceType.java
                        │  │      Order.java
                        │  ├─dict
                        │  │      DictSelectTagHeadEnum.java
                        │  │      DictTypeClassEnum.java
                        │  │      DictTypeEnum.java
                        │  ├─file
                        │  │      BucketAuthEnum.java
                        │  │      FileLocationEnum.java
                        │  │      FileStatusEnum.java
                        │  │      ImageType.java
                        │  ├─http
                        │  │      FieldMetadataTypeEnum.java
                        │  │      FieldTypeEnum.java
                        │  │      ParamTypeEnum.java
                        │  ├─log
                        │  │      BusinessStatus.java
                        │  │      BusinessType.java
                        │  │      LoginType.java
                        │  │      LogStatus.java
                        │  │      LogType.java
                        │  ├─message
                        │  │      MessageReadFlagEnum.java
                        │  ├─sms
                        │  │      SendStatusEnum.java
                        │  │      SmsTypeEnum.java
                        │  ├─timer
                        │  │      TimerJobStatusEnum.java
                        │  └─user
                        │          AccountStatus.java
                        │          IsMenu.java
                        │          MenuStatus.java
                        │          OnlineStatus.java
                        │          OperatorType.java
                        │          SexEnum.java
                        ├─exception
                        │      AbstractExceptionEnum.java
                        │      BaseException.java
                        │      CustomException.java
                        │      FileException.java
                        │      ToolBoxException.java
                        │      UtilException.java
                        ├─lambda
                        │      LambdaExceptionUtils.java
                        ├─result
                        │  │  AbstractTip.java
                        │  │  ErrorTip.java
                        │  │  R.java
                        │  │  SuccessTip.java
                        │  └─enums
                        │          HttpStatus.java
                        └─util
                            │  BrowserUtils.java
                            │  ExtensionLoader.java
                            │  GPSUtils.java
                            │  JdkUtils.java
                            │  LicenseTitleAppenderUtils.java
                            │  MacAddressUtils.java
                            │  MavenUtils.java
                            │  ObjectUtils.java
                            │  PrintUtils.java
                            │  RandUtils.java
                            │  RedirectUrlBuildUtils.java
                            │  RunTimeUtils.java
                            │  StartCalcUtils.java
                            │  StrFormatter.java
                            │  StringUtils.java
                            │  TimeUtils.java
                            │  ToolUtils.java
                            ├─base
                            │      BaseWrapper.java
                            ├─classs
                            │      ClassUtils.java
                            │      ReflectionUtils.java
                            ├─collection
                            │      ArrayUtils.java
                            │      CollectionUtils.java
                            │      CountMap.java
                            │      MultiKeyHashMap.java
                            ├─constant
                            │      Constant.java
                            │      DateConstant.java
                            │      FileConstant.java
                            │      JdkConstant.java
                            │      LicenseConstant.java
                            │      NumberConstant.java
                            │      ShiroConstants.java
                            │      StringConstant.java
                            │      SymbolConstant.java
                            │      ThreadConstant.java
                            │      UserConstant.java
                            ├─converter
                            │      Converter.java
                            │      MoneyCoverUtils.java
                            ├─date
                            │      DateUtils.java
                            ├─file
                            │      FileUtils.java
                            │      MimeTypeUtils.java
                            │      PicFileTypeUtils.java
                            ├─html
                            │      EscapeUtils.java
                            │      HtmlFilter.java
                            ├─http
                            │      HttpUtils.java
                            │      IpUtils.java
                            │      PostmanUtils.java
                            ├─image
                            │      GeneratorImage.java
                            ├─io
                            │      ZipUtils.java
                            ├─jdbc
                            │      JdbcDriverUtils.java
                            ├─log
                            │      LogManager.java
                            ├─network
                            │      NetUtils.java
                            ├─number
                            │      MoneyUtils.java
                            │      NumberUtils.java
                            ├─page
                            │      PageResult.java
                            ├─pass
                            │      AESUtils.java
                            │      CRC16.java
                            │      DesUtils.java
                            │      RsaUtils.java
                            ├─reflect
                            │      ReflectUtils.java
                            ├─regx
                            │      RegxConstant.java
                            │      RegxUtils.java
                            ├─sensitive
                            │      Mask.java
                            │      MaskToStringBuilder.java
                            │      TestDemo.java
                            ├─seo
                            │      PostUrlUtils.java
                            ├─sql
                            │      SqlUtils.java
                            ├─stream
                            │      StreamUtils.java
                            ├─system
                            │      Arith.java
                            │      DiskUtils.java
                            │      Server.java
                            │      SysCpu.java
                            │      SysFile.java
                            │      SysJvm.java
                            │      SysMem.java
                            │      System.java
                            ├─text
                            │      CharsetKit.java
                            │      StrConvert.java
                            │      WafUtils.java
                            ├─thread
                            │      ExecutorServiceUtils.java
                            │      RemoveThreadLocalApi.java
                            │      Threads.java
                            ├─thunder
                            │      ThunderUtils.java
                            ├─tool
                            │      MapBeanUtils.java
                            ├─tree
                            │      INode.java
                            │      MenuNode.java
                            └─uid
                                    IdWorker.java
                                    Md5Utils.java
                                    UUID.java
                                    UuidUtils.java
~~~

> 所有依赖会同步更新最新版本

本仓库已经同步发布 maven 中央仓库，内置自定义工具类，欢迎使用，欢迎 star

如需使用，引入如下依赖即可
```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

* 如果你也想参加这个项目，请 fork 本仓库，修改完毕提交 pr ，审核后会同步至本仓库。

*mvn clean deploy -DskipTests -P sonatype-release*