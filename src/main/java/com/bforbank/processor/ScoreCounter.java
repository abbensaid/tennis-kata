package com.bforbank.processor;

import com.bforbank.listener.ScoreListener;
import com.bforbank.model.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreCounter {
    private Player playerA;
    private Player playerB;
    private boolean deuce;
    private boolean gameOver;
    private boolean gameStarted;
    private int gameCount = 0;
    private final List<ScoreListener> listeners = new ArrayList<>();

    public ScoreCounter() {
        init();
    }

    private void init() {
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        deuce = false;
        gameOver = false;
        gameStarted = false;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void addListener(ScoreListener scoreListener) {
        listeners.add(scoreListener);
    }

    public List<String> getScoreDetails(String points) {
        List<String> scoreDetails = new ArrayList<>();
        points.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> winPoint(scoreDetails, c));
        return scoreDetails;
    }

    private void winPoint(List<String> scoreDetails, char c) {
        if (gameOver) {
            init();
        }
        if (!gameStarted) {
            gameStarted = true;
            gameCount++;
            scoreDetails.add("\nGame " + gameCount);

        }
        if (c == 'A' || c == 'a') {
            playerA.increment();
        } else if (c == 'B' || c == 'b') {
            playerB.increment();
        } else {
            throw new IllegalArgumentException("Invalid player name : " + c);
        }
        listeners.forEach(listener -> listener.notify(this));
        scoreDetails.add(getScoreAtPoint());
    }

    private String getScoreAtPoint() {
        if (deuce) {
            return "Deuce";
        }
        if (playerA.isAdvantage()) {
            return "Advantage " + playerA.getName();
        }
        if (playerB.isAdvantage()) {
            return "Advantage " + playerB.getName();
        }
        if (playerA.isGameWon()) {
            return playerA.getName() + " wins the game";
        }
        if (playerB.isGameWon()) {
            return playerB.getName() + " wins the game";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(playerA.getName());
        builder.append(" : ");
        builder.append(playerA.getConvertedScore());
        builder.append(" / ");
        builder.append(playerB.getName());
        builder.append(" : ");
        builder.append(playerB.getConvertedScore());
        return builder.toString();
    }
}
