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
}
