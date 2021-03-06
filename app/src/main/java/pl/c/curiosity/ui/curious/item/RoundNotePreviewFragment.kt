package pl.c.curiosity.ui.curious.item

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.curious_note_view.*
import pl.c.curiosity.R
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.utils.RoundBottomSheet

class RoundNotePreviewFragment : RoundBottomSheet() {

    private var item: CuriousNote? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.curious_note_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item = requireArguments().getParcelable(ITEM)
        item?.let {
            notePreview_title.text = it.title
            notePreview_note.text = it.note
            notePreview_url.text = it.url
        }


    }

    companion object{
        private const val ITEM = "ITEM"
        fun newInstance(bundle: Parcelable) = RoundNotePreviewFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ITEM, bundle)
            }
        }
    }
}