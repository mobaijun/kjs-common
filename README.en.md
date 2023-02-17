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

## other languages

-   [English](README.en.md)

## overview

kjs-common is a Java development basic tool class library that encapsulates commonly used tools in project development, such as: encryption, http request, API interface, etc. The purpose is to help developers develop faster and faster.

This project integrates the excellent open source tools commonly used in the project:

-   hutool-all (the most comprehensive tool class)
-   lombok (simplified entity classes)
-   mapstruct (simplifies parameter passing)

Target:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> Note: kjs-common is developed based on JDK1.8. If your JDK version is too low, please find the corresponding tool class, copy the relevant code, and use it.

## develop

> 本项目计划在 2.0 版本支持 JDK 17 及以上版本，2.0 以内版本以 JDK 8 为基石，这表示未来 2.X 版本不会兼容 JDK 17 以下的项目，如果是
> JDK 17 以内项目推荐使用 2.0 以内版本

## example

Test case address:[Test case address](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common/test)

> All dependent modules will be updated to the latest version synchronously

## quick start

If you need to use it, just introduce the following dependencies

### maven

```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### Gradle

```xml
implementation 'com.mobaijun:kjs-common:latest.version'
```

### central warehouse

This warehouse has been released synchronously[maven central warehouse](https://mvnrepository.com/artifact/com.mobaijun/kjs-common), welcome to use, welcome to start

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## contribute

-   如果你也想参加这个项目，请 fork 本仓库，修改完毕提交 pr ，审核后会同步至本仓库。

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## trend

![](https://starchart.cc/mobaijun/kjs-common.svg)

## state

![Repobeats analytics](https://repobeats.axiom.co/api/embed/c6b9508b383c2d1c0f1d01b6d3568d5240482f7c.svg "Repobeats analytics image")
