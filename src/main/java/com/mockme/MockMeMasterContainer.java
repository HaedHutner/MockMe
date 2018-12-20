package com.mockme;

import com.mockme.api.MockingStrategy;
import com.mockme.mocker.RandomDoubleMocker;
import com.mockme.mocker.RandomIntegerMocker;
import com.mockme.mocker.RandomStringMocker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class MockMeMasterContainer {

    private Map<Class<?>, MockingStrategy<?>> defaultMockingStrategies = new HashMap<>();
    {
        defaultMockingStrategies.put(String.class, new RandomStringMocker());
        defaultMockingStrategies.put(Integer.class, new RandomIntegerMocker());
        defaultMockingStrategies.put(Double.class, new RandomDoubleMocker());
    }

    @SuppressWarnings("unchecked")
    public <T> T mock(Class<T> clazz) {
        return (T) defaultMockingStrategies.get(clazz).generate();
    }

    public <T> T mockWith(Class<T> clazz, MockingStrategy<T> strategy) {
        return strategy.generate();
    }

    public <T> void setDefaultMocker(Class<T> clazz, MockingStrategy<T> strategy) {
        defaultMockingStrategies.put(clazz, strategy);
    }

    @SuppressWarnings("unchecked")
    public <T> MockingStrategy<T> getDefaultMocker(Class<T> clazz) {
        return (MockingStrategy<T>) defaultMockingStrategies.get(clazz);
    }

    public <T> T mockWithAnnotations(Class<T> clazz) {
        try {
            T object = clazz.getConstructor().newInstance();

            for (Field field : clazz.getFields()) {
                field.set(object, defaultMockingStrategies.get(field.getDeclaringClass()).generate());
            }

            return object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
