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

    var onClick :((item:CuriousNote) -> Unit)? = null

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
        item?.let { item ->
            notePreview_title.text = item.title
            notePreview_note.text = item.note
            notePreview_url.text = item.url
            notePreview_editButton.setOnClickListener {
                onClick?.invoke(item)
            }
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