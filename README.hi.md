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

## अवलोकन

kjs-common एक जावा डेवलपमेंट बेसिक टूल क्लास लाइब्रेरी है, जो प्रोजेक्ट डेवलपमेंट में आमतौर पर इस्तेमाल होने वाले टूल्स को एनकैप्सुलेट करता है, जैसे: एन्क्रिप्शन, http रिक्वेस्ट, एपीआई इंटरफेस, आदि। इसका उद्देश्य डेवलपर्स को तेजी से और तेजी से विकसित करने में मदद करना है।

यह प्रोजेक्ट प्रोजेक्ट में आमतौर पर उपयोग किए जाने वाले उत्कृष्ट ओपन सोर्स टूल्स को एकीकृत करता है:

-   हुटूल-ऑल (सबसे व्यापक टूल क्लास)
-   लोम्बोक (सरलीकृत इकाई वर्ग)
-   मैपस्ट्रक्चर (पैरामीटर पासिंग को सरल करता है)

लक्ष्य:`无侵入性`，`轻量级`，`常用功能`，`无数次测试`，`不断完善`

> नोट: kjs-common JDK1.8 के आधार पर विकसित किया गया है। यदि आपका JDK संस्करण बहुत कम है, तो कृपया संबंधित टूल क्लास ढूंढें, संबंधित कोड कॉपी करें और उसका उपयोग करें।

## विकास करना

> 本项目计划在 2.0 版本支持 JDK 17 及以上版本，2.0 以内版本以 JDK 8 为基石，这表示未来 2.X 版本不会兼容 JDK 17 以下的项目，如果是
> JDK 17 以内项目推荐使用 2.0 以内版本

## विषयसूची

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

> सभी निर्भरताओं को नवीनतम संस्करण में समकालिक रूप से अपडेट किया जाएगा

## जल्दी शुरू

यदि आपको इसका उपयोग करने की आवश्यकता है, तो बस निम्नलिखित निर्भरताओं का परिचय दें

### maven

```xml
<dependency>
    <groupId>com.mobaijun</groupId>
    <artifactId>kjs-common</artifactId>
    <version>${latest.version}</version>
</dependency>
```

### ग्रेडल

```xml
implementation 'com.mobaijun:kjs-common:latest.version'
```

### केंद्रीय गोदाम

यह गोदाम तुल्यकालिक रूप से जारी किया गया है[मावेन केंद्रीय गोदाम](https://mvnrepository.com/artifact/com.mobaijun/kjs-common), उपयोग करने के लिए स्वागत है, शुरू करने के लिए स्वागत है

<iframe height=850 width=90% src="https://search.maven.org/search?q=com.mobaijun" frameborder=0 allowfullscreen></iframe>

## योगदान देना

-   यदि आप भी इस परियोजना में भाग लेना चाहते हैं, तो कृपया इस गोदाम को फोर्क करें, संशोधन के बाद पीआर जमा करें, और समीक्षा के बाद इसे इस गोदाम में सिंक्रनाइज़ किया जाएगा।

```bash
$ mvn clean deploy -DskipTests -P sonatype-release
```

## रुझान

![](https://starchart.cc/mobaijun/kjs-common.svg)
