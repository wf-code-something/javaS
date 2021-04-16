package com.day.day.up.main.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author wf
 */
public class TestService {

    public static void main(String[] args) throws Exception {

        File file = new File("/Users/admin/IdeaProjects/untitled/src/main/java/com/day/day/up/main/service/impl/Apple.java");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder classText = new StringBuilder();
        String tempString = null;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            classText.append(tempString);
            line++;
        }
        reader.close();
    }

}
