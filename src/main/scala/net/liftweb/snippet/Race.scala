package net.liftweb.snippet

import net.liftweb._
import net.liftweb.comet._
import http._
import http.js._
import http.js.JsCmds._
import http.js.JE._
import SHtml._ 
import util._ 
import util.Helpers._
import scala.xml._

object random extends java.security.SecureRandom()
class Race {
  
  def start(xml: NodeSeq): NodeSeq = ajaxButton(Text("Start"), { () =>
    JsFor(JsRaw("var i = 0"), JsLt(JsVar("i"), JsRaw("50")), JsRaw("i++"), Call("pong"))
  })
  
  def script(xml: NodeSeq): NodeSeq = {
    val raceActor = racer.is
    println(raceActor)
    Script(Function("pong", Nil, ajaxCall(JsNull, { _: String => 
    raceActor ! () 
    JsRaw("""window.console && console.log("sent pong")""") })._2))
  }

}
