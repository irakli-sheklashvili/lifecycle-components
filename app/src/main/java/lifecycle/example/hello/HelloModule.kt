package lifecycle.example.hello

import androidx.lifecycle.Lifecycle
import dagger.Module
import dagger.Provides
import lifecycle.example.home.HomeActivity

@Module
class HelloModule {

    @Provides
    fun providesView(fragment: HelloFragment): HelloView? {
        return fragment
    }

    @Provides
    fun providesLifecycle(fragment: HelloFragment): Lifecycle {
        return fragment.lifecycle
    }

    @Provides
    fun providePresenter(helloView: HelloView?, lifecycle: Lifecycle): HelloPresenter {
        val presenter = HelloPresenter(helloView)
        lifecycle.addObserver(presenter)
        return presenter
    }

}