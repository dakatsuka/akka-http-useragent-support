package jp.dakatsuka.akka.http.useragent

import is.tagomor.woothee.Classifier

case class UserAgent(
  raw: String,
  name: String,
  category: String,
  os: String,
  version: String,
  osVersion: Option[String],
  vendor: Option[String]
) {
  override def toString: String = raw
  def isCrawler: Boolean = Classifier.isCrawler(raw)
}
