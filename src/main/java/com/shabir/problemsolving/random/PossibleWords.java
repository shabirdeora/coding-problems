package com.shabir.problemsolving.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleWords {

    private static final List<List<Character>> INNER_LIST = Arrays.asList(
            Arrays.asList('0'),
            Arrays.asList('1'),
            Arrays.asList('A', 'B', 'C'),
            Arrays.asList('D', 'E', 'F'),
            Arrays.asList('G', 'H', 'I'),
            Arrays.asList('J', 'K', 'L'),
            Arrays.asList('M', 'N', 'O'),
            Arrays.asList('P', 'Q', 'R'),
            Arrays.asList('S', 'T', 'U', 'X'),
            Arrays.asList('W', 'X', 'Y', 'Z')
    );

    public static void main(String[] args) {
        Double d = null;
        String s = String.valueOf(d);
        System.out.println(s);
        System.out.println(INNER_LIST);
        System.out.println(findWords("45678"));
    }

    private static List<String> findWords(String phoneNumberString) {
        List<String> words = new ArrayList<>();
        for (int i = phoneNumberString.length() - 1; i >= 0; i--) {
            int phoneDigit = Integer.valueOf(phoneNumberString.substring(i, i + 1));
            words = wordsCombination(INNER_LIST.get(phoneDigit), words);
            System.out.println(words);
        }
        return words;
    }

    private static List<String> wordsCombination(List<Character> characterList, List<String> wordList) {
        List<String> possibleWordList = new ArrayList<>();
        for (Character character : characterList) {
            if (wordList == null || wordList.isEmpty()) {
                possibleWordList.add(String.valueOf(character));
            }
            for (String word : wordList) {
                possibleWordList.add(String.valueOf(character) + word);
            }
        }
        return possibleWordList;
    }
}
