package lifecycle.example.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import lifecycle.example.GlobalApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    BuilderModule::class])
interface AppComponent : AndroidInjector<GlobalApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<GlobalApplication>

}
