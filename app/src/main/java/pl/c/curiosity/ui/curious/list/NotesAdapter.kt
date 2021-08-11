package pl.c.curiosity.ui.curious.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.note_adapter_item.view.*
import pl.c.curiosity.R
import pl.c.curiosity.data.db.entity.CuriousNote
import pl.c.curiosity.ui.utils.rv.OverloadAdapter
import pl.c.curiosity.ui.utils.rv.OverloadViewHolder

class NotesAdapter: OverloadAdapter<CuriousNote>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OverloadViewHolder<CuriousNote> {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_adapter_item, parent, false))
    }

    override fun itemComparator(oldItem: CuriousNote, newItem: CuriousNote): Boolean = oldItem.id == newItem.id

    private inner class ItemViewHolder(view: View) : OverloadViewHolder<CuriousNote>(view) {

        override fun bind(item: CuriousNote) {
            itemView.noteAdapterItem_noteTitle.text = item.title ?: "-"
            itemView.noteAdapterItem_noteDate.text = item.createdDate.toString("HH:mm")
            itemView.noteAdapterItem_note.text = item.note
            itemView.noteAdapterItem_url.text = item.url
        }
    }

}


