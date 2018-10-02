package com.example.alextarasyuk.anagram.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnagramConverterTest {

    @Test
    public void givenStringLineShouldOutputAnagram() {
        assertEquals(AnagramConverter.convertLineToAnagram("a1bcd efg!h"), "d1cba hgf!e");
    }

    @Test
    public void givenStringShouldOutputAnagram() {
        assertEquals(AnagramConverter.convertToAnagram("a1bcd"), "d1cba");
    }


}