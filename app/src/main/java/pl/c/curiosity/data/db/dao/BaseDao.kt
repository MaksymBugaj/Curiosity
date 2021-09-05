package pl.c.curiosity.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable

abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertReplace(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertReplace(vararg obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertReplace(obj: List<T>): Completable

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract fun insertAbort(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract fun insertAbort(vararg obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract fun insertAbort(obj: List<T>): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnore(obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnore(vararg obj: T): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertIgnore(obj: List<T>): Completable

    @Update()
    abstract fun update(obj: T): Completable

    @Insert()
    abstract fun update(vararg obj: T): Completable

    @Insert()
    abstract fun update(obj: List<T>): Completable

    @Delete
    abstract fun delete(obj: T): Completable

    @Delete
    abstract fun delete(vararg obj: T): Completable

    @Delete
    abstract fun delete(obj: List<T>): Completable
}