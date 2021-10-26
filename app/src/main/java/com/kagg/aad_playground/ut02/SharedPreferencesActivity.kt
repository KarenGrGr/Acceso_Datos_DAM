package com.kagg.aad_playground.ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kagg.aad_playground.R

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        initExample1()
    }
    private fun initExample1(){
        /*necesita el contexto de appCompatActivity*/
        val localDataSource= LocalDataSource(this)
        localDataSource.saveAsync("key","value")
    }
}