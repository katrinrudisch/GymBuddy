package com.katrinrudisch.gymbuddy.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katrinrudisch.gymbuddy.models.Plan

@Database(entities = [Plan::class], version = 1)
abstract class GymBuddyDatabase : RoomDatabase() {
    abstract fun planDao(): PlanDao
}