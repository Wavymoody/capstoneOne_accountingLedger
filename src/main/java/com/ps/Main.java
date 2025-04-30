package com.ps;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


//    static ArrayList<Product> inventory = new ArrayList<>();
//    static ArrayList<Product> cart = new ArrayList<>();
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        loadProducts();

        int homeScreenMenu;

        do {
            System.out.println("Welcome the Moody Bank");
            System.out.println("1. Add Deposit");
            System.out.println("2. Make Payment");
            System.out.println("3. Ledger");
            System.out.println("4. Exit \n Enter your choice");
            homeScreenMenu = scanner.nextInt();
            switch (homeScreenMenu) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    showLedgerScreen();
                    break;
                case 4:
                    System.out.println("Exit Program");
                    break;

                default:
                    System.out.println("Incorrect Input! Try again.");
            }
        } while (homeScreenMenu != 4);
    }

    private static void loadProducts() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] fields = input.split("\\|");

                LocalDate date = LocalDate.parse(fields[0]);
                LocalTime time = LocalTime.parse(fields[1]);
                String description = fields[2];
                String vendor = fields[3];
                double amount = Double.parseDouble(fields[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                transactions.add(transaction);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void showLedgerScreen() {
        System.out.println(" Please enter your choice");
        System.out.println("1. All");
        System.out.println("2. Deposit");
        System.out.println("3. Payment");
        System.out.println("4. Report");
        System.out.println("5. Home");

        int ledgerScreenint = scanner.nextInt();
        switch (ledgerScreenint) {
            case 1:
                displayEntries();
                break;
            case 2:
                displayDeposit();
                break;
            case 3:
                displayPayment();
                break;

            case 4:
                displayReport();
                break;

            case 5:
                displayHome();
                break;
            default:
                System.out.println("Incorrect Input! Try again.");

        }
    }

    private static void displayHome() {
    }

    private static void displayReport() {


        System.out.println("Please select a option:");
        System.out.println("1. Month To Date");
        System.out.println("2. Previous Month");
        System.out.println("3. Year To Date");
        System.out.println("4. Previous Year");
        System.out.println("5. Search by Vendor");
        System.out.println("0. Back");

        int reportint = scanner.nextInt();

        switch (reportint) {
            case 1:
                displayMonthToDate();
                break;
            case 2:
                displayPreviousMonth();
                break;
            case 3:
                displayYearToDate();
                break;
            case 4:
                displayPreviousYear();
                break;
            case 5:
                displaySearchByVendor();
                break;
            case 0:
                displayReports();
                break;


        }


    }


    private static void displayReports() {
    }

    private static void displaySearchByVendor() {
    }

    private static void displayPreviousYear() {
    }

    private static void displayYearToDate() {
    }

    private static void displayPreviousMonth() {
    }

    private static void displayMonthToDate() {
    }

    private static void displayPayment() {
    }

    private static void displayDeposit() {
    }

    private static void displayEntries() {
    }


    private static void makePayment() {
        System.out.println("Please enter payment amount");
    }

    private static void addDeposit() {
        System.out.println("Please add the deposit");
        double depositAmount = scanner.nextDouble();

        System.out.println("Please enter the date of the deposit");
        String dateOfDeposit = scanner.next();
        LocalDate depositDate = LocalDate.parse(dateOfDeposit);

        System.out.println("Please enter the time of the deposit");
        String timeOfDeposit = scanner.next();
        LocalTime depositTime = LocalTime.parse(timeOfDeposit);

        System.out.println("Please enter the description of the deposit");
        String descriptionOfDeposit = scanner.next();

        System.out.println("Please enter the name of the vendor");
        String vendorName = scanner.next();
        
        transactions.add(new Transaction(depositDate, depositTime, descriptionOfDeposit, vendorName, depositAmount));


        try {
            FileWriter fileWriter = new FileWriter("Transaction.csv");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String deposit = scanner.nextLine();

            String[] newDeposit = deposit.split(",");
            String date = newDeposit[0];
            String time = newDeposit[1];
            String description = newDeposit[2];
            String vendor = newDeposit[3];
            double amount = Double.parseDouble(newDeposit[4].trim());

            String newUserDeposit = String.format("%s|%s|%s|%s|$.2f", date, time, description, vendor, amount);


        } catch (IOException e) {
            System.out.println("Error while adding deposit");
            e.printStackTrace();


        }
    }
}



