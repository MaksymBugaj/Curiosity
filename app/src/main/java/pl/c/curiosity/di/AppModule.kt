package pl.c.curiosity.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import pl.c.curiosity.data.db.Database
import javax.inject.Singleton

@Module
 class AppModule {


    @Singleton
    @Provides
    fun provideDb(app: Application): Database {
        return Room.databaseBuilder(
            app as Context, Database::class.java,"database.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}