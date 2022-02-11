package service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        String regexNumber = "[0-9]+";
        String regexCurrency = "[0-6]";
        while (true) {
            System.out.println("Выберите валюту:");
            for (int i = 0; i < Currency.valuesOfCurrency.length; i++) {
                System.out.printf("%d - %s\n", i + 1, Currency.valuesOfCurrency[i][0]);
            }
            System.out.println("----------");
            System.out.println("0 - ВЫХОД");
            System.out.println();
            System.out.println("==========");
            String numberOfCurrency = scanner.next();
            if (numberOfCurrency.matches(regexCurrency)) {
                int numberOfCurrencyInt = Integer.parseInt(numberOfCurrency);
                if (numberOfCurrencyInt > 0) {
                    System.out.printf("Вы выбрали %s\n", Currency.valuesOfCurrency[numberOfCurrencyInt - 1][3]);
                } else {
                    System.out.println("Вы вышли из программы");
                    break;
                }
                while (true) {
                    System.out.println(Currency.valuesOfCurrency[numberOfCurrencyInt - 1][3]);
                    System.out.println("Введите сумму:");
                    String number = scanner.next();
                    if (number.matches(regexNumber)) {
                        System.out.println("    ===========");
                        result = Converter.outputResult(number, numberOfCurrencyInt);
                        System.out.println("||   " + result + "   ||");
                        System.out.println("    ===========");
                        System.out.println();
                        System.out.println("Для возврата в предыдущее меню введите: ВЫХОД");
                    } else {
                        if (number.equals("ВЫХОД")) break;
                        else
                            System.out.println("Введенное Вами значение не является числом или является отрицательным числом!\nПопробуйте еще раз:");
                    }
                }
                if (numberOfCurrency.equals("0")) break;
            } else
                System.out.printf("Введенное вами значение не является числом из диапазона от 0 до %d\nПопробуйте еще раз\n", Currency.valuesOfCurrency.length);
        }
    }
}