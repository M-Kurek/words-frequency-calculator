package com.trivadis.words.frequency;

import java.io.IOException;
import java.util.List;

public class RunMe {
    private static String[] texts = {"texts/bible_ylt.txt", "texts/4_gospels.txt"};

    public static void main(String[] args) throws Exception {
        RunMe runMe = new RunMe();
        int elapsedFirst = runMe.watchTime(texts[0]).getElapsedTimeMs();
        System.out.println("1st " + elapsedFirst);
        int elapsedLast = runMe.runSeveral("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0");
        System.out.println("czas " + elapsedLast + " ms,\t" + 100 * elapsedLast / elapsedFirst + "%");
    }

    private int runSeveral(String numSet) throws IOException {
        for (String it : numSet.split(" ")) {
            watchTime(texts[Integer.valueOf(it)]);
        }
        return watchTime(texts[0]).getElapsedTimeMs();
    }

    StopWatch watchTime(String file) throws IOException {
        CalculatorJ2 calc = new CalculatorJ2();
        StopWatch extractWordsStopWatch = new StopWatch();
        //List<String> content =
                calc.extractAll(file);
        extractWordsStopWatch.stop();
        return extractWordsStopWatch;
    }
}
