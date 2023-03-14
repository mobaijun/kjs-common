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

## 其他语言

- [English](README.en.md)

## 概述

kjs-common ，是一个基于 Java 开发的工具类库，对项目开发中常用的工具进行封装，旨在提高 Java 开发者的开发效率和代码质量。

本项目集成了项目中常用的优秀开源工具类：

* lombok （简化实体类）
* mapstruct （简化参数传递）

目标：`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> 注意：kjs-common 基于 JDK1.8 开发，如果你的 JDK 版本过低，请找到相应的工具类，复制相关代码，进行使用。

## 功能和特点

- 提供了许多常用的工具函数和扩展函数，例如字符串操作、集合操作、日期和时间操作等。
- 提供了 Stream 处理工具类和文件工具类，以提高代码的健壮性和可读性。
- 所有的工具函数和工具类都经过严格测试和文档化，可以放心使用。

## 发展

> 本项目计划在 2.0 版本支持 JDK 17 及以上版本，2.0 以内版本以 JDK 8 为基石，这表示未来 2.X 版本不会兼容 JDK 17 以下的项目，如果是
> JDK 17 以内项目推荐使用 2.0 以内版本

## 示例

测试用例地址：[测试用例地址](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common/test)

> 所有依赖模块会同步更新最新版本

## 快速开始

您可以将 `kjs-common` 添加到您的项目中作为依赖项。

### maven

如果您使用的是 Maven，请将以下内容添加到您的 `pom.xml` 文件中：

```xml

<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### Gradle

在 Gradle 中，您可以将以下内容添加到您的 `build.gradle` 文件中：

~~~json
dependencies {
    implementation 'com.mobaijun:kjs-common:latest.version'
}
~~~

### 中央仓库

本仓库已经同步发布 [maven 中央仓库](https://mvnrepository.com/artifact/com.mobaijun/kjs-common)，欢迎使用，欢迎 start

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## 贡献

如果您想贡献代码或者提出建议，请遵循以下步骤：

1. Fork 本仓库
2. 创建您的分支 (`git checkout -b feature/AmazingFeature`)
3. 提交您的更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开一个 Pull Request

请注意，我们是一个开源社区，我们欢迎任何人的贡献。请在提交贡献之前仔细阅读我们的[贡献指南](https://github.com/april-projects/april-norm/blob/main/README.md)。

## 许可证

`kjs-common` 是基于 Apache
许可证开发的，详情请查看 [LICENSE](https://github.com/mobaijun/kjs-common/blob/main/LICENSE.txt) 文件。

## 作者

- [@mobaijun](https://github.com/mobaijun)

## 文档和示例

我们提供单元测试 [示例项目](https://github.com/mobaijun/kjs-common/tree/main/src/test/java/com/mobaijun/common/test)
，以帮助您更好地了解和使用该库。

## 趋势

![](https://starchart.cc/mobaijun/kjs-common.svg)

## 状态

![Repobeats analytics](https://repobeats.axiom.co/api/embed/c6b9508b383c2d1c0f1d01b6d3568d5240482f7c.svg "Repobeats analytics image")

## 致谢

感谢您使用 `kjs-common`，我们将继续努力为开发者提供更好的工具库。
