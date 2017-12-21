/**
  * Continually Build Angular 2 Web Bundle
  *
  */

import java.net.InetSocketAddress

import play.sbt.PlayRunHook


object AngularBundle {

  def apply(): PlayRunHook = {

    object WatchBundleHook extends PlayRunHook {

      override def beforeStarted(): Unit = {
        //TODO

      }

      override def afterStarted(addr: InetSocketAddress): Unit = {

      }

      override def afterStopped(): Unit = {

      }
    }

    WatchBundleHook
  }

}
