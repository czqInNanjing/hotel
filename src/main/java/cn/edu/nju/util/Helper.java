package cn.edu.nju.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.IntSummaryStatistics;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public class Helper {

    public static Timestamp getTimeStamp(String time) {
        return Timestamp.valueOf(time + " 00:00:00.0");
    }

}
