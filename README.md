# ksj-core
本项目集成了项目中常用的工具类：
* hutool-all （最全工具类）
* lombok （简化实体类）
* mapstruct （简化参数传递）
* commons-lang3（Apache工具包）

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