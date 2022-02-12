package com.rename.model;

import java.io.File;
import java.util.Arrays;

public class Folder {
    private String path;

    public Folder(String path) {
        this.path = path;
    }

    public File[] getFiles() {
        File dir = new File(this.path);
        return dir.listFiles();
    }

    @Override
    public String toString() {
        return "Folder{" +
                "path='" + path + '\'' +
                '}';
    }
}
