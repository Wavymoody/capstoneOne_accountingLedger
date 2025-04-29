package com.ps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


//    static ArrayList<Product> inventory = new ArrayList<>();
//    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
//        loadProducts();

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

                default:
                    System.out.println("Incorrect Input! Try again.");
            }
        } while (homeScreenMenu != 4);
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