package com.rename;

import com.rename.model.FileMetaData;
import com.rename.model.Folder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        //From CONFIG
        String IN_PATH = "C:/Users/Stefano/Desktop/Fot";
        String OUT_PATH = "C:/Users/Stefano/Desktop/Ciao";

        OUT_PATH = createDir(OUT_PATH);

        Folder inFolder = new Folder(IN_PATH);
        Folder outFolder = new Folder(OUT_PATH);

        int i = 0;
        for(File file : inFolder.getFiles()){
            FileMetaData fileMetaData = null;
            try {
                fileMetaData = new FileMetaData(file.getAbsolutePath());
                //Copy into new folder and rename
                System.out.println(fileMetaData.getString());

            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    private static String createDir(String stringPath) throws IOException {
        File dir = new File(stringPath);
        if(dir.isDirectory()){
            throw new RuntimeException("Folder already exists at path '" + stringPath + "'");
        }
        Path path = Paths.get(stringPath);
        Files.createDirectory(path);
        return path.toString();
    }

}
