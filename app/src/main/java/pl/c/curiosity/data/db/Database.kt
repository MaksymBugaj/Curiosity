package pl.c.curiosity.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.c.curiosity.data.db.converters.DateTimeConverter
import pl.c.curiosity.data.db.dao.CuriousNoteDao
import pl.c.curiosity.data.db.entity.CuriousNote

@Database(
    entities = [
        CuriousNote::class
    ],
    version = 1
)
@TypeConverters(DateTimeConverter::class)
abstract class Database: RoomDatabase() {
    abstract fun curiousNoteDao(): CuriousNoteDao
}