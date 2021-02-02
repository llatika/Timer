package com.Snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static FileWriter writer = null;
    static boolean stop = true;
    static String hours,hours_all;
    static Timer timer = new Timer();
    File file = new File("Timer.txt");
    File file2 = new File("Timer_all.txt");


    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        writeToFile(String.valueOf(0));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>>> ");
            int value = scanner.nextInt();

            if (value == 1) {
                if (stop) {
                    stop = false;
                    timer.startTimer();
                    System.out.print(">>>> ");
                }
            } else if (value == 0) {
                if (!stop) {
                    stop = true;
                    timer.stopTimer();
                    writeToFile(decimalFormat.format(timer.sumDuration()));
                }
            } else if (value == 9) {
                break;
            }
        }
        writeToFile(decimalFormat.format(readFromFile_all()+readFromFile()));
    }

    public static double readFromFile() {
        try {
            File myObj = new File("Timer.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                hours = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Float.parseFloat(hours);
    }

    public static double readFromFile_all() {
        try {
            File myObj = new File("Timer_all.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                hours_all = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Float.parseFloat(hours_all);
    }

    public static void writeToFile(String number) {
        try {
            writer = new FileWriter("Timer.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile_all(String number) {
        try {
            writer = new FileWriter("Timer_all.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
