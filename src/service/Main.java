package service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            System.out.println("Выберите валюту:");
            for (int i = 0; i < Currency.valuesOfCurrency.length; i++) {
                System.out.printf("%d - %s\n", i + 1, Currency.valuesOfCurrency[i][0]);
            }
            System.out.println("----------");
            System.out.println("0 - ВЫХОД");
            System.out.println();
            System.out.println("==========");
            int numberOfCurrency = scanner.nextInt();
            if (numberOfCurrency == 0) break;
            System.out.println("Введите сумму:");
            String number = scanner.next();
            System.out.println("    ===========");
            result = Converter.finalOutput(number, numberOfCurrency);
            System.out.println("||   " + result + "   ||");
            System.out.println("    ===========");
            System.out.println();
            if (number.equals("e")) break;
        }
    }
}