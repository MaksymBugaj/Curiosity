package pl.c.curiosity.ui.curious.list.toCheck

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.curios_note_to_check_view.*
import pl.c.curiosity.R
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.di.ViewModelProviderFactory
import pl.c.curiosity.ui.curious.item.RoundNotePreviewFragment
import pl.c.curiosity.ui.curious.list.NotesAdapter
import pl.c.curiosity.ui.utils.BaseReactiveFragment
import javax.inject.Inject

class CuriousNoteToCheckView : BaseReactiveFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val viewModel: CuriosNoteToCheckViewModel by viewModels {
        viewModelFactory
    }

    private val adapter = NotesAdapter(::openRoundDialogFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.curios_note_to_check_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        disposable.addAll(
            viewModel.notes.subscribe {
                adapter.update(it)
            }
        )

        (cntcv_rv as RecyclerView).adapter = adapter
    }

    private fun openRoundDialogFragment(item: CuriousNote){
        val checkedNote = RoundNotePreviewFragment.newInstance(item)
        checkedNote.onEditClick = { curiousNote ->
            val directions = CuriousNoteToCheckViewDirections.actionCuriousNoteToCheckViewToAddCuriousNoteView(curiousNote)
            findNavController().navigate(directions)
        }
        checkedNote.onDeleteClick = { curiousNote ->
            checkedNote.dismiss()
            viewModel.deleteNote(curiousNote) }
        checkedNote.show(childFragmentManager, "RoundPreviewFragment")
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAll()
    }

    companion object {
        fun newInstance() = CuriousNoteToCheckView()
    }

}