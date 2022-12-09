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

## نظرة عامة

kjs-common هي مكتبة فئة أدوات تطوير Java الأساسية التي تغلف الأدوات شائعة الاستخدام في تطوير المشروع ، مثل: التشفير ، وطلب http ، وواجهة API ، إلخ. والغرض من ذلك هو مساعدة المطورين على التطور بشكل أسرع وأسرع.

يدمج هذا المشروع الأدوات الممتازة مفتوحة المصدر التي يشيع استخدامها في المشروع:

-   hutool-all (فئة الأدوات الأكثر شمولاً)
-   لومبوك (فئات الكيانات المبسطة)
-   mapstruct (يبسط تمرير المعلمات)

استهداف:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> ملاحظة: تم تطوير kjs-common بناءً على JDK1.8. إذا كان إصدار JDK الخاص بك منخفضًا جدًا ، فيرجى العثور على فئة الأداة المناسبة ، ونسخ الكود ذي الصلة ، واستخدامه.

## طور

> يخطط هذا المشروع لدعم JDK 17 وما فوق في الإصدار 2.0 ، والإصدارات الأقل من 2.0 تستخدم JDK 8 كحجر زاوية ، مما يعني أن إصدارات 2.X المستقبلية لن تكون متوافقة مع المشاريع الأقل من JDK 17.
> يوصى بالمشاريع داخل JDK 17 لاستخدام الإصدارات ضمن 2.0

## جدول المحتويات

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

> سيتم تحديث جميع التبعيات إلى أحدث إصدار بشكل متزامن

## بداية سريعة

إذا كنت بحاجة إلى استخدامه ، فما عليك سوى تقديم التبعيات التالية

### مخضرم

```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### جرادل

```xml
implementation 'com.mobaijun:kjs-common:latest.version'
```

### المستودع المركزي

تم تحرير هذا المستودع بشكل متزامن[مستودع مركزي مافن](https://mvnrepository.com/artifact/com.mobaijun/kjs-common)، مرحبًا بكم في الاستخدام ، مرحبًا بكم في البدء

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## مساهمة

-   إذا كنت ترغب أيضًا في المشاركة في هذا المشروع ، فيرجى تفرع هذا المستودع وإرسال ملف العلاقات العامة بعد التعديل ، وستتم مزامنته مع هذا المستودع بعد المراجعة.

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## اتجاه

![](https://starchart.cc/mobaijun/kjs-common.svg)
