package com.kagg.aad_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import com.kagg.aad_playground.ut_01.DataStorageFile
import com.kagg.aad_playground.ut_01.FilePlayGround

class MainActivity : AppCompatActivity() {

    val colors : MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initColors()
        val filePlayGround = FilePlayGround(this)
        /*val lst = filePlayGround.savetoFile(colors)
        val colores:MutableList<String> = filePlayGround.readFromFile()
        colores.forEach {
            Log.d("@dev",it)
        }*/

        //visualizar los colores
        //val dataStorageType = DataStorageType(this)
        /*val dataStorageType = DataStorageFile(this)
        dataStorageType.privateFileCache()
        dataStorageType.privateExternalCacheFile()
        dataStorageType.privateExternalFile()
        dataStorageType.privateFile()*/

    }

    private fun initColors(){
        colors.add("blue")
        colors.add("pink")
        colors.add("red")
        colors.add("orange")
        colors.add("grey")
    }
}