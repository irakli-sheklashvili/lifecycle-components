package lifecycle.example

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import lifecycle.example.dagger.DaggerAppComponent

class GlobalApplication : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<GlobalApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}