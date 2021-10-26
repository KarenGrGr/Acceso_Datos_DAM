package com.kagg.aad_playground.ut02.excercise.repository

interface Model {
    fun getId() : Int
}
data class UserModel(val userId: Int, val name: String, val surname: String) : Model{
    override fun getId(): Int = userId
}