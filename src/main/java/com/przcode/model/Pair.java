package com.przcode.model;

public class Pair<ID, DATA> {
    private ID id;
    private DATA data;

    public Pair(ID id, DATA data) {
        this.id = id;
        this.data = data;
    }

    public ID getId() {
        return id;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
