package src.date_and_time;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAndTimeEX1 {

    public static void main(String[] args) {
      
        //create the format
        FormatStyle style = FormatStyle.SHORT;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(style);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(style);
        
        //get the date
        LocalDate date = LocalDate.now();
        
        //get the time - could use LocalTime instead of ZonedDateTime
        ZonedDateTime time = ZonedDateTime.now();
        
        //display the formatted date and time
        System.out.println(dateFormatter.format(date) + "\t" + timeFormatter.format(time));
        
        
    }
    
}
