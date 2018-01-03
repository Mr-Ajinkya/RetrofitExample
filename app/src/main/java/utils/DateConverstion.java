package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by lenovo on 1/3/2018.
 */

public class DateConverstion {

    public static String convertDateInString(Long millis){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy", Locale.getDefault());
        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(millis);
        return simpleDateFormat.format(calender.getTime());
    }

}
