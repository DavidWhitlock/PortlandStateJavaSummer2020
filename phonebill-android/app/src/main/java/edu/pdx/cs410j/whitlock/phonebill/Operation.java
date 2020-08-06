package edu.pdx.cs410j.whitlock.phonebill;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Operation implements Serializable {

    private final double value;

    public Operation(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    @NonNull
    @Override
    public String toString() {
        return " = " + this.getValue();
    }
}
