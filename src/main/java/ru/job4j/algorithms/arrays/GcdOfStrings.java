package ru.job4j.algorithms.arrays;

public class GcdOfStrings {
    public static String gcdOfStringsMikhail(String str1, String str2) {
        if (str2 == "") {
            return "";
        }
        String s2pat = "";
        if (str2.equals("")) {
            s2pat = str2;
        } else if (str2.length() == 1) {
            s2pat = str2;
        } else {
            char firstChar = str2.charAt(0);
            char[] chars = str2.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == firstChar) {
                    s2pat = str2.substring(0, i);
                    break;
                }
            }
            if (s2pat.equals("")) {
                s2pat = str2;
            }
        }

        if (str1.length() % s2pat.length() != 0) {
            return "";
        }
        int mult = str1.length() / s2pat.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mult; i++) {
            sb.append(s2pat);
        }

        return str1.equals(sb.toString()) ? s2pat : "";
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int endPoint = gcd(str1.length(), str2.length());

        return str1.substring(0, endPoint);
    }

    public static int gcd(int len1, int len2) {
        int tmp;
        while (len2 != 0) {
            tmp = len2;
            len2 = len1 % len2;
            len1 = tmp;
        }

        return len1;
    }
}
