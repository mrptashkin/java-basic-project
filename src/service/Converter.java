package service;

import org.jetbrains.annotations.NotNull;

public class Converter {

    public static int gettingIndexOfUnits(String u) {
        int resultIndex = 0;
        int ui = Integer.parseInt(u);
        if (ui > 0 & ui < 10) {
            resultIndex = ui - 1;
        }
        return resultIndex;
    }

    public static String gettingDecades(@NotNull String d, int indexOfCurrency) {
        String resultDecade = "";
        String substringDecades;
        if (d.length() == 2) {
            substringDecades = d.substring(0, 1);
        } else {
            substringDecades = d;
        }
        String substringUnits = d.substring(d.length() - 1);
        int di = Integer.parseInt(d);
        switch (di / 10) {
            case 0 -> {
                if (di != 0) {
                    if (indexOfCurrency != 5) {
                        resultDecade = Numbers.uniqueNumbers1[gettingIndexOfUnits(d)];
                    } else {
                        switch (di % 10) {
                            case 1 -> resultDecade = Numbers.numberForThousandOrFemale[0];
                            case 2 -> resultDecade = Numbers.numberForThousandOrFemale[1];
                            default -> resultDecade = Numbers.uniqueNumbers1[gettingIndexOfUnits(d)];
                        }
                    }
                } else resultDecade = "ноль";
            }
            case 1 -> resultDecade = Numbers.uniqueNumbers2[di - 10];
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {
                if (di % 10 != 0) {
                    resultDecade = Numbers.decades[gettingIndexOfUnits(substringDecades) - 1] + " " +
                            Numbers.uniqueNumbers1[gettingIndexOfUnits(substringUnits)];
                } else {
                    resultDecade = Numbers.decades[gettingIndexOfUnits(substringDecades) - 1];
                }
            }
            default -> System.out.println("Что-то пошло не так в gettingDecades");
        }
        return resultDecade;
    }

    public static String gettingHundreds(String number, int indexOfCurrency) {
        String resultHundreds;
        int numberInt = Integer.parseInt(number);
        if (number.length() <= 2) {
            resultHundreds = gettingDecades(number, indexOfCurrency);
        } else {
            String substringHundreds = number.substring(number.length() - 3, number.length() - 2);
            String substringDecades = number.substring(number.length() - 2);
            if (numberInt % 100 != 0)
                if (numberInt / 100 != 0) {
                    resultHundreds = Numbers.hundreds[Integer.parseInt(substringHundreds) - 1] + " " + gettingDecades(substringDecades, indexOfCurrency);
                } else {
                    resultHundreds = gettingDecades(substringDecades, indexOfCurrency);
                }
            else {
                if (numberInt != 0) {
                    resultHundreds = Numbers.hundreds[Integer.parseInt(substringHundreds) - 1];
                } else resultHundreds = "";
            }
        }
        return resultHundreds;
    }

    static String mainConverting(@NotNull String number, int indexOfCurrency) {
        String finalResult = "";
        int numberLength = number.length();
        switch (numberLength) {
            case 1, 2, 3 -> finalResult = gettingHundreds(number, indexOfCurrency);
            case 4, 5, 6 -> {
                String substringThousand = number.substring(0, numberLength - 3);
                String substringHundreds = number.substring(numberLength - 3);
                finalResult = matchingThousand(substringThousand, indexOfCurrency) + " " + gettingHundreds(substringHundreds, indexOfCurrency);
            }
            case 7, 8, 9 -> {
                String substringMillion = number.substring(0, numberLength - 6);
                String substringThousand = number.substring(numberLength - 6, numberLength - 3);
                String substringHundreds = number.substring(numberLength - 3);
                finalResult = matchingMillion(substringMillion, indexOfCurrency) + " " + matchingThousand(substringThousand, indexOfCurrency) + " " + gettingHundreds(substringHundreds, indexOfCurrency);
            }
        }
        return finalResult;
    }

    public static String matchingCurrency(@NotNull String number, int indexOfCurrency) {
        String rightCurrency = "";
        String lastDigit = number.substring(number.length() - 1);
        if (number.length() >= 2) {
            String preLastDigit = number.substring(number.length() - 2, number.length() - 1);
            if (!preLastDigit.equals("1")) {
                switch (lastDigit) {
                    case "1" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][0];
                    case "2", "3", "4" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][1];
                    case "0", "5", "6", "7", "8", "9" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][2];
                    default -> System.out.println("Что-то пошло не так в matching...");
                }
            } else
                rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][2];
        } else {
            switch (lastDigit) {
                case "1" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][0];
                case "2", "3", "4" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][1];
                case "0", "5", "6", "7", "8", "9" -> rightCurrency = mainConverting(number, indexOfCurrency) + " " + Currency.valuesOfCurrency[indexOfCurrency - 1][2];
                default -> System.out.println("Что-то пошло не так в matching...");
            }
        }
        return rightCurrency;
    }

    public static String matchingThousand(String substringThousand, int indexOfCurrency) {
        String matchedThousand;
        int matchedThousandInt = Integer.parseInt(substringThousand);
        String hundredResult = gettingHundreds(substringThousand, indexOfCurrency);
        String thousandResult;
        if (matchedThousandInt != 0) {
            String lastDigit = substringThousand.substring(substringThousand.length() - 1);
            int lastDigitInt = Integer.parseInt(lastDigit);
            switch (lastDigitInt) {

                case 1 -> {
                    thousandResult = hundredResult.substring(0, hundredResult.length() - 4) + Numbers.numberForThousandOrFemale[0];
                    matchedThousand = thousandResult + " " + Numbers.thousand[0];
                }
                case 2 -> {
                    thousandResult = hundredResult.substring(0, hundredResult.length() - 3) + Numbers.numberForThousandOrFemale[1];
                    matchedThousand = thousandResult + " " + Numbers.thousand[1];
                }
                case 3, 4 -> matchedThousand = hundredResult + " " + Numbers.thousand[1];
                default -> matchedThousand = hundredResult + " " + Numbers.thousand[2];
            }
        } else matchedThousand = "";
        return matchedThousand;
    }


    static String matchingMillion(@NotNull String substringMillion, int indexOfCurrency) {
        String matchedMillion;
        String lastDigit = substringMillion.substring(substringMillion.length() - 1);
        String thousandResult = gettingHundreds(substringMillion, indexOfCurrency);
        int lastDigitInt = Integer.parseInt(lastDigit);
        switch (lastDigitInt) {
            case 1 -> matchedMillion = thousandResult + " " + Numbers.millions[0];
            case 2, 3, 4 -> matchedMillion = thousandResult + " " + Numbers.millions[1];
            default -> matchedMillion = thousandResult + " " + Numbers.millions[2];
        }
        return matchedMillion;
    }

    static @NotNull String finalOutput(String number, int indexOfCurrency) {
        String finalText;
        finalText = "РЕЗУЛЬТАТ: " + matchingCurrency(number, indexOfCurrency);
        return finalText;
    }

}
