package com.bforbank.listener;

import com.bforbank.processor.ScoreCounter;
import com.bforbank.model.Player;

public class AdvantageListener implements ScoreListener {
    @Override
    public void notify(ScoreCounter scoreCounter) {
        Player playerA = scoreCounter.getPlayerA();
        Player playerB = scoreCounter.getPlayerB();
        playerA.setAdvantage(firstPlayerHasAdvantage(playerA, playerB));
        playerB.setAdvantage(firstPlayerHasAdvantage(playerB, playerA));
    }

    private boolean firstPlayerHasAdvantage(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getScore() == 4 && secondPlayer.getScore() == 3;
    }
}
