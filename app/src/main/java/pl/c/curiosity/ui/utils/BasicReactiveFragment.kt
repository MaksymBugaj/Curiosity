package pl.c.curiosity.ui.utils

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

open class BasicReactiveFragment : DaggerFragment(){

    protected lateinit var disposable: CompositeDisposable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        disposable = CompositeDisposable()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }
}