package me.schedule.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    private static final String MONTHNAME = "ABCDEFGHIJKL";
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            pnt();
        }
        //System.out.println(Long.toString(System.currentTimeMillis(),36));
    }

    private static void pnt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String str_year = String.valueOf(year);
        String str_month = Integer.toString(month +10,36);
        String str_day = Integer.toString(day, 32);
        String str_hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY), 32);
        int minute = cal.get(Calendar.MINUTE) * 10;
        int second = cal.get(Calendar.SECOND)/10;
        System.out.println(minute + second);
        System.out.println(Integer.toString(minute + second,36));

        System.out.println(sdf.format(cal.getTime()));
        System.out.println(str_year + str_month + str_day + str_hour);
        Calendar cur = (Calendar)cal.clone();
        cur.clear(Calendar.MILLISECOND);
        cur.clear(Calendar.SECOND);
        cur.clear(Calendar.MINUTE);
        long a = cur.getTimeInMillis();
        cur.set(Calendar.MINUTE,59);
        cur.set(Calendar.SECOND,59);
        System.out.println(cur.getTimeInMillis());
        System.out.println(cur.getTimeInMillis()-a);
        System.out.println(System.currentTimeMillis() - cur.getTimeInMillis());

        System.out.println("===========================================");
    }
}
