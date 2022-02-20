package test;

import service.Converter;
import service.Currency;

public class ConverterTest {

    static void testingGettingDecades() {
        String scenario = "Тест корректности работы функции gettingDecades";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
            String[] expectedOutputValues = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                    "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.getDecades(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new ConvertingException(String.format("Неверно преобразовано %s в %s", inputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    static void testingGettingHundreds() {
        String scenario = "Тест корректности работы функции gettingHundreds";
        try {
            String[] inputValues = {"100", "220", "333", "404", "556", "678", "789", "890", "999", "6", "57"};
            String[] expectedOutputValues = {"сто", "двести двадцать", "триста тридцать три", "четыреста четыре", "пятьсот пятьдесят шесть", "шестьсот семьдесят восемь",
                    "семьсот восемьдесят девять", "восемьсот девяносто", "девятьсот девяносто девять", "шесть", "пятьдесят семь"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.getHundreds(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new ConvertingException(String.format("Неверно преобразовано %s в %s", inputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    static void testingMatchingThousand() {
        String scenario = "Тест корректности работы функции matchingThousand";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "16", "78", "101", "999"};
            String[] expectedOutputValues = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шестнадцать тысяч",
                    "семьдесят восемь тысяч", "сто одна тысяча", "девятьсот девяносто девять тысяч"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.matchThousand(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new ConvertingException(String.format("Неверно преобразовано %s в %s, должно быть %s", inputValues[i], actualOutputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    static void testingMatchingMillion() {
        String scenario = "Тест корректности работы функции matchingMillion";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "16", "78", "101", "999"};
            String[] expectedOutputValues = {"один миллион", "два миллиона", "три миллиона", "четыре миллиона", "пять миллионов", "шестнадцать миллионов",
                    "семьдесят восемь миллионов", "сто один миллион", "девятьсот девяносто девять миллионов"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.matchMillion(inputValues[i]);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new ConvertingException(String.format("Неверно преобразовано %s в %s, должно быть %s", inputValues[i], actualOutputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    static void testingMatchingCurrency() {
        String scenario = "Тест корректности работы функции matchingCurrency";
        try {
            String[] inputValues = {"0", "1", "2", "3", "4", "5", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
            String[] expectedOutputValues = {"ноль рублей", "один рубль", "два рубля", "три рубля", "четыре рубля", "пять рублей", "семь рублей", "восемь рублей",
                    "девять рублей", "десять рублей", "одиннадцать рублей", "двенадцать рублей", "тринадцать рублей", "четырнадцать рублей", "пятнадцать рублей",
                    "шестнадцать рублей", "семнадцать рублей", "восемнадцать рублей", "девятнадцать рублей", "двадцать рублей"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.matchCurrency(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new ConvertingException(String.format("Неверно согласовано %s в %s", expectedOutputValues[i], actualOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    static void testDefineMale() {
        String scenario = "Тест корректности работы функции defineMale";
        try {
            int[] inputValues = {1, 2, 3, 4, 5, 6};
            boolean[] expectedOutputValues = {true, true, false, true, true, false};
            boolean[] actualOutputValues = new boolean[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.defineMale(inputValues[i]);
                if (expectedOutputValues[i] != actualOutputValues[i]) {
                    throw new ConvertingException(String.format("Неверно определен род для %s", Currency.getValuesOfCurrencies()[inputValues[i] - 1][1]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }

    }

}
