package service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Currencies.getListOfCurrencies();
            String numberOfCurrency = scanner.next();
            if (!Currencies.isCurrencyCorrect(numberOfCurrency)) break;
        }
    }
}