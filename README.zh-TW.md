
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

## 其他语言

-   [英語](README.en.md)
-   [繁體中文](README.zh-TW.md)

## 概述

kjs-common ，是一個Java開發基礎工具類庫，對項目開發中常用的工具進行封裝，如：加密、http 請求、API 接口等。目的是幫助開發者更快速、更快捷的開發。

本項目集成了項目中常用的優秀開源工具類：

-   hutool-all （最全工具類）
-   lombok （簡化實體類）
-   mapstruct （简化参数传递）

目標：`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> 注意：kjs-common 基於 JDK1.8 開發，如果你的 JDK 版本過低，請找到相應的工具類，複製相關代碼，進行使用。

## 發展

> 本項目計劃在 2.0 版本支持 JDK 17 及以上版本，2.0 以內版本以 JDK 8 為基石，這表示未來 2.X 版本不會兼容 JDK 17 以下的項目，如果是
> JDK 17 以內項目推薦使用 2.0 以內版本

## 目錄

```bash
--------------------------------------------------------------------------------------------
├─.github
│  └─workflows
├─src
│  ├─main
│  │  └─java
│  │      └─com
│  │          └─mobaijun
│  │              └─common
│  │                  ├─algorithm
│  │                  ├─annotation
│  │                  │  ├─datasource
│  │                  │  ├─i18n
│  │                  │  ├─log
│  │                  │  └─redis
│  │                  ├─cache
│  │                  │  └─map
│  │                  ├─common
│  │                  ├─constant
│  │                  ├─download
│  │                  ├─enhance
│  │                  ├─enums
│  │                  │  ├─client
│  │                  │  ├─common
│  │                  │  ├─database
│  │                  │  ├─date
│  │                  │  ├─dict
│  │                  │  ├─file
│  │                  │  ├─http
│  │                  │  ├─log
│  │                  │  ├─message
│  │                  │  ├─redis
│  │                  │  ├─regex
│  │                  │  ├─sms
│  │                  │  ├─timer
│  │                  │  └─user
│  │                  ├─function
│  │                  │  └─impl
│  │                  ├─lambda
│  │                  ├─result
│  │                  │  └─enums
│  │                  └─util
│  │                      ├─classs
│  │                      ├─collection
│  │                      ├─concurrent
│  │                      ├─converter
│  │                      ├─cron
│  │                      ├─date
│  │                      ├─enums
│  │                      ├─file
│  │                      ├─html
│  │                      ├─http
│  │                      ├─image
│  │                      ├─io
│  │                      ├─jdbc
│  │                      ├─network
│  │                      ├─number
│  │                      ├─pass
│  │                      ├─pinyin
│  │                      ├─reflect
│  │                      ├─regx
│  │                      ├─seo
│  │                      ├─sql
│  │                      ├─stream
│  │                      ├─system
│  │                      ├─text
│  │                      ├─thread
│  │                      ├─thunder
│  │                      ├─tool
│  │                      └─tree
│  └─test
│      └─java
│          └─com
│              └─mobaijun
│                  └─common
│                      └─test 
│                          ├─cache
│                          ├─classs
│                          ├─collection
│                          ├─converter
│                          ├─cron
│                          ├─date
│                          ├─download
│                          ├─function
│                          ├─seo
│                          ├─tree
│                          └─util
--------------------------------------------------------------------------------------------
```

> 所有依賴會同步更新最新版本

## 快速開始

如需使用，引入如下依賴即可

### 行家

```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### 搖籃

```xml
implementation 'com.mobaijun:kjs-common:latest.version'
```

### 中央倉庫

本倉庫已經同步發布[maven 中央倉庫](https://mvnrepository.com/artifact/com.mobaijun/kjs-common)，歡迎使用，歡迎 start

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## 貢獻

-   如果你也想參加這個項目，請 fork 本倉庫，修改完畢提交 pr ，審核後會同步至本倉庫。

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## 趨勢

![](https://starchart.cc/mobaijun/kjs-common.svg)