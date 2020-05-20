package lifecycle.example.next

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class NextPresenter : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i("Lifecycle Test", "Lifecycle Test PresenterAttachedOnClick onDestroy")
    }

}