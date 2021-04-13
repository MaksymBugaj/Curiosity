package pl.c.curiosity.ui.curious

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.android.support.DaggerFragment
import pl.c.curiosity.R
import pl.c.curiosity.di.ViewModelProviderFactory
import javax.inject.Inject

class CuriousSearchView : DaggerFragment() {

    companion object {
        fun newInstance() = CuriousSearchView()
    }

    @Inject
    lateinit var viewModelProvider: ViewModelProviderFactory

    private val viewModel: CuriousSearchViewModel by viewModels {
        viewModelProvider
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.curious_searches_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}