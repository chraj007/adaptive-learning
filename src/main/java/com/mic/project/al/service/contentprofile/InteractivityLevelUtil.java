package com.mic.project.al.service.contentprofile;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;


/**
 * The Class InteractivityLevelUtil.
 */
public class InteractivityLevelUtil {

    /**
     * The example string.
     */
    private static String exampleString = "Example,example,e.g.,Ex.";

    /**
     * The example str array.
     */
    private static String exampleStrArray[] = exampleString.split(",");

    /**
     * The question string.
     */
    private static String questionString = "Question,Q.,?,what,how,where,when,why,how many,how much,how much,what time,how long,who,which";

    /**
     * The question str array.
     */
    private static String questionStrArray[] = questionString.split(",");

    /**
     * The illustration string.
     */
    private static String illustrationString = "image,img,figure,fig,diagram,caption,shown below";

    /**
     * The illustration str array.
     */
    private static String illustrationStrArray[] = illustrationString.split(",");

    /**
     * The video string.
     */
    private static String videoString = "<embed,<video,swf,</video>";

    /**
     * The video str array.
     */
    private static String videoStrArray[] = videoString.split(",");


    /**
     * This method is used to read the document.
     *
     * @param content is the String content.
     * @return the string[]
     */
    public static String[] readDocument(String content) {
        try {

            ArrayList inpc = new ArrayList();
            int counter = 0;
            BreakIterator bi = BreakIterator.getSentenceInstance(Locale.US);
            bi.setText(content);
            int lastIndex = bi.first();
            while (lastIndex != BreakIterator.DONE) {
                int firstIndex = lastIndex;
                lastIndex = bi.next();
                if (lastIndex != BreakIterator.DONE) {
                    String sentence = content.substring(firstIndex, lastIndex);
                    inpc.add(sentence);
                }
            }
            String inputfilecontents[] = new String[inpc.size()];
            for (int i = 0; i < inpc.size(); i++) {
                inputfilecontents[i] = (String) inpc.get(i);
            }
            return inputfilecontents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to check whether examples exist in document.
     *
     * @param fc the array of words.
     * @return true, if successful
     */
    public static boolean hasExamples(String[] fc) {
        for (int i = 0; i < fc.length; i++) {
            for (int j = 0; j < exampleStrArray.length; j++) {
                String smallone = fc[i].toLowerCase();
                if (smallone.contains(exampleStrArray[j])) return true;
            }
        }
        return false;
    }

    /**
     * Checks for videos.
     *
     * @param fc the fc
     * @return true, if successful
     */
    public static boolean hasVideos(String[] fc) {
        for (int i = 0; i < fc.length; i++) {
            for (int j = 0; j < videoStrArray.length; j++) {
                String smallone = fc[i].toLowerCase();
                if (smallone.contains(videoStrArray[j])) return true;
            }
        }
        return false;
    }

    /**
     * Checks for questions.
     *
     * @param fc the fc
     * @return true, if successful
     */
    public static boolean hasQuestions(String[] fc) {
        for (int i = 0; i < fc.length; i++) {
            for (int j = 0; j < questionStrArray.length; j++) {
                String smallone = fc[i].toLowerCase();
                if (smallone.contains(questionStrArray[j])) return true;
            }
        }
        return false;
    }

    /**
     * Checks for illustrations.
     *
     * @param fc the fc
     * @return true, if successful
     */
    public static boolean hasIllustrations(String[] fc) {
        for (int i = 0; i < fc.length; i++) {
            for (int j = 0; j < illustrationStrArray.length; j++) {
                String smallone = fc[i].toLowerCase();
                if (smallone.contains(illustrationStrArray[j])) return true;
            }
        }
        return false;
    }

    /**
     * Gets the interactivity level.
     *
     * @param hasExamples        the has examples
     * @param hasQuestions       the has questions
     * @param hasIllustrations   the has illustrations
     * @param videoIllustrations the video illustrations
     * @return the interactivity level
     */
    public static int getInteractivityLevel(boolean hasExamples, boolean hasQuestions, boolean hasIllustrations, boolean videoIllustrations) {
        int contentScore = 1;

        if (hasExamples) {
            contentScore += 2;
        }
        if (hasQuestions) {
            contentScore += 2;
        }
        if (hasIllustrations) {
            contentScore += 2;
        }
        if (videoIllustrations) {
            contentScore += 2;
        }

        return contentScore;
    }

    /**
     * Gets the interactivity.
     *
     * @param content the content
     * @return the interactivity
     */
    public static int getInteractivity(String content) {

        //String inputfilepath =  filePath;
        try {
            String sentences[] = readDocument(content);
            boolean he, hq, hi, hv;
            he = hasExamples(sentences);
            hq = hasQuestions(sentences);
            hi = hasIllustrations(sentences);
            hv = hasVideos(sentences);
            return getInteractivityLevel(he, hq, hi, hv);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("IO has a problem");
            return -1;
        }
    }

    /**
     * Gets the interactivity level.
     *
     * @param content the content
     * @return the interactivity level
     */
    public static String getInteractivityLevel(String content) {

        int l = getInteractivity(content);

        if (l <= 3) {
            return "Low";
        }

        if (l > 3 && l <= 5) {
            return "Medium";
        }

        if (l > 5) {
            return "High";
        }

        return "None";
    }

}