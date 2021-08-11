package pl.c.curiosity.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Single
import pl.c.curiosity.data.db.entity.CuriousNote

@Dao
abstract class CuriousNoteDao :BaseDao<CuriousNote>(){

    @Query("select * from curious_notes")
    abstract fun selectAll(): Single<List<CuriousNote>>
}