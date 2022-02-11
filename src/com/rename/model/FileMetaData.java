package com.rename.model;

import com.rename.util.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;

public class FileMetaData {
    private Calendar calendar;

    public FileMetaData(Path file) throws IOException {
        //get attributes
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime fileTime = attr.creationTime();
        //convert from FileTime to Date
        Date date = new Date(fileTime.toMillis());
        //convert from Date to Calendar
        this.calendar = toCalendar(date);
    }

    /*
     *** PUBLIC ***
     */

    public String getString(){
        return fillWith("0", getDay(),2) + Constants.DATE_SEPARATOR +
               fillWith("0", getMonth(), 2) + Constants.DATE_SEPARATOR + getYear();
    }

    public int getDay(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth(){
        return calendar.get(Calendar.MONTH) + 1; //indexs from 0
    }

    public int getYear(){
        return calendar.get(Calendar.YEAR);
    }

    /*
    *** PRIVATE ***
    */

    private static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    private static String fillWith(String with, int digitToFill, int lengthToFill){
        String out = String.valueOf(digitToFill);
        while(out.length()<lengthToFill){
            out = "0" + out;
        }
        return out;
    }


}
