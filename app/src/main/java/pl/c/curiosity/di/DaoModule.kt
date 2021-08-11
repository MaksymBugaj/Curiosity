package pl.c.curiosity.di

import dagger.Module
import dagger.Provides
import pl.c.curiosity.data.db.Database

@Module
class DaoModule {

    @Provides
    fun provideCuriousNoteDao(db:Database) = db.curiousNoteDao()
}