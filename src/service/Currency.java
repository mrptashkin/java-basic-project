package service;

import java.util.Scanner;

public class Currency {
    private static final String[][] VALUES_OF_CURRENCIES = {
            {"рубль", "рубля", "рублей", "РУБЛИ:"},
            {"доллар", "доллара", "долларов", "ДОЛЛАРЫ:"},
            {"лира", "лиры", "лир", "ЛИРЫ"},
            {"евро", "евро", "евро", "ЕВРО:"},
            {"юань", "юаня", "юаней", "ЮАНИ:"},
            {"йена", "йены", "йен", "ЙЕНЫ:"}
    };

    private final static String[] FEMALE_CURRENCIES = {"лира", "йена"};

    public static String[][] getValuesOfCurrencies() {
        return VALUES_OF_CURRENCIES;
    }

    public static String[] getFemaleCurrencies() {
        return FEMALE_CURRENCIES;
    }

    public static void getListOfCurrencies() {
        System.out.println("Выберите валюту:");
        for (int i = 0; i < getValuesOfCurrencies().length; i++) {
            System.out.printf("%d - %s\n", i + 1, Currency.getValuesOfCurrencies()[i][0]);
        }
        System.out.println("----------");
        System.out.println("0 - ВЫХОД");
        System.out.println();
        System.out.println("==========");
    }

    public static boolean getSelectedCurrency(int index) {
        if (index > 0) {
            System.out.printf("Вы выбрали %s\n", Currency.getValuesOfCurrencies()[index - 1][3]);
            return true;
        } else {
            System.out.println("Вы вышли из программы");
            return false;
        }
    }

    public static boolean getNumberOfCurrency(int numberOfCurrencyInt) {
        System.out.println(getValuesOfCurrencies()[numberOfCurrencyInt - 1][3]);
        System.out.println("Введите сумму иди введите \"ВЫХОД\" или \"EXIT\" для возврата в предыдущее меню:");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        if (Converter.getOutputResult(number, numberOfCurrencyInt).equals("EXIT")) return false;
        else {
            System.out.println(Converter.getOutputResult(number, numberOfCurrencyInt));
            return true;
        }
    }

    public static boolean checkCurrency(String numberOfCurrency) {
        String regexCurrency = "[0-6]";
        if (numberOfCurrency.matches(regexCurrency)) {
            int numberOfCurrencyInt = Integer.parseInt(numberOfCurrency);
            if (getSelectedCurrency(numberOfCurrencyInt)) {
                while (true) {
                    if (!getNumberOfCurrency(numberOfCurrencyInt)) break;
                }
            } else return false;
            return true;
        } else
            System.out.printf("Введенное вами значение не является числом из диапазона от 0 до %d\nПопробуйте еще раз\n", getValuesOfCurrencies().length);
        return true;
    }

}
