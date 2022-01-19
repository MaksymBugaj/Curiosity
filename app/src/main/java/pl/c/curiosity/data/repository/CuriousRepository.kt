package pl.c.curiosity.data.repository

import pl.c.curiosity.data.db.dao.CuriousNoteDao
import pl.c.curiosity.data.db.entity.CuriousNote
import javax.inject.Inject

class CuriousRepository @Inject constructor(
    private val curiousNoteDao: CuriousNoteDao
) {

    fun insertCuriousNote(model: CuriousNote) = curiousNoteDao.insertReplace(model)

    fun loadAllFinishedCuriousNotes() = curiousNoteDao.selectAllFinished()

    fun loadAllToCheckCuriousNotes() = curiousNoteDao.selectAllToCheck()

    fun updateNote(note: CuriousNote) = curiousNoteDao.update(note)

    fun loadToCheckNotesCount() = curiousNoteDao.selectToCheckCount()

    fun deleteCuriousNote(curiousNote: CuriousNote) = curiousNoteDao.delete(curiousNote)
}