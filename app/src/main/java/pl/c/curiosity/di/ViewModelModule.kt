package pl.c.curiosity.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pl.c.curiosity.ui.curious.add.AddCuriousNoteViewModel
import pl.c.curiosity.ui.curious.list.checked.CuriousNotesViewModel
import pl.c.curiosity.ui.curious.list.toCheck.CuriosNoteToCheckViewModel
import pl.c.curiosity.ui.search.CuriousSearchViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CuriousSearchViewModel::class)
    abstract fun bindCuriousSearchViewModel(vm: CuriousSearchViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddCuriousNoteViewModel::class)
    abstract fun bindNewCuriousNoteViewModel(vm: AddCuriousNoteViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CuriousNotesViewModel::class)
    abstract fun bindCuriousNotesViewModel(vm: CuriousNotesViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CuriosNoteToCheckViewModel::class)
    abstract fun bindCuriosNoteToCheckViewModel(vm: CuriosNoteToCheckViewModel) : ViewModel

    //a gdyby tak zrobić viewmodel helper ktory by trzymał wszystkie viewmodele i tutaj tylko je wstrzykiwał w jakiejś pętli?

    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}