package pl.c.curiosity.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.c.curiosity.ui.curious.CuriousSearchViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CuriousSearchViewModel::class)
    abstract fun bindCuriousSearchViewModel(curiousSearchViewModel: CuriousSearchViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}