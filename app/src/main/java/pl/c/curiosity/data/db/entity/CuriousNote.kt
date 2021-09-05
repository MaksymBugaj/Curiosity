package pl.c.curiosity.data.db.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

@Parcelize
@Entity(tableName = "curious_notes")
data class CuriousNote(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String?,
    val note: String,
    val createdAt: DateTime,
    val modifiedAt: DateTime?,
    val url: String?,
    val toCheck:Boolean,
    val isUploaded: Boolean = false
) : Parcelable
