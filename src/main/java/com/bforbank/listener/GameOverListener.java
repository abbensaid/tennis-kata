package com.bforbank.listener;

import com.bforbank.processor.ScoreCounter;
import com.bforbank.model.Player;

public class GameOverListener implements ScoreListener {
    @Override
    public void notify(ScoreCounter scoreCounter) {
        Player playerA = scoreCounter.getPlayerA();
        Player playerB = scoreCounter.getPlayerB();
        if (firstPlayerWonGame(playerA, playerB)) {
            playerA.setGameWon(true);
            scoreCounter.setGameOver(true);
        } else if (firstPlayerWonGame(playerB, playerA)) {
            playerB.setGameWon(true);
            scoreCounter.setGameOver(true);
        }
    }

    private boolean firstPlayerWonGame(Player firstPlayer, Player secondPlayer) {
        return firstPlayer.getScore() > 3 && firstPlayer.getScore() - secondPlayer.getScore() > 1;
    }
}
