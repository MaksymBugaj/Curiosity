package pl.c.curiosity.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.c.curiosity.ui.NavHolder

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeNavHolder(): NavHolder
}