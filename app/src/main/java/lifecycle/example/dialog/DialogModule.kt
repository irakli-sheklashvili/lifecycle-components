package lifecycle.example.dialog

import dagger.Module
import dagger.Provides

@Module
class DialogModule {

    @Provides
    fun providesPresenter(): DialogPresenter {
        return DialogPresenter()
    }
}