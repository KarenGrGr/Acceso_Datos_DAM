package com.kagg.aad_playground.ut_01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File

/**
 * init se ejecuta al ejecutar la clase
 * */

class FilePlayGround (private val activity: AppCompatActivity){
    /**
     * init se ejecuta al instanciar(ejecutar) la clase creando un objeto
     * */
    init {
        //createFile()
        //writeFile()
        //readFile()
        //readLineByLine()
        //deleteFile()
    }
    fun createFile(){
        val file = File(activity.filesDir,"aad.txt")
        //Log.d("@dev",activity.filesDir.absolutePath)
    }
    fun writeFile(){
        val file = File(activity.filesDir,"aad.txt")
        file.writeText("HolaAcceso a Datos")
    }
    fun readFile(){
        val file = File(activity.filesDir,"aad.txt")
        val line = file.readText()
        Log.d("@dev",line)
    }

    fun appendText(){
        val file = File(activity.filesDir,"aad.txt")
        file.appendText("Hola 2")
        file.appendText("Hola 3")
        file.appendText("Hola 4")
        file.appendText("\n")
        file.appendText("Hola 2")
        file.appendText("Hola 3")
        file.appendText("Hola 4")
        val line = file.readText()
        Log.d("@dev",line)
    }

    fun readLineByLine(){
        val file= File(activity.filesDir,"aad.txt")
        file.writeText("linea 1")
        file.appendText("\n")
        file.appendText("linea 2")
        file.appendText("\n")
        file.appendText("linea 3")
        file.appendText("\n")
        file.appendText("line 4")
        //Log.d("@dev", file.readText())
        val lines : List<String> =file.readLines()
        lines.forEach {
            Log.d("@dev",it)
        }
    }
    fun deleteFile(){
        val file=File(activity.filesDir,"aad.txt")
        if(file.exists())
            file.delete()
    }
    fun savetoFile(colors: MutableList<String>){ /**guardar linea a linea los colores, colors.txt*/
        val file = File(activity.filesDir,"colors.txt")
        file.writeText("")
        colors.forEach {
            file.appendText("$it \n")
        }
    }
    fun readFromFile(): MutableList<String>{
        val colors = mutableListOf<String>()
        val file = File(activity.filesDir,"colors.txt")
        return file.readLines().toMutableList()
    }
}