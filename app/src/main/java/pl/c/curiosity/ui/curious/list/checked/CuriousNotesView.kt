package pl.c.curiosity.ui.curious.list.checked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.curious_notes_view.*
import pl.c.curiosity.R
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.di.ViewModelProviderFactory
import pl.c.curiosity.ui.curious.item.RoundNotePreviewFragment
import pl.c.curiosity.ui.curious.list.NotesAdapter
import pl.c.curiosity.ui.utils.BaseReactiveFragment
import javax.inject.Inject

class CuriousNotesView : BaseReactiveFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val viewModel: CuriousNotesViewModel by viewModels {
        viewModelFactory
    }

    private val adapter = NotesAdapter(::openRoundDialogFragment)

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

    private fun openRoundDialogFragment(item: CuriousNote){
        val checkedNote = RoundNotePreviewFragment.newInstance(item)
        checkedNote.onClick = { curiousNote ->
            val directions = CuriousNotesViewDirections.actionCuriousNotesViewToAddCuriousNoteView(curiousNote)
            findNavController().navigate(directions)
        }
        checkedNote.show(childFragmentManager, "RoundPreviewFragment")
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAll()
    }

    companion object {
        fun newInstance() = CuriousNotesView()
    }
}