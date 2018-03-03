package com.mic.project.al.service.contentprofile;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The Class ContentLengthUtil.
 */
public class ContentLengthUtil {

    /**
     * The is text.
     */
    boolean isAudio, isVideo, isText;

    /**
     * This method is used to get the length type of the given content.
     *
     * @param content is the string for which content length need to be calculated.
     * @return content length type.
     */
    public static String getTextLength(String content) {
        int length = 0;
        try {
            length = FleschIndexUtil.getNumSentences(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (length > 1500) {
            return "TextLong";
        } else if (length > 300 && length <= 1500) {
            return "TextMedium";
        } else {
            return "TextShort";
        }
    }


    public static String getVideoLength(long durationInSecs) {
        double durationInMinutes = (double) ((double) durationInSecs / 60d);
        if (durationInMinutes > 20) {
            return "VideoLong";
        } else if (durationInMinutes > 10) {
            return "VideoMedium";
        } else {
            return "VideoShort";
        }
    }
}