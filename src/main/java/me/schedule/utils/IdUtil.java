package me.schedule.utils;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class IdUtil {

    private String lastTimeStr = "";
    private int sequence = 0;
    static IdUtil instance = new IdUtil();

    public static IdUtil getInstance() {
        return instance;
    }

    private void IdUtil() {
    }

    private synchronized String generateId() {
        StringBuilder sb = generateDtStr();
        while (sb.toString().equals(lastTimeStr) && sequence >= 36) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            sb = generateDtStr();
        }
        if (!sb.toString().equals(lastTimeStr)) {
            lastTimeStr = sb.toString();
            sequence = 0;
        }
        sb.append(Integer.toString(sequence, 36));
        sequence++;
        return sb.toString().toUpperCase();
    }

    private StringBuilder generateDtStr() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR) - 2010;
        int month = cal.get(Calendar.MONTH) + 10;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int millisecond = cal.get(Calendar.MILLISECOND);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(year, 36)); //年
        sb.append(Integer.toString(month, 36)); //月
        sb.append(Integer.toString(day, 36)); //
        sb.append(Integer.toString(hour, 36)); //
        int ms = minute * 60 + second / 10;
        sb.append(rightSubString("00" + Integer.toString(ms, 36), 2)); //
        int sm = (second % 10) * 1000 + millisecond;
        sb.append(rightSubString("000" + Integer.toString(sm, 36), 3)); //
        return sb;
    }

    private String rightSubString(String value, int length) {
        if (value.length() == length) {
            return value;
        }
        if (value.length() < length) {
            return value;
        }
        return value.substring(value.length() - length);
    }

    public static String nextId() {
        return instance.generateId();
    }


}
