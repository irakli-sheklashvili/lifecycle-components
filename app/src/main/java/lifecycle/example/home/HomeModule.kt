package lifecycle.example.home

import androidx.lifecycle.Lifecycle
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun providesView(activity: HomeActivity): HomeView? {
        return activity
    }

    @Provides
    fun providesLifecycle(activity: HomeActivity): Lifecycle {
        return activity.lifecycle
    }

    @Provides
    fun providePresenter(homeView: HomeView?, lifecycle: Lifecycle): HomePresenter {
        val homePresenter = HomePresenter(homeView)
        lifecycle.addObserver(homePresenter)
        return homePresenter
    }
}