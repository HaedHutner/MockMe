package com.mockme;

import com.mockme.api.MockingStrategy;

public class MockMe {

    private static MockMeMasterContainer master = new MockMeMasterContainer();

    private MockMe() {}

    public static <T> T mock(Class<T> clazz) {
        return master.mock(clazz);
    }

    public static <T> T mockWith(Class<T> clazz, MockingStrategy<T> strategy) {
        return master.mockWith(clazz, strategy);
    }

    public static <T> T mockAnnotated(Class<T> clazz) {
        return master.mockWithAnnotations(clazz);
    }
}
