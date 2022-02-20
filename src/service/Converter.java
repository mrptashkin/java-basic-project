package service;

import org.jetbrains.annotations.NotNull;

public class Converter {

    public static String getDecades(@NotNull String d, int indexOfCurrency) {
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
                    if (isMale(indexOfCurrency)) {
                        resultDecade = Numbers.UNIQUE_UNITS[di - 1];
                    } else {
                        switch (di % 10) {
                            case 1 -> resultDecade = Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[0];
                            case 2 -> resultDecade = Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[1];
                            default -> resultDecade = Numbers.UNIQUE_UNITS[di - 1];
                        }
                    }
                } else resultDecade = "ноль";
            }
            case 1 -> resultDecade = Numbers.UNIQUE_DECADES[di - 10];
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {
                if (isMale(indexOfCurrency)) {
                    if (di % 10 != 0) {
                        resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2] + " " +
                                Numbers.UNIQUE_UNITS[Integer.parseInt(substringUnits) - 1];
                    } else {
                        resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2];
                    }
                } else {
                    switch (di % 10) {
                        case 0 -> resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2];
                        case 1 -> resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2] + " " + Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[0];
                        case 2 -> resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2] + " " + Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[1];
                        default -> resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2] + " " +
                                Numbers.UNIQUE_UNITS[Integer.parseInt(substringUnits) - 1];
                    }
                }
            }
            default -> System.out.println("Что-то пошло не так в gettingDecades");
        }
        return resultDecade;
    }

    public static String getHundreds(String number, int indexOfCurrency) {
        String resultHundreds;
        int numberInt = Integer.parseInt(number);
        if (number.length() <= 2) {
            resultHundreds = getDecades(number, indexOfCurrency);
        } else {
            if (number.equals("000")) {
                return "";
            } else {
                String substringHundreds = number.substring(number.length() - 3, number.length() - 2);
                String substringDecades = number.substring(number.length() - 2);
                if (numberInt % 100 != 0)
                    if (numberInt / 100 != 0) {
                        resultHundreds = Numbers.HUNDREDS[Integer.parseInt(substringHundreds) - 1] + " " + getDecades(substringDecades, indexOfCurrency);
                    } else {
                        resultHundreds = getDecades(substringDecades, indexOfCurrency);
                    }
                else {
                    resultHundreds = Numbers.HUNDREDS[Integer.parseInt(substringHundreds) - 1];

                }
            }
        }
        return resultHundreds;
    }


    public static String getDecadesForMillion(@NotNull String d) {
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
                    resultDecade = Numbers.UNIQUE_UNITS[di - 1];
                } else resultDecade = "ноль";
            }
            case 1 -> resultDecade = Numbers.UNIQUE_DECADES[di - 10];
            case 2, 3, 4, 5, 6, 7, 8, 9 -> {

                if (di % 10 != 0) {
                    resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2] + " " +
                            Numbers.UNIQUE_UNITS[Integer.parseInt(substringUnits) - 1];
                } else {
                    resultDecade = Numbers.DECADES[Integer.parseInt(substringDecades) - 2];
                }
            }
            default -> System.out.println("Что-то пошло не так в gettingDecades");
        }
        return resultDecade;
    }


    public static String getMillions(String number) {
        String resultHundreds;
        int numberInt = Integer.parseInt(number);
        if (number.length() <= 2) {
            resultHundreds = getDecadesForMillion(number);
        } else {
            String substringHundreds = number.substring(number.length() - 3, number.length() - 2);
            String substringDecades = number.substring(number.length() - 2);
            if (numberInt % 100 != 0)
                if (numberInt / 100 != 0) {
                    resultHundreds = Numbers.HUNDREDS[Integer.parseInt(substringHundreds) - 1] + " " + getDecadesForMillion(substringDecades);
                } else {
                    resultHundreds = getDecadesForMillion(substringDecades);
                }
            else {
                resultHundreds = Numbers.HUNDREDS[Integer.parseInt(substringHundreds) - 1];
            }
        }
        return resultHundreds;
    }


    static String convertNumber(@NotNull String number, int indexOfCurrency) {
        String finalResult = "";
        int numberLength = number.length();
        switch (numberLength) {
            case 1, 2, 3 -> finalResult = getHundreds(number, indexOfCurrency);
            case 4, 5, 6 -> {
                String substringThousand = number.substring(0, numberLength - 3);
                String substringHundreds = number.substring(numberLength - 3);
                finalResult = matchThousand(substringThousand, indexOfCurrency) + " " + getHundreds(substringHundreds, indexOfCurrency);
            }
            case 7, 8, 9 -> {
                String substringMillion = number.substring(0, numberLength - 6);
                String substringThousand = number.substring(numberLength - 6, numberLength - 3);
                String substringHundreds = number.substring(numberLength - 3);
                finalResult = matchMillion(substringMillion) + " " + matchThousand(substringThousand, indexOfCurrency) + " " + getHundreds(substringHundreds, indexOfCurrency);
            }
        }
        return finalResult;
    }

    public static String matchCurrency(@NotNull String number, int indexOfCurrency) {
        String rightCurrency = "";
        String lastDigit = number.substring(number.length() - 1);
        if (number.length() >= 2) {
            String preLastDigit = number.substring(number.length() - 2, number.length() - 1);
            if (!preLastDigit.equals("1")) {
                switch (lastDigit) {
                    case "1" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][0];
                    case "2", "3", "4" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][1];
                    case "0", "5", "6", "7", "8", "9" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][2];
                    default -> System.out.println("Что-то пошло не так в matching...");
                }
            } else
                rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][2];
        } else {
            switch (lastDigit) {
                case "1" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][0];
                case "2", "3", "4" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][1];
                case "0", "5", "6", "7", "8", "9" -> rightCurrency = convertNumber(number, indexOfCurrency) + " " + Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][2];
                default -> System.out.println("Что-то пошло не так в matching...");
            }
        }
        return rightCurrency;
    }

    public static String matchThousand(String substringThousand, int indexOfCurrency) {
        String matchedThousand;
        int matchedThousandInt = Integer.parseInt(substringThousand);
        String hundredResult = getHundreds(substringThousand, indexOfCurrency);
        String thousandResult;
        if (matchedThousandInt != 0) {
            String lastDigit = substringThousand.substring(substringThousand.length() - 1);
            int lastDigitInt = Integer.parseInt(lastDigit);
            switch (lastDigitInt) {

                case 1 -> {
                    thousandResult = hundredResult.substring(0, hundredResult.length() - 4) + Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[0];
                    matchedThousand = thousandResult + " " + Numbers.THOUSANDS[0];
                }
                case 2 -> {
                    thousandResult = hundredResult.substring(0, hundredResult.length() - 3) + Numbers.NUMBERS_FOR_THOUSAND_OR_FEMALE[1];
                    matchedThousand = thousandResult + " " + Numbers.THOUSANDS[1];
                }
                case 3, 4 -> matchedThousand = hundredResult + " " + Numbers.THOUSANDS[1];
                default -> matchedThousand = hundredResult + " " + Numbers.THOUSANDS[2];
            }
        } else matchedThousand = "";
        return matchedThousand;
    }


    public static String matchMillion(@NotNull String substringMillion) {
        String matchedMillion;
        String lastDigit = substringMillion.substring(substringMillion.length() - 1);
        String millionResult = getMillions(substringMillion);
        int lastDigitInt = Integer.parseInt(lastDigit);
        switch (lastDigitInt) {
            case 1 -> matchedMillion = millionResult + " " + Numbers.MILLIONS[0];
            case 2, 3, 4 -> matchedMillion = millionResult + " " + Numbers.MILLIONS[1];
            default -> matchedMillion = millionResult + " " + Numbers.MILLIONS[2];
        }
        return matchedMillion;
    }

    private static @NotNull String outputResult(String number, int indexOfCurrency) {
        String finalText;
        finalText = "РЕЗУЛЬТАТ: " + matchCurrency(number, indexOfCurrency);
        return finalText;
    }

    public static boolean isMale(int indexOfCurrency) {
        for (int i = 0; i < Currencies.FEMALE_CURRENCIES.length; i++) {
            if (Currencies.VALUES_OF_CURRENCIES[indexOfCurrency - 1][0].equals(Currencies.FEMALE_CURRENCIES[i]))
                return false;
        }
        return true;
    }

    public static @NotNull String getOutputResult(String number, int indexOfCurrency) {
        String regexNumber = "[0-9]+";
        if (number.matches(regexNumber)) {
            return outputResult(number, indexOfCurrency)+"\n";
        } else {
            if (number.equals("ВЫХОД")||number.equals("EXIT")) return "EXIT";
            else
                return "Введенное Вами значение не является числом или является отрицательным числом!\nПопробуйте еще раз:";
        }
    }

}
