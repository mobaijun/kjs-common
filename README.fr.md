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

## Aperçu

kjs-common ，是一个Java开发基础工具类库，对项目开发中常用的工具进行封装，如：加密、http 请求、API 接口等。 目的是帮助开发者更快速、更快捷的开发。

Ce projet intègre les excellents outils open source couramment utilisés dans le projet :

-   hutool-all (la classe d'outils la plus complète)
-   lombok (classes d'entités simplifiées)
-   mapstruct (simplifie le passage des paramètres)

Cible:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> Remarque : kjs-common est développé sur la base de JDK1.8. Si votre version de JDK est trop basse, veuillez trouver la classe d'outils correspondante, copier le code correspondant et l'utiliser.

## développer

> Ce projet prévoit de prendre en charge JDK 17 et supérieur dans la version 2.0, et les versions inférieures à 2.0 utilisent JDK 8 comme pierre angulaire, ce qui signifie que les futures versions 2.X ne seront pas compatibles avec les projets inférieurs à JDK 17.
> Les projets dans JDK 17 sont recommandés pour utiliser les versions dans 2.0

## Table des matières

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

> Toutes les dépendances seront mises à jour vers la dernière version de manière synchrone

## démarrage rapide

Si vous avez besoin de l'utiliser, introduisez simplement les dépendances suivantes

### expert

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

### entrepôt central

Cet entrepôt a été libéré de manière synchrone[entrepôt central maven](https://mvnrepository.com/artifact/com.mobaijun/kjs-common), bienvenue à utiliser, bienvenue pour commencer

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## contribuer

-   Si vous souhaitez également participer à ce projet, veuillez bifurquer cet entrepôt, soumettre le pr après la modification, et il sera synchronisé avec cet entrepôt après examen.

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## s'orienter

![](https://starchart.cc/mobaijun/kjs-common.svg)
