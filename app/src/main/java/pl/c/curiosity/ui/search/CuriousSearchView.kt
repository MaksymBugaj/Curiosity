package pl.c.curiosity.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import pl.c.curiosity.R
import pl.c.curiosity.di.ViewModelProviderFactory
import pl.c.curiosity.ui.utils.BasicReactiveFragment
import javax.inject.Inject

class CuriousSearchView : BasicReactiveFragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}