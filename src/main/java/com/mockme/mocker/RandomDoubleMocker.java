package com.mockme.mocker;

import com.mockme.api.MockingStrategy;

import java.util.Random;

public class RandomDoubleMocker implements MockingStrategy<Double> {

    private Random random = new Random();

    @Override
    public Double generate() {
        return random.nextGaussian();
    }
}
