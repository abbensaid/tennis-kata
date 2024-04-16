package com.bforbank.listener;

import com.bforbank.processor.ScoreCounter;

public interface ScoreListener {
    void notify(ScoreCounter scoreCounter);
}
