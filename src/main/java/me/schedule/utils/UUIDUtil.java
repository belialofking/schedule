package me.schedule.utils;

import java.util.Calendar;

/**
 *
 * @author hxy
 */
public class UUIDUtil {
    private static String lastUUID = "";
    private static String postfix = "";
    public static final long time2000 = 946656000000l;
    static{
        StringBuilder sb = new StringBuilder(Long.toString(System.nanoTime(), 32).toUpperCase());
         postfix = sb.reverse().substring(0, 3);
    }
    private static String getUUID(){
        
        long time = System.currentTimeMillis();
        long nano = System.nanoTime();
        String str_nano = Long.toString(nano, 32).toUpperCase();

        str_nano = str_nano.substring(str_nano.length() - 5);
        String str_ms = String.format("%10s", Long.toString(time, 32)).replaceAll(" ", "0").toUpperCase();
        return str_ms + str_nano + postfix;
    }
    private static final String MONTHNAME = "ABCDEFGHIJKL";
    private static String getDateID(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String str_year = String.valueOf(year);
        String str_month = String.valueOf(MONTHNAME.charAt(month));
        String str_day = Integer.toString(day, 32);
        String str_hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY), 32);
        Calendar cur = (Calendar)cal.clone();
        cur.clear(Calendar.MILLISECOND);
        cur.clear(Calendar.SECOND);
        cur.clear(Calendar.MINUTE);
        long daytime = cal.getTimeInMillis() - cur.getTimeInMillis();
        String str_daytime = String.format("%5s", Long.toString(daytime, 36)).replaceAll(" ", "0").toUpperCase();
        long nano = System.nanoTime();
        String str_nano = Long.toString(nano, 36).toUpperCase();

        str_nano = str_nano.substring(str_nano.length() - 4);
       
        return str_year + str_month + str_day + str_hour + str_daytime + str_nano + postfix;
    } 
    public static synchronized String shortID(){
        String mstr = num2Str(getLongTime(),8);
        String nstr = num2Str(System.nanoTime(),4);
        return mstr + nstr;
    }

    public static synchronized String uuid(){
        String uuid = getUUID();
        if(lastUUID.equals(uuid)){
            return uuid();
        }
        lastUUID = uuid;
        return uuid;
    }
    private static String num2Str(long num,int digit){
        num = Math.abs(num);
        String str_num = Long.toString(num, 36).toUpperCase();
        if(str_num.length() == digit){
            return str_num;
        }
        if(str_num.length() > digit){
            return str_num.substring(str_num.length() - digit);
        }
        StringBuilder repeat = new StringBuilder();
        repeat.append(str_num);
        while(repeat.length() < digit){
            repeat.insert(0, "0");
        }
        return repeat.toString();
    }
    public static synchronized  String dtid(){
        String uuid = getDateID();
        if(lastUUID.equals(uuid)){
            return dtid();
        }
        lastUUID = uuid;
        return uuid;
    }
    private static synchronized Long getLongTime(){
        return System.currentTimeMillis() - time2000;
    }


    public static void main(String[] args) {
        for (int i = 0; i <  10; i++) {
            System.out.println(dtid());
            System.out.println(uuid());
            System.out.println(shortID());
            System.out.println("============================ " + i);
        }

    }
}
