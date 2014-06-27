package com.flatironschool.anagramdetector.tests;

import android.app.Fragment;
import android.test.InstrumentationTestCase;

import com.flatironschool.anagramdetector.Anagram;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by altyus on 6/27/14.
 */
public class AnagramTests extends InstrumentationTestCase {

    @Override
    protected void setUp() {

    }

    public void testAnagramInstantiation() throws Exception{
        Anagram anagram = new Anagram("ba", new String[]{});

        assertNotNull(anagram);
        assertEquals(anagram.getClass(), Anagram.class);
    }

    public void testMatchMethodReturnsASimpleAnagram() throws Exception{
        Anagram detector = new Anagram("ba", new String[]{"ab", "abc", "bac"});
        String[] anagrams = detector.match();

        assertTrue(Arrays.deepEquals(anagrams, new String[]{"ab"}));
    }

    public void testMatchMethodDetectsAnagramIgnoringCase() throws Exception{
        String[] candidates = new String[]{"enlists", "google", "inlets", "banana"};
        Anagram detector = new Anagram("LisTen", candidates);
        String[] anagrams = detector.match();

        assertTrue(Arrays.deepEquals(anagrams, new String[]{"inlets"}));
    }


    @Override
    protected void tearDown() {

    }
}
