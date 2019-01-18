package com.przcode.model;

public class Pair<K, V> {
    private K id;
    private V data;

    public Pair(K id, V data) {
        this.id = id;
        this.data = data;
    }

    public K getId() {
        return id;
    }

    public V getData() {
        return data;
    }
}
