import com.google.inject.AbstractModule
import com.google.inject.multibindings.Multibinder
import it.polentino.lib.BaseTrait
import org.reflections.Reflections

import scala.collection.JavaConverters._

class Module extends AbstractModule {

  override def configure(): Unit = {

    val multipleBinder = Multibinder.newSetBinder(binder(), classOf[BaseTrait])
    new Reflections("it.polentino.lib")
      .getSubTypesOf(classOf[BaseTrait])
      .asScala
      .foreach(aTrait => {
        println(aTrait.newInstance().getString)
        multipleBinder.addBinding().to(aTrait)
      })
  }

}