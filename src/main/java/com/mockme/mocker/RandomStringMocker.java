package com.mockme.mocker;

import com.mockme.api.MockingStrategy;

import java.util.UUID;

public class RandomStringMocker implements MockingStrategy<String> {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
