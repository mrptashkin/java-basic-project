package service;

public class Numbers {
    private final static String[] UNIQUE_UNITS = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};

    private final static String[] UNIQUE_DECADES = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
            "семнадцать", "восемнадцать", "девятнадцать"};

    private final static String[] DECADES = {"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    private final static String[] HUNDREDS = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    private final static String[] NUMBERS_FOR_THOUSAND_OR_FEMALE = {"одна", "две"};

    private final static String[] THOUSANDS = {"тысяча", "тысячи", "тысяч"};

    private final static String[] MILLIONS = {"миллион", "миллиона", "миллионов"};

    public static String[] getDECADES() {
        return DECADES;
    }

    public static String[] getHUNDREDS() {
        return HUNDREDS;
    }

    public static String[] getMILLIONS() {
        return MILLIONS;
    }

    public static String[] getNumbersForThousandOrFemale() {
        return NUMBERS_FOR_THOUSAND_OR_FEMALE;
    }

    public static String[] getTHOUSANDS() {
        return THOUSANDS;
    }

    public static String[] getUniqueDecades() {
        return UNIQUE_DECADES;
    }

    public static String[] getUniqueUnits() {
        return UNIQUE_UNITS;
    }

}
