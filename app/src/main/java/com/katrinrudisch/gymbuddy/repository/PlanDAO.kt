package com.katrinrudisch.gymbuddy.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.katrinrudisch.gymbuddy.models.Plan

@Dao
interface PlanDao {
    @Query("SELECT * FROM plan")
    fun getAll(): List<Plan>

    @Insert
    fun insert(plan: Plan)

    @Delete
    fun delete(plan: Plan)
}