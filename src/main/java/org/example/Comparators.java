package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Comparators {
    public static List<String> compareDate(List<String> dateStrings) {
        List<Date> dates = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (String dateString : dateStrings) {
            try {
                Date date = sdf.parse(dateString);
                dates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Comparator<Date> dateComparator = new Comparator<Date>() {
            @Override
            public int compare(Date date1, Date date2) {
                boolean hasR1 = containsR(date1);
                boolean hasR2 = containsR(date2);
                if (hasR1 && !hasR2) {
                    return -1;
                } else if (!hasR1 && hasR2) {
                    return 1;
                } else {
                    return date1.compareTo(date2);
                }
            }
        };

        Collections.sort(dates, dateComparator);

        List<String> sortedDateStrings = new ArrayList<>();
        for (Date date : dates) {
            sortedDateStrings.add(sdf.format(date));
        }
        return sortedDateStrings;
    }

    private static boolean containsR(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.US);
        String month = monthFormat.format(date);
        return month.toLowerCase().contains("r");
    }
}