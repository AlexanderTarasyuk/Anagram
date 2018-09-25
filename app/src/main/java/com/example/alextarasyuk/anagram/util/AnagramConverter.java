package com.example.alextarasyuk.anagram.util;

public class AnagramConverter {


    //this method reverse all the words of input text.
    // All non-letter symbols should stay on the same places
    public static String convertToAnagram(String stringToReverse) {
        char[] arrayString = stringToReverse.toCharArray();
        int i = 0;
        int j = arrayString.length - 1;
        while (i < j) {
            if (!Character.isAlphabetic(arrayString[i])) {
                i++;
            } else if (!Character.isAlphabetic(arrayString[j])) {
                j--;

            } else {
                char charTemporary = arrayString[i];
                arrayString[i] = arrayString[j];
                arrayString[j] = charTemporary;
                i++;
                j--;
            }
        }
        return new String(arrayString);
    }
}
