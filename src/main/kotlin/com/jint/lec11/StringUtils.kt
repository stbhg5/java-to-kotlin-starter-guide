package com.jint.lec11

// 유틸성 함수
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}