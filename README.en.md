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

kjs-common is a basic tool library for Java development, which encapsulates commonly used tools in project development, such as: encryption, http request, API interface, etc. The purpose is to help developers develop faster and faster.

This project integrates the excellent open source tools commonly used in the project:

-   hutool-all (the most comprehensive tool class)
-   lombok (simplified entity classes)
-   mapstruct (simplifies parameter passing)

Target:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> Note: kjs-common is developed based on JDK1.8. If your JDK version is too low, please find the corresponding tool class, copy the relevant code, and use it.

## develop

> This project plans to support JDK 17 and above in version 2.0, and versions below 2.0 use JDK 8 as the cornerstone, which means that future 2.X versions will not be compatible with projects below JDK 17.
> Projects within JDK 17 are recommended to use versions within 2.0

## example

Test case address:[Test case address](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common/test)

> 所有依赖模块会同步更新最新版本

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

-   If you also want to participate in this project, please fork this warehouse, submit the pr after the modification, and it will be synchronized to this warehouse after review.

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## trend

![](https://starchart.cc/mobaijun/kjs-common.svg)
