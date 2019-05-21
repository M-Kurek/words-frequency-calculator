package com.trivadis.words.frequency;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CalculatorJ2Test {

    @Test
    public void watch() throws Exception {
        CalculatorJ2 calc = new CalculatorJ2Copy();
        int elapsedFirst = watchTime("texts/bible_ylt.txt", calc).getElapsedTimeMs();
        System.out.println("1st " + elapsedFirst);
        for (String it : "1 2 3 4 5 6 7 8".split(" ")) {
            watchTime("texts/4_gospels.txt", calc);
        }
        //then
        int elapsedLast = watchTime("texts/bible_ylt.txt", calc).getElapsedTimeMs();
        System.out.println("czas " + elapsedLast + " ms,\t" + 100 * elapsedLast / elapsedFirst + "%");

    }

    @Test
    public void watchWhenBigFileAtTwoLastRuns() throws Exception {
        CalculatorJ2 calc = new CalculatorJ2JITCopy();
        int elapsedFirst = watchTime("texts/bible_ylt.txt", calc).getElapsedTimeMs();
        System.out.println("1st " + elapsedFirst);
        for (String it : "1 2 3 4 5 6 7".split(" ")) {
            watchTime("texts/4_gospels.txt", calc);
        }
        watchTime("texts/bible_ylt.txt", calc).getElapsedTimeMs();
        //then
        int elapsedLast = watchTime("texts/bible_ylt.txt", calc).getElapsedTimeMs();
        System.out.println("czas " + elapsedLast + " ms,\t" + 100 * elapsedLast / elapsedFirst + "%");

    }

    private StopWatch watchTime(String file, CalculatorJ2 calc) throws IOException {
        //CalculatorJ2 calc = new CalculatorJ2();
        StopWatch extractWordsStopWatch = new StopWatch();
        List<String> content = calc.extractAll(file);
        extractWordsStopWatch.stop();
        return extractWordsStopWatch;
    }

}