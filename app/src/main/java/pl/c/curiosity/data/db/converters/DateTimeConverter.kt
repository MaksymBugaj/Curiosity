package pl.c.curiosity.data.db.converters

import androidx.room.TypeConverter
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class DateTimeConverter {

    @TypeConverter
    fun toTimestamp(value: DateTime?): Long?{
        return value?.millis
    }

    @TypeConverter
    fun toDateTime(value: Long?): DateTime?{
        return value?.let {
            DateTime(it, DateTimeZone.UTC)
        }
    }

}