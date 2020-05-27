package lifecycle.example.hello

import android.os.Handler
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


class HelloPresenter(private var helloView: HelloView?) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        helloView = null
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedFromXml onDestroy")
    }

    fun downloadStuff() {
        val handler = Handler()
        Thread {
            Thread.sleep(10000)
            handler.post {
                helloView?.onDownloadFinish()
            }
        }.start()
    }
}