package com.przcode.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(id, pair.id) &&
                Objects.equals(data, pair.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }
}