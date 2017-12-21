import java.io.File
import java.nio.file.Files

import sbt._
import sbt.internal.inc.classpath.ClasspathUtilities


class ClojureC(val classpath: Seq[File], val stubDirectory: File, val destinationDirectory: File, logger: sbt.util.Logger) {

  lazy val oldContextClassLoader = Thread.currentThread.getContextClassLoader

  lazy val classLoader = ClasspathUtilities.toLoader(classpath)

  lazy val clojureClass = classLoader.loadClass("org.clojure.core")
  lazy val rt = classLoader.loadClass("clojure.lang.RT")

  lazy val varClass: Class[_] = classLoader.loadClass("clojure.lang.Var")
  lazy val varFunction = rt.getDeclaredMethod("var", classOf[java.lang.String], classOf[java.lang.String])
  lazy val loadResourceFunction = rt.getDeclaredMethod("loadResourceScript", classOf[java.lang.String])
  lazy val rtLoadFunction = rt.getDeclaredMethod("load", classOf[java.lang.String])
  lazy val rtInitFunction = rt.getDeclaredMethod("init")
  lazy val rtMap = rt.getDeclaredMethod("map", classOf[Array[Object]])


  def compile(files: Seq[File]): Unit = {


    IO.createDirectory(destinationDirectory)

    try {

      Thread.currentThread().setContextClassLoader(classLoader)
      //rtInitFunction.invoke(null)
      val compilerClass: Class[_] = classLoader.loadClass("clojure.lang.Compiler")

      val loadFunction = compilerClass.getDeclaredMethod("load", classOf[java.io.Reader])

      val compileFunction = compilerClass.getDeclaredMethod("compile", classOf[java.io.Reader], classOf[java.lang.String], classOf[java.lang.String])

      val associativeClass = classLoader.loadClass("clojure.lang.Associative")

      val pushTBFunction = varClass.getDeclaredMethod("pushThreadBindings", associativeClass)
      val popTBFunction = varClass.getDeclaredMethod("popThreadBindings")

      val compilePath = varFunction.invoke(null, "clojure.core", "*compile-path*")
      val compileFiles = varFunction.invoke(null, "clojure.core", "*compile-files*")

      val newMap = rtMap.invoke(null, Array(compilePath, destinationDirectory.getAbsolutePath(), compileFiles, true: java.lang.Boolean))

      pushTBFunction.invoke(null, newMap)

      files.filter(!_.isDirectory).foreach { f =>

        logger.info(s"Compiling ${f.getName}")

        compileFunction.invoke(null, new java.io.FileReader(f.getAbsolutePath()), f.getName(), f.getName())


        // Copy the source to the output directory:
        //Files.copy(f.toPath)

      }

      popTBFunction.invoke(null)

    }
    finally {
      Thread.currentThread.setContextClassLoader(oldContextClassLoader)
    }
  }
}
