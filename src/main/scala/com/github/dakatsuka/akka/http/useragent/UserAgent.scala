package com.github.dakatsuka.akka.http.useragent

import is.tagomor.woothee.Classifier

import scala.collection.JavaConverters._

case class UserAgent(
    value: String,
    name: String,
    category: String,
    os: String,
    version: String,
    osVersion: Option[String],
    vendor: Option[String]
) {
  override def toString: String = value
  def isCrawler: Boolean        = Classifier.isCrawler(value)
}

object UserAgent {
  def apply(header: String): UserAgent = {
    val result = Classifier.parse(header).asScala

    UserAgent(
      value = header,
      name = result.getOrElse("name", "UNKNOWN"),
      category = result.getOrElse("category", "UNKNOWN"),
      os = result.getOrElse("os", "UNKNOWN"),
      version = result.getOrElse("version", "UNKNOWN"),
      osVersion = result.get("os_version"),
      vendor = result.get("vendor")
    )
  }
}
