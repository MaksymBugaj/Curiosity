package pl.c.curiosity.ui.utils

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseReactiveViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}