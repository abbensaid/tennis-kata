package com.bforbank;

import com.bforbank.processor.ScoreCounter;
import com.bforbank.processor.ScoreCounterFactory;

import java.util.Scanner;

public class TennisGameDemo {
    public static void main(String[] args) {
        String points;
        do {
            System.out.println("Please enter a game score containing only 'A' or 'B' characters : ");
            Scanner scanner = new Scanner(System.in);
            points = scanner.nextLine();
        } while (!checkInput(points));

        ScoreCounter scoreCounter = ScoreCounterFactory.createTennisScoreCounter();
        scoreCounter.getScoreDetails(points).forEach(System.out::println);
    }

    private static boolean checkInput(String points) {
        return points.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> c == 'A' || c == 'a' || c == 'B' || c == 'b');
    }
}