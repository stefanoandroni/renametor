package com.rename;

import com.rename.model.FileMetaData;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        //in: File

        //get file as Path object
        Path file = Path.of("C:/Users/Stefano/Desktop/Fot/IMG-20220123-WA0021.jpg/");

        try {
            FileMetaData fileMetaData = new FileMetaData(file);
            System.out.println(fileMetaData.getString());

        } catch (IOException e) {
            e.printStackTrace();
        }









    }



}
