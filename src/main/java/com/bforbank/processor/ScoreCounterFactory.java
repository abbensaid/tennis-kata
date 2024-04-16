package com.bforbank.processor;

import com.bforbank.listener.AdvantageListener;
import com.bforbank.listener.DeuceListener;
import com.bforbank.listener.GameOverListener;

public class ScoreCounterFactory {
    public static ScoreCounter createTennisScoreCounter() {
        ScoreCounter scoreCounter = new ScoreCounter();
        scoreCounter.addListener(new DeuceListener());
        scoreCounter.addListener(new AdvantageListener());
        scoreCounter.addListener(new GameOverListener());
        return scoreCounter;
    }
}
