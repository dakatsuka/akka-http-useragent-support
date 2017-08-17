package com.github.dakatsuka.akka.http.useragent

import akka.http.scaladsl.server.Directive1
import akka.http.scaladsl.server.Directives._

trait UserAgentSupport {
  def extractUserAgent: Directive1[UserAgent] = headerValueByName("User-Agent").flatMap { header =>
    provide(UserAgent(header))
  }

  def optionalUserAgent: Directive1[Option[UserAgent]] = optionalHeaderValueByName("User-Agent").flatMap {
    case Some(header) => provide(Some(UserAgent(header)))
    case None         => provide(None)
  }
}

object UserAgentSupport extends UserAgentSupport
