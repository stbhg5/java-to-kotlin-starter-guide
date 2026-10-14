package com.lannstark.lec11;

import com.jint.lec11.StringUtilsKt;

public class Lec11Main {

    public static void main(String[] args) {
        // StringUtils.isDirectoryPath("/"); // 메서드에 static 붙이면 사용 가능
        StringUtilsKt.isDirectoryPath("/"); // 정적 메서드
    }

}