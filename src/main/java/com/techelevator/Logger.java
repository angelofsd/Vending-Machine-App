package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;







public class Logger {
    public static void main(String[] args) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
    }
    public void log(){
        String fileName = "log.txt";
        try(PrintWriter fileWriter = new PrintWriter(new File(fileName))){
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            String formattedDateTime = currentDate.format(formatter);
            



        }catch(Exception ex){
            System.out.println("Something went wrong when writing to file.");
        }
    }
}
