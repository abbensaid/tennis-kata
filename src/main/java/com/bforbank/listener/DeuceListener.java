package com.bforbank.listener;

import com.bforbank.processor.ScoreCounter;
import com.bforbank.model.Player;

public class DeuceListener implements ScoreListener {
    @Override
    public void notify(ScoreCounter scoreCounter) {
        Player playerA = scoreCounter.getPlayerA();
        Player playerB = scoreCounter.getPlayerB();
        if (playerA.getScore() == 4 && playerB.getScore() == 4) {
            playerA.setScore(3);
            playerB.setScore(3);
        }
        scoreCounter.setDeuce(playerA.getScore() == 3 && playerB.getScore() == 3);
    }
}
