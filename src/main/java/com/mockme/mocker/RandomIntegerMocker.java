package com.mockme.mocker;

import com.mockme.api.MockingStrategy;

import java.util.Random;

public class RandomIntegerMocker implements MockingStrategy<Integer> {

    private Random random = new Random();

    @Override
    public Integer generate() {
        return random.nextInt();
    }
}
