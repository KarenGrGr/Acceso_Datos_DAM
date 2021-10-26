package com.kagg.aad_playground.ut02.excercise.repository

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kagg.aad_playground.R

interface Datasource<T : Model> {
    fun save(model: List<T>)
    fun fetch(id: Int):T?
    fun fetchAll(): List<T>?
}

class MemDataSource<T: Model> : Datasource<T> {
    private val memDataStorage: MutableList<T> = mutableListOf()
    override fun save(model: List<T>) {
        memDataStorage.addAll(model)
        /* Igual que esto:
        model.forEach {
            memDataStorage.add(it)
        }
        */
    }

    override fun fetch(id: Int): T? {
        memDataStorage.forEach {
            if(it.getId()==id){
                return it
            }
        }
        return null
    }

    override fun fetchAll(): List<T>? {
        return memDataStorage.toList()
    }

}
class SharePrefsDataSource<T: Model> (private val context: AppCompatActivity): Datasource<T> {

    private val gson= Gson()
    /*type token por cada modelo que vayamos a usar */
    private val type= object : TypeToken<UserModel>() {}.type
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.preference_file_key), Context.MODE_PRIVATE
    )

    override fun save(model: List<T>) {
        val edit = sharedPref.edit()
        model.forEach {
            edit?.putString(it.getId().toString(), gson.toJson(it))
        }
        edit?.apply()
    }

    override fun fetch(id: Int): T? {
        val allModels = fetchAll()
        allModels.forEach {
            if (it.getId() == id) {
                return it
            }
        }
        return null
    }

    override fun fetchAll(): List<T> {
        val allModels: MutableList<T> = mutableListOf()

        sharedPref.all?.values?.forEach {
            allModels.add(gson.fromJson(it as String, type))
        }
        return allModels.toList()
    }

}