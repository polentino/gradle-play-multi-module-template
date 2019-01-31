package controllers

import it.polentino.lib.BaseTrait
import javax.inject._
import play.api.mvc._

@Singleton
class LibController @Inject()(traits: java.util.Set[BaseTrait])
  extends Controller {

  def index = Action {
    Ok(s"Traits found in classpath: ${traits.size()}")
  }
}