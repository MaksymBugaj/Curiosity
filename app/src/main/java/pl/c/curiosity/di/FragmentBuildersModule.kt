package pl.c.curiosity.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.c.curiosity.ui.curious.CuriousSearchView

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeCuriousSearchView(): CuriousSearchView
}