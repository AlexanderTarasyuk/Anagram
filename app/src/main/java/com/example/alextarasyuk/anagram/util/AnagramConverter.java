package com.example.alextarasyuk.anagram.util;

import android.os.Build;
import android.support.annotation.RequiresApi;

public class AnagramConverter {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String convertLineToAnagram(String lineToAnagram) {
        String[] stringLineToAnagram = lineToAnagram.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for (String string: stringLineToAnagram) {
            stringBuilder.append(convertToAnagram(string));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }


    //this method reverse all the words of input text.
    // All non-letter symbols should stay on the same places
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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
