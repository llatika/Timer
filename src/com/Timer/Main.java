package com.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static FileWriter writer = null;
    static boolean stop = true, readTheory;
    static String hours, hours_all, hours_theory;
    static Timer timer = new Timer();

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        int value;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>>> ");
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                value = -1;
            }

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
                    writeToFile(decimalFormat.format(readFromFile() + timer.sumDuration()));
                }
            } else if (value == 2) {
                if (stop) {
                    stop = false;
                    readTheory = true;
                    timer.startTimer();
                    System.out.print(">>>> ");
                }
            } else if (value == 3) {
                if (!stop) {
                    stop = true;
                    timer.stopTimer();
                    writeToFile_theory(decimalFormat.format(readFromFile_theory() + timer.sumDuration()));
                }
            } else if (value == 6711) {
                writeToFile(Integer.toString(0));
                writeToFile_theory(Integer.toString(0));
                writeToFile_all(Integer.toString(0));
            } else if (value == 9) {
                break;
            }
        }

        if (readTheory) {
            writeToFile_all(decimalFormat.format(readFromFile_all() + readFromFile_theory()));
        } else {
            writeToFile_all(decimalFormat.format(readFromFile_all() + readFromFile()));
        }

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

    public static double readFromFile_theory() {
        try {
            File myObj = new File("Timer_theory.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                hours_theory = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return Float.parseFloat(hours_theory);
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

    public static void writeToFile_theory(String number) {
        try {
            writer = new FileWriter("Timer_theory.txt");
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
