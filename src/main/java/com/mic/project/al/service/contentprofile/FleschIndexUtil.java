package com.mic.project.al.service.contentprofile;


import java.io.IOException;
import java.util.StringTokenizer;

/**
 * The Class FleschIndexUtil.
 */
public class FleschIndexUtil {

    public static String getDiffLevel(String content) throws IOException {
        float fleschIndex = getFleschIndex(content);
        if (fleschIndex > 70) {
            return "Low";
        } else if (fleschIndex > 50) {
            return "Medium";
        } else {
            return "High";
        }
    }

    /**
     * Gets the flesch index.
     *
     * @param content the content
     * @return the flesch index
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static float getFleschIndex(String content) throws IOException {

        if (content.length() == 0) {
            return (float) (0.0);
        }
        int syllables = 0;
        int sentences = 0;
        int words = 0;

        String delimiters = ".,':;?{}[]=-+_!@#$%^&*() ";
        StringTokenizer tokenizer = new StringTokenizer(content, delimiters);
        // go through all words
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            syllables += countSyllables(word);
            words++;
        }
        // look for sentence delimiters
        String sentenceDelim = ".:;?!";
        StringTokenizer sentenceTokenizer = new StringTokenizer(content, sentenceDelim);
        sentences = sentenceTokenizer.countTokens();

        // calculate flesch index
        final float f1 = (float) 206.835;
        final float f2 = (float) 84.6;
        final float f3 = (float) 1.015;
        if (words == 0) {
            words++;
        }
        if (sentences == 0) {
            sentences++;
        }
        float r1 = (float) syllables / (float) words;
        float r2 = (float) words / (float) sentences;
        return f1 - (f2 * r1) - (f3 * r2);
    }

    /**
     * Gets the num sentences.
     *
     * @param content the content
     * @return the num sentences
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static int getNumSentences(String content) throws IOException {

        int syllables = 0;
        int sentences = 0;
        int words = 0;

        String delimiters = ".,':;?{}[]=-+_!@#$%^&*() ";
        StringTokenizer tokenizer = new StringTokenizer(content, delimiters);
        // go through all words
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            syllables += countSyllables(word);
            words++;
        }
        // look for sentence delimiters
        String sentenceDelim = ".:;?!";
        StringTokenizer sentenceTokenizer = new StringTokenizer(content, sentenceDelim);
        sentences = sentenceTokenizer.countTokens();

        return words;

    }

    /**
     * Gets the num words.
     *
     * @param content the content
     * @return the num words
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static int getNumWords(String content) throws IOException {

        int syllables = 0;
        int sentences = 0;
        int words = 0;

        String delimiters = ".,':;?{}[]=-+_!@#$%^&*() ";
        StringTokenizer tokenizer = new StringTokenizer(content, delimiters);
        // go through all words
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            syllables += countSyllables(word);
            words++;
        }

        return words;

    }

    /**
     * Count syllables.
     *
     * @param word the word
     * @return the int
     */
    public static int countSyllables(String word) {
        int syl = 0;
        boolean vowel = false;
        int length = word.length();

        // check each word for vowels (don't count more than one vowel in a row)
        for (int i = 0; i < length; i++) {
            if (isVowel(word.charAt(i)) && (vowel == false)) {
                vowel = true;
                syl++;
            } else if (isVowel(word.charAt(i)) && (vowel == true)) {
                vowel = true;
            } else {
                vowel = false;
            }
        }

        char tempChar = word.charAt(word.length() - 1);
        // check for 'e' at the end, as long as not a word w/ one syllable
        if (((tempChar == 'e') || (tempChar == 'E')) && (syl != 1)) {
            syl--;
        }
        return syl;
    }

    // check if a char is a vowel (count y)

    /**
     * Checks if is vowel.
     *
     * @param c the c
     * @return true, if is vowel
     */
    public static boolean isVowel(char c) {
        if ((c == 'a') || (c == 'A')) {
            return true;
        } else if ((c == 'e') || (c == 'E')) {
            return true;
        } else if ((c == 'i') || (c == 'I')) {
            return true;
        } else if ((c == 'o') || (c == 'O')) {
            return true;
        } else if ((c == 'u') || (c == 'U')) {
            return true;
        } else if ((c == 'y') || (c == 'Y')) {
            return true;
        } else {
            return false;
        }
    }
}
