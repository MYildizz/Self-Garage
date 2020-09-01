package com.yildizmurat.service.implementation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ScheduledTasks {
    private  DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public String getTime(){

        LocalDateTime now = LocalDateTime.now();

        return dateTime.format(now);
    }

    public LocalDateTime convertStringToLocalDateTime(String stringTime){

        LocalDateTime convertedTime = LocalDateTime.parse(stringTime, dateTime);

        return convertedTime;
    }

    public String calculateTimeDifference(LocalDateTime begin,LocalDateTime end){

       long minutes = ChronoUnit.MINUTES.between(begin, end);
        String temp=""+minutes;
        return temp;
    }

    public double calculatePrice(String minute){

        double min=Double.parseDouble(minute);

        return min*0.20;
    }

}
