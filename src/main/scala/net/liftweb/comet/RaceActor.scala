package net.liftweb.comet

import net.liftweb._ 
import http._
import http.js._
import http.js.JE._
import http.js.JsCmds._
import SHtml._ 
import util._ 
import scala.xml._

object racer extends SessionVar[RaceActor](null)

class RaceActor extends CometActor {
  
  def render = NodeSeq.Empty
  
  override def lowPriority = {
    case _ => {
      partialUpdate(Call("ping"))
    }
  }
  
  override def localSetup {
    racer(this)
  }
}

object Start
