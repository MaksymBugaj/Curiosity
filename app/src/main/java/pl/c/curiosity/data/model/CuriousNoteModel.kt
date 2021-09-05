package pl.c.curiosity.data.model

import org.joda.time.DateTime
import pl.c.curiosity.data.db.entity.CuriousNote

data class CuriousNoteModel(
    val id: Int,
    val note: String,
    val createdDate: DateTime,
    val editedDate: DateTime?,
    val url: String?,
    val isUploaded: Boolean = false

) {
    constructor(model: CuriousNote) : this(
        id = model.id,
        note = model.note,
        createdDate = model.createdAt,
        editedDate = model.modifiedAt,
        url = model.url,
        isUploaded = model.isUploaded
    )
}
