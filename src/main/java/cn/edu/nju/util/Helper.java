package cn.edu.nju.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author Qiang
 * @since 01/03/2017
 */
public class Helper {

    public static Timestamp getTimeStamp(String time) {
        return Timestamp.valueOf(time + " 00:00:00.0");
    }

    public static List<Integer> getLevelAndDiscount(int accumulate) {
        List<Integer> levelAndDiscount = new ArrayList<>(2);

        int[] split = {1000, 2000, 5000, 10000, 100000};
        int[] discount = {2, 3, 5, 8, 10, 20};

        for (int i = 0; i < split.length; i++) {
            if (accumulate < split[i]) {
                levelAndDiscount.add(i);
                levelAndDiscount.add(discount[i]);
                break;
            }


        }

        if (levelAndDiscount.isEmpty()) { // highest level
            levelAndDiscount.add(split.length);
            levelAndDiscount.add(25);   // highest discount
        }


        return levelAndDiscount;

    }


    public static String timeToDateString(Timestamp time) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        return fmt.format(time);
    }
}
