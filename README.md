# akka-http-useragent-support
[![Maven Central](https://img.shields.io/maven-central/v/com.github.dakatsuka/akka-http-useragent-support_2.12.svg)](https://search.maven.org/#search%7Cga%7C1%7Ca%3A%22akka-http-useragent-support_2.12%22) [![CircleCI](https://circleci.com/gh/dakatsuka/akka-http-useragent-support/tree/master.svg?style=svg&circle-token=09170c079413daef4f04bbd0dec014adaff7945c)](https://circleci.com/gh/dakatsuka/akka-http-useragent-support/tree/master)

This library provides a way to handle UserAgent easily with Akka HTTP using [woothee-java](https://github.com/woothee/woothee-java).

## Getting akka-http-useragent-support

akka-http-useragent-support is available in sonatype repository and it targets Akka HTTP 10.0.x. There are scala 2.11 and 2.12 compatible jars available.

```sbt
libraryDependencies += "com.github.dakatsuka" %% "akka-http-useragent-support" % "0.2.0"
```

## Usage

```scala
import com.github.dakatsuka.akka.http.useragent.UserAgentSupport._

val route = path("foo" / "bar") {
  get {
    extractUserAgent { ua =>
      ua.toString  // "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"
      ua.value     // "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"
      ua.name      // "Internet Explorer"
      ua.category  // "pc"
      ua.os        // "Windows 8.1"
      ua.version   // "11.0"
      ua.vendor    // Some("Microsoft")
      ua.osVersion // Some("NT 6.3")
    }

    optionalUserAgent {
      case Some(ua) =>
      case None     =>
    }
  }
}
```

## Authors

* Dai AKATSUKA <d.akatsuka@gmail.com>
