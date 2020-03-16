package com.song.util.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {



    public static Date stringToDate(String registTime, String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(s);
        Date date = null;
        try {
            date = simpleDateFormat.parse(registTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DateToFormat(String date, String s) {
        SimpleDateFormat dsf = new SimpleDateFormat(s);
        return dsf.format(date);
    }
}
