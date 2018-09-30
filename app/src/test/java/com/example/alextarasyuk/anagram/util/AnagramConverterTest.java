package com.example.alextarasyuk.anagram.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramConverterTest {

    @Test
    public void givenStringShouldOutputAnagram() {
        assertEquals(AnagramConverter.convertLineToAnagram("a1bcd efg!h"), "d1cba hgf!e");
    }
}