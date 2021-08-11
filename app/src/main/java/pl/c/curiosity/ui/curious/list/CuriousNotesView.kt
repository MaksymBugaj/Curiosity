package pl.c.curiosity.ui.curious.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.curious_notes_view.*
import pl.c.curiosity.R
import pl.c.curiosity.di.ViewModelProviderFactory
import pl.c.curiosity.ui.utils.BasicReactiveFragment
import javax.inject.Inject

class CuriousNotesView : BasicReactiveFragment() {

    companion object {
        fun newInstance() = CuriousNotesView()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val viewModel: CuriousNotesViewModel by viewModels {
        viewModelFactory
    }

    private val adapter = NotesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.curious_notes_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disposable.addAll(
            viewModel.notes.subscribe {
                adapter.update(it)
            }
        )

        rvCuriousNotes.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAll()
    }
}