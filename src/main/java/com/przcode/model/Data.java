package com.przcode.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Data {
    private String[] data;

    public Data(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    @Override
    public String toString() {
        return Arrays.stream(data)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data1 = (Data) o;
        return Arrays.equals(data, data1.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}
