package com.github.dakatsuka.akka.http.useragent

import akka.http.javadsl.server.MissingHeaderRejection
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model.headers.`User-Agent`
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class UserAgentSupportSpec extends FlatSpec with ScalatestRouteTest with DiagrammedAssertions {
  import UserAgentSupport._

  behavior of "UserAgentSupport"

  "#extractUserAgent" should "provide UserAgent" in {
    val route = extractUserAgent { ua =>
      complete(OK -> ua.toString)
    }

    val header = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"

    Get("/").addHeader(`User-Agent`(header)) ~> route ~> check {
      assert(status == OK)
      assert(responseAs[String] == header)
    }
  }

  it should "reject when User-Agent header not found " in {
    val route = extractUserAgent { ua =>
      complete(OK -> ua.toString)
    }

    Get("/") ~> route ~> check {
      assert(!handled)
      assert(rejection.isInstanceOf[MissingHeaderRejection])
    }
  }

  "#optionalUserAgent" should "provide Option[UserAgent]" in {
    val route = optionalUserAgent {
      case Some(ua) => complete(OK -> ua.toString)
      case None     => complete(OK -> "")
    }

    val header = "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; Touch; rv:11.0) like Gecko"

    Get("/").addHeader(`User-Agent`(header)) ~> route ~> check {
      assert(status == OK)
      assert(responseAs[String] == header)
    }
  }

  it should "provide None when User-Agent header not found" in {
    val route = optionalUserAgent {
      case Some(ua) => complete(OK -> ua.toString)
      case None     => complete(OK -> "")
    }

    Get("/") ~> route ~> check {
      assert(status == OK)
      assert(responseAs[String] == "")
    }
  }
}
