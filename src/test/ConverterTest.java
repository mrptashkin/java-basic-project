package test;

import service.Converter;

public class ConverterTest {

    void testingGettingIndexOfUnits() {
        String scenario = "Тест корректности работы функции gettingIndexOfUnits";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            int[] expectedOutputValues = {0, 1, 2, 3, 4, 5, 6, 7, 8};
            int[] actualOutputValues = new int[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.gettingIndexOfUnits(inputValues[i]);
                if (expectedOutputValues[i] != actualOutputValues[i]) {
                    throw new GettingIndexOfIndexException(String.format("Неверно получен индекс %d для %s\n", actualOutputValues[i], inputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    void testingGettingDecades() {
        String scenario = "Тест корректности работы функции gettingDecades";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
            String[] expectedOutputValues = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                    "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.gettingDecades(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new GettingDecadesException(String.format("Неверно преобразовано %s в %s", inputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    void testingGettingHundreds() {
        String scenario = "Тест корректности работы функции gettingHundreds";
        try {
            String[] inputValues = {"100", "220", "333", "404", "556", "678", "789", "890", "999", "6", "57"};
            String[] expectedOutputValues = {"сто", "двести двадцать", "триста тридцать три", "четыреста четыре", "пятьсот пятьдесят шесть", "шестьсот семьдесят восемь",
                    "семьсот восемьдесят девять", "восемьсот девяносто", "девятьсот девяносто девять", "шесть", "пятьдесят семь"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.gettingHundreds(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new GettingDecadesException(String.format("Неверно преобразовано %s в %s", inputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    void testingMatchingThousand() {
        String scenario = "Тест корректности работы функции matchingThousand";
        try {
            String[] inputValues = {"1", "2", "3", "4", "5", "16", "78", "101", "999"};
            String[] expectedOutputValues = {"одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шестнадцать тысяч",
                    "семьдесят восемь тысяч", "сто одна тысяча", "девятьсот девяносто девять тысяч"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.matchingThousand(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new GettingMatchingThousandException(String.format("Неверно преобразовано %s в %s, должно быть %s", inputValues[i], actualOutputValues[i], expectedOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

    void testingMatchingCurrency() {
        String scenario = "Тест корректности работы функции matchingCurrency";
        try {
            String[] inputValues = {"0", "1", "2", "3", "4", "5", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
            String[] expectedOutputValues = {"ноль рублей", "один рубль", "два рубля", "три рубля", "четыре рубля", "пять рублей", "семь рублей", "восемь рублей",
                    "девять рублей", "десять рублей", "одиннадцать рублей", "двенадцать рублей", "тринадцать рублей", "четырнадцать рублей", "пятнадцать рублей",
                    "шестнадцать рублей", "семнадцать рублей", "восемнадцать рублей", "девятнадцать рублей", "двадцать рублей"};
            String[] actualOutputValues = new String[expectedOutputValues.length];
            for (int i = 0; i < actualOutputValues.length; i++) {
                actualOutputValues[i] = Converter.matchingCurrency(inputValues[i], 1);
                if (!expectedOutputValues[i].equals(actualOutputValues[i])) {
                    throw new MatchingCurrencyException(String.format("Неверно согласовано %s в %s", expectedOutputValues[i], actualOutputValues[i]));
                }
            }
            System.out.printf("%s is passed\n", scenario);
        } catch (Throwable exception) {
            System.err.printf("%s is fails with message %s\n", scenario, exception.getMessage());
        }
    }

}