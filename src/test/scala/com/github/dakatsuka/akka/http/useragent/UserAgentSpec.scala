package com.github.dakatsuka.akka.http.useragent

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class UserAgentSpec extends FlatSpec with DiagrammedAssertions {
  behavior of "UserAgent"

  "#toString" should "return raw header string" in {
    val uaString = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"
    val ua       = UserAgent(uaString)

    assert(ua.toString == uaString)
  }

  "#isClawler" should "check if UserAgent is clawler" in {
    val uaIsClawler    = UserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
    val uaIsNotClawler = UserAgent("Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko")

    assert(uaIsClawler.isCrawler)
    assert(!uaIsNotClawler.isCrawler)
  }
}
