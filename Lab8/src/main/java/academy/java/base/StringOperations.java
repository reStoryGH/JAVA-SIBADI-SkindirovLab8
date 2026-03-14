package academy.java.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StringOperations {

    private StringOperations() {}

    public static int getSummaryLength(String[] strings) {
        return Arrays.stream(strings).filter(Objects::nonNull).mapToInt(String::length).sum();
    }

    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        return Character.toString(string.charAt(0)) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (index >= 0 && index < string1.length() && index < string2.length())
            return string1.charAt(index) == string2.charAt(index);
        else
            throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        int pos1 = string1.indexOf(character);
        int pos2 = string2.indexOf(character);
        return pos2 != -1 && pos1 == pos2;
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        int pos1 = string1.lastIndexOf(character);
        int pos2 = string2.lastIndexOf(character);
        return pos2 != -1 && pos1 == pos2;
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String substring) {
        int pos1 = string1.indexOf(substring);
        int pos2 = string2.indexOf(substring);
        return pos2 != -1 && pos1 == pos2;
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String substring) {
        int pos1 = string1.lastIndexOf(substring);
        int pos2 = string2.lastIndexOf(substring);
        return pos2 != -1 && pos1 == pos2;
    }

    public static boolean isEqual(String string1, String string2) {
        return Objects.equals(string1, string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1 == null ? string2 == null : string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int minLen = Math.min(string1.length(), string2.length());
        for (int i = 0; i < minLen; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0, i);
            }
        }
        return string1.substring(0, minLen);
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longestPalin = "";
        for (String s : strings) {
            if (s != null && isPalindromeIgnoreCase(s) && s.length() > longestPalin.length()) {
                longestPalin = s;
            }
        }
        return longestPalin;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index < 0 || index + length > string1.length() || index + length > string2.length()) {
            return false;
        }
        return string1.regionMatches(index, string2, index, length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String cleanString = string.replaceAll("\\s+", "").trim();
        return isPalindromeIgnoreCase(cleanString);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return Arrays.stream(array).mapToObj(d -> String.format("%.2f", d)).collect(Collectors.joining(","));
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(value);
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (double value : array) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(String.format("%.2f", value));
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder result = new StringBuilder(string);
        Arrays.sort(positions);
        for (int i = positions.length - 1; i >= 0; i--) {
            result.deleteCharAt(positions[i]);
        }
        return result;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        if (positions.length != characters.length) {
            throw new IllegalArgumentException("Positions and characters arrays must have the same size.");
        }
        StringBuilder result = new StringBuilder(string);
        for (int i = positions.length - 1; i >= 0; i--) {
            result.insert(positions[i], characters[i]);
        }
        return result;
    }
}