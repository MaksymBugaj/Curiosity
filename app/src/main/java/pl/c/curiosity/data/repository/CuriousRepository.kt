package pl.c.curiosity.data.repository

import pl.c.curiosity.data.db.dao.CuriousNoteDao
import pl.c.curiosity.data.db.entity.CuriousNote
import javax.inject.Inject

class CuriousRepository @Inject constructor(
    private val curiousNoteDao: CuriousNoteDao
) {

    fun insertCuriousNote(model: CuriousNote) = curiousNoteDao.insertReplace(model)

    fun loadAllCuriousNotes() = curiousNoteDao.selectAll()
}