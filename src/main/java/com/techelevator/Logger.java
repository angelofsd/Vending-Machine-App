package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;







public class Logger {
    private VendingMachine vendingMachine;

    public Logger(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public static void main(String[] args) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
    }
    public void log(double currency, double newBalance, String transactionType){
        String fileName = "log.txt";
        try(PrintWriter fileWriter = new PrintWriter(new FileOutputStream(new File(fileName),true))){
            LocalDateTime currentDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            String formattedDateTime = currentDate.format(formatter);
            fileWriter.println( formattedDateTime + " " + transactionType +":" + " " + "$" + currency  + " " + "$" + newBalance);
        }catch(Exception ex){
            System.out.println("Something went wrong when writing to file.");
        }
    }

}
