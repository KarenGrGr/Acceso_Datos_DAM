package com.kagg.aad_playground.ut_01

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.deleteIfExists
import kotlin.io.path.exists

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
        createFolder()
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
        val colors = mutableListOf<String>() //sobra porque no estoy usandolo con el modo abreviado
        val file = File(activity.filesDir,"colors.txt")
        if(!file.exists()){
            return colors //que es un mutableList vacío como lo declaramos
        }
        return file.readLines().toMutableList()
    }
    //fun readFromFile()= File(activity.filesDir,"colors.txt").readLines().toMutableList()
    //hay que comprobar si existe o no en caso de no saberlo :)

    //para crear carpetas
    fun createFolder(){
        //val path = Path(activity.filesDir.canonicalPath, "/documents")
        //path.deleteIfExists() //si existe la elimina sino no hace nada
        //path.createDirectory()
        /*if(path.exists()){
            Log.d("@dev","Folder exist")
        }*/
        //opcion 1
        val file =File(activity.filesDir, "/docs")
        file.mkdir()

       /* val file =File(activity.filesDir, "/docs")
       if (version .... ){
            Files.createDirectory(Path(""))
        }*/

    }
    fun createFileInFolder(){
        val file = File(activity.filesDir.canonicalPath, "/documents")
        file.writeText("Hola!")
        //file.createNewFile()
    }
}