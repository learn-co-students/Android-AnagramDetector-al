package com.flatironschool.anagramdetector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by altyus on 6/27/14.
 */
public class Anagram {

    private String mWord;
    private String[] mList;

    public Anagram(String word, String[] list){
        mWord = word;
        mList = list;
    }

    public String[] match(){
        ArrayList<String> matches = new ArrayList<String>();

        char[] wordChars = mWord.toLowerCase().toCharArray();
        for (String testString :mList){
            char[] testChars = testString.toLowerCase().toCharArray();
            if (isAnagram(wordChars, testChars)){
                matches.add(testString);
            }
        }

        return matches.toArray(new String[matches.size()]);
    }

    private boolean isAnagram(char[] word1, char[] word2){

        if (word1.length != word2.length){
            return false;
        }
        Arrays.sort(word1);
        Arrays.sort(word2);

        for (int x =0; x < word1.length; x++){
            if (word1[x] != word2[x]){
                return false;
            }
        }

        return true;
    }
}
