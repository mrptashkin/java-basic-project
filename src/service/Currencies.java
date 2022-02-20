package service;

import java.util.Scanner;

public class Currencies {
    public static final String[][] VALUES_OF_CURRENCIES = {
            {"рубль", "рубля", "рублей", "РУБЛИ:"},
            {"доллар", "доллара", "долларов", "ДОЛЛАРЫ:"},
            {"лира", "лиры", "лир", "ЛИРЫ"},
            {"евро", "евро", "евро", "ЕВРО:"},
            {"юань", "юаня", "юаней", "ЮАНИ:"},
            {"йена", "йены", "йен", "ЙЕНЫ:"}
    };

    public final static String[] FEMALE_CURRENCIES = {"лира", "йена"};


    public static void getListOfCurrencies() {
        System.out.println("Выберите валюту:");
        for (int i = 0; i < VALUES_OF_CURRENCIES.length; i++) {
            System.out.printf("%d - %s\n", i + 1, Currencies.VALUES_OF_CURRENCIES[i][0]);
        }
        System.out.println("----------");
        System.out.println("0 - ВЫХОД");
        System.out.println();
        System.out.println("==========");
    }

    public static boolean isSelectedCurrencyCorrect(int index) {
        if (index > 0) {
            System.out.printf("Вы выбрали %s\n", Currencies.VALUES_OF_CURRENCIES[index - 1][3]);
            return true;
        } else {
            System.out.println("Вы вышли из программы");
            return false;
        }
    }

    public static boolean isNumberOfCurrencyCorrect(int numberOfCurrencyInt) {
        System.out.println(VALUES_OF_CURRENCIES[numberOfCurrencyInt - 1][3]);
        System.out.println("Введите сумму иди введите \"ВЫХОД\" или \"EXIT\" для возврата в предыдущее меню:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        if (Converter.getOutputResult(number, numberOfCurrencyInt).equals("EXIT")) return false;
        else {
            System.out.println(Converter.getOutputResult(number, numberOfCurrencyInt));
            return true;
        }
    }

    public static boolean isCurrencyCorrect(String numberOfCurrency) {
        String regexCurrency = "[0-6]";
        if (numberOfCurrency.matches(regexCurrency)) {
            int numberOfCurrencyInt = Integer.parseInt(numberOfCurrency);
            if (isSelectedCurrencyCorrect(numberOfCurrencyInt)) {
                while (true) {
                    if (!isNumberOfCurrencyCorrect(numberOfCurrencyInt)) break;
                }
            } else return false;
            return true;
        } else
            System.out.printf("Введенное вами значение не является числом из диапазона от 0 до %d\nПопробуйте еще раз\n", VALUES_OF_CURRENCIES.length);
        return true;
    }

}
