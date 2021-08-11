package pl.c.curiosity.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.joda.time.DateTime

@Entity(tableName = "curious_notes")
data class CuriousNote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String?,
    val note: String,
    val createdDate: DateTime,
    val editedDate: DateTime?,
    val url: String?,
    val isUploaded: Boolean = false
)
