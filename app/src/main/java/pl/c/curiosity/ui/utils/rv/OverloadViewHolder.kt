package pl.c.curiosity.ui.utils.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class OverloadViewHolder<ItemType>(view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(item: ItemType) {}
}