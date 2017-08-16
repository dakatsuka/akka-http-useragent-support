package jp.dakatsuka.akka.http.useragent

import akka.http.scaladsl.server.Directive1
import akka.http.scaladsl.server.Directives._
import is.tagomor.woothee.Classifier

import scala.collection.JavaConverters._

trait UserAgentSupport {
  def extractUserAgent: Directive1[UserAgent] = headerValueByName("User-Agent").flatMap { header =>
    provide(makeUserAgent(header))
  }

  def optionalUserAgent: Directive1[Option[UserAgent]] = optionalHeaderValueByName("User-Agent").flatMap {
    case Some(header) => provide(Some(makeUserAgent(header)))
    case None         => provide(None)
  }

  private def makeUserAgent(header: String): UserAgent = {
    val result = Classifier.parse(header).asScala

    UserAgent(
      raw = header,
      name = result.getOrElse("name", "UNKNOWN"),
      category = result.getOrElse("category", "UNKNOWN"),
      os = result.getOrElse("os", "UNKNOWN"),
      version = result.getOrElse("version", "UNKNOWN"),
      osVersion = result.get("os_version"),
      vendor = result.get("vendor")
    )
  }
}

object UserAgentSupport extends UserAgentSupport
