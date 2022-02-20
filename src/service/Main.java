package service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Currency.getListOfCurrencies();
            String numberOfCurrency = scanner.next();
            if (!Currency.checkCurrency(numberOfCurrency)) break;
        }
    }
}