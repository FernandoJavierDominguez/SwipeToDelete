package com.fernandodominguezpacheco.reign.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Story::class, Refresh::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract  class StoryDb : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    abstract fun refreshDao(): RefreshDao

}