package pl.c.curiosity.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.c.curiosity.ui.curious.list.CuriousNotesView
import pl.c.curiosity.ui.curious.add.AddCuriousNoteView
import pl.c.curiosity.ui.search.CuriousSearchView

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeCuriousSearchView(): CuriousSearchView

    @ContributesAndroidInjector
    abstract fun contributeNewCuriousNoteView(): AddCuriousNoteView

    @ContributesAndroidInjector
    abstract fun contributeCuriousNotesView(): CuriousNotesView
}