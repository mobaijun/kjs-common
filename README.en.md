<h1 align="center">
    kjs-common
</h1>
<p align="center">
    <strong>JAVA开发，常用工具集(默认集成Lombok，MapStruct ) </strong>
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

## Overview

kjs-common is a tool class library developed based on Java. It encapsulates tools commonly used in project development and aims to improve the development efficiency and code quality of Java developers.

This project integrates excellent open source tools commonly used in projects:

-   lombok (simplified entity class)
-   mapstruct (simplifies parameter passing)

Target:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> Note: kjs-common is developed based on JDK1.8. If your JDK version is too low, please find the corresponding tool class, copy the relevant code, and use it.

## Functions and features

-   Provides many commonly used utility functions and extension functions, such as string operations, set operations, date and time operations, etc.
-   Stream processing tool classes and file tool classes are provided to improve the robustness and readability of the code.
-   All tool functions and tool classes have been strictly tested and documented, and can be used with confidence.

## develop

> This project plans to support JDK 17 and above in version 2.0. Versions below 2.0 are based on JDK 8. This means that future 2.X versions will not be compatible with projects below JDK 17. If
> It is recommended that projects within JDK 17 or below use versions below 2.0

## Example

Test case address:[Test case address](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common)

> All dependent modules will be updated to the latest version simultaneously

## quick start

You can use`kjs-common`Add to your project as dependency.

### maven

If you are using Maven, add the following to your`pom.xml`In the file:

```xml

<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### Gradle

In Gradle you can add the following to your`build.gradle`In the file:

```json
dependencies {
    implementation 'com.mobaijun:kjs-common:latest.version'
}
```

### central warehouse

This warehouse has been released simultaneously[maven central warehouse](https://mvnrepository.com/artifact/com.mobaijun/kjs-common), welcome to use, welcome to start

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## contribute

If you would like to contribute code or make suggestions, please follow these steps:

1.  Fork this warehouse
2.  Create your branch (`git checkout -b feature/AmazingFeature`)
3.  Submit your changes (`git commit -m 'Add some AmazingFeature'`)
4.  push to branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

Please note that we are an open source community and we welcome contributions from anyone. Please read our[Contribution Guide](https://github.com/april-projects/april-norm/blob/main/README.md)。

## license

`kjs-common` 是基于 Apache
许可证开发的，详情请查看 [LICENSE](https://github.com/mobaijun/kjs-common/blob/main/LICENSE.txt)document.

## author

-   [@ Mobaijun](https://github.com/mobaijun)

## 文档和示例

We provide unit testing[Sample project](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common/test), to help you better understand and use the library.

## trend

![](https://starchart.cc/mobaijun/kjs-common.svg)

## state

![Repobeats analytics](https://repobeats.axiom.co/api/embed/c6b9508b383c2d1c0f1d01b6d3568d5240482f7c.svg "Repobeats analytics image")

## Acknowledgments

Thank you for using`kjs-common`, we will continue to work hard to provide developers with a better tool library.
