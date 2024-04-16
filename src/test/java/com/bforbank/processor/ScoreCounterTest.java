package com.bforbank.processor;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScoreCounterTest {
    private ScoreCounter scoreCounter;

    @Before
    public void setup(){
        scoreCounter = ScoreCounterFactory.createTennisScoreCounter();
    }

    @Test
    public void shouldReturnEmptyListOnEmptyInput() {
        List<String> scoreDetails = scoreCounter.getScoreDetails("");
        assertTrue(scoreDetails.isEmpty());
    }

    @Test
    public void shouldReturnOneGame() {
        List<String> scoreDetails = scoreCounter.getScoreDetails("ABABBAABAA");
        assertEquals(scoreDetails.size(), 11);
        assertEquals(scoreDetails.get(0), "\nGame 1");
        assertEquals(scoreDetails.get(1), "Player A : 15 / Player B : 0");
        assertEquals(scoreDetails.get(2), "Player A : 15 / Player B : 15");
        assertEquals(scoreDetails.get(3), "Player A : 30 / Player B : 15");
        assertEquals(scoreDetails.get(4), "Player A : 30 / Player B : 30");
        assertEquals(scoreDetails.get(5), "Player A : 30 / Player B : 40");
        assertEquals(scoreDetails.get(6), "Deuce");
        assertEquals(scoreDetails.get(7), "Advantage Player A");
        assertEquals(scoreDetails.get(8), "Deuce");
        assertEquals(scoreDetails.get(9), "Advantage Player A");
        assertEquals(scoreDetails.get(10), "Player A wins the game");
    }

    @Test
    public void shouldReturnMultipleGames() {
        List<String> scoreDetails = scoreCounter.getScoreDetails("ABABBAABAABBAABB");
        assertEquals(scoreDetails.size(), 18);
        assertEquals(scoreDetails.get(0), "\nGame 1");
        assertEquals(scoreDetails.get(1), "Player A : 15 / Player B : 0");
        assertEquals(scoreDetails.get(2), "Player A : 15 / Player B : 15");
        assertEquals(scoreDetails.get(3), "Player A : 30 / Player B : 15");
        assertEquals(scoreDetails.get(4), "Player A : 30 / Player B : 30");
        assertEquals(scoreDetails.get(5), "Player A : 30 / Player B : 40");
        assertEquals(scoreDetails.get(6), "Deuce");
        assertEquals(scoreDetails.get(7), "Advantage Player A");
        assertEquals(scoreDetails.get(8), "Deuce");
        assertEquals(scoreDetails.get(9), "Advantage Player A");
        assertEquals(scoreDetails.get(10), "Player A wins the game");

        assertEquals(scoreDetails.get(11), "\nGame 2");
        assertEquals(scoreDetails.get(12), "Player A : 0 / Player B : 15");
        assertEquals(scoreDetails.get(13), "Player A : 0 / Player B : 30");
        assertEquals(scoreDetails.get(14), "Player A : 15 / Player B : 30");
        assertEquals(scoreDetails.get(15), "Player A : 30 / Player B : 30");
        assertEquals(scoreDetails.get(16), "Player A : 30 / Player B : 40");
        assertEquals(scoreDetails.get(17), "Player B wins the game");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnInvalidInput() {
        List<String> scoreDetails = scoreCounter.getScoreDetails("ABCDEF");
    }
}
