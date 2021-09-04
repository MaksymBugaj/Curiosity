package pl.c.curiosity.ui.curious.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_curious_note_view.*
import pl.c.curiosity.R
import pl.c.curiosity.databinding.AddCuriousNoteViewBinding
import pl.c.curiosity.di.ViewModelProviderFactory
import pl.c.curiosity.ui.showMaterialDialog
import pl.c.curiosity.ui.utils.BaseReactiveFragment
import javax.inject.Inject

class AddCuriousNoteView : BaseReactiveFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private val addCuriousNoteViewModel by viewModels<AddCuriousNoteViewModel> {
        viewModelFactory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        AddCuriousNoteViewBinding.inflate(inflater, container, false).apply {
            viewModel = addCuriousNoteViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddNote.setOnClickListener {
            addCuriousNoteViewModel.save(newNoteView_checkBoxToCheck.isChecked)
        }

        disposable.addAll(
            addCuriousNoteViewModel.close.subscribe {
                findNavController().navigate(R.id.action_addCuriousNoteView_to_curiousNotesView)
            },
            addCuriousNoteViewModel.emptyNote.subscribe {
                context?.let { ctx -> showMaterialDialog(ctx, R.string.empty_note) }
            }
        )

    }
}