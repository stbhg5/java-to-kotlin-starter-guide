package com.jint.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    readFile()
    readFileV2("C:\\Users\\admin\\IdeaProjects\\java-to-kotlin-starter-guide\\a.txt")
}

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다")
    }
}

fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun readFile() {
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")

    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

fun readFileV2(path: String) {
    BufferedReader(FileReader(path)).use {
        reader -> println(reader.readLine())
    }
}