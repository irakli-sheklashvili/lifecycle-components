package lifecycle.example.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import lifecycle.example.dialog.DialogFragment
import lifecycle.example.dialog.DialogModule
import lifecycle.example.hello.HelloFragment
import lifecycle.example.hello.HelloModule
import lifecycle.example.home.HomeActivity
import lifecycle.example.home.HomeModule
import lifecycle.example.next.NextFragment
import lifecycle.example.next.NextModule

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = [DialogModule::class])
    abstract fun dialogFragment(): DialogFragment

    @ContributesAndroidInjector(modules = [HelloModule::class])
    abstract fun helloFragment(): HelloFragment

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [NextModule::class])
    abstract fun nextFragment(): NextFragment
}