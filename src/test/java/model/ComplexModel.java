package model;

import com.mockme.api.annotation.MockWith;
import com.mockme.mocker.RandomDoubleMocker;
import com.mockme.mocker.RandomIntegerMocker;
import com.mockme.mocker.RandomStringMocker;

public class ComplexModel {

    @MockWith(RandomStringMocker.class)
    private String name;

    @MockWith(RandomIntegerMocker.class)
    private int number;

    @MockWith(RandomDoubleMocker.class)
    private double amount;

    public ComplexModel() {}

    public ComplexModel(String name, int number, double amount) {
        this.name = name;
        this.number = number;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ComplexModel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", amount=" + amount +
                '}';
    }
}
