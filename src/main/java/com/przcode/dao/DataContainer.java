package com.przcode.dao;

import com.przcode.controller.DataProvider;
import com.przcode.model.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class DataContainer<ID, DATA> {
    private Collection<Pair<ID, DATA>> listData;

    public DataContainer() {
        this.listData = new ArrayList<>();
    }

    public void load(DataProvider<Pair<ID, DATA>> dataProvider) {
        this.listData = dataProvider.getAll();
    }

    public void add(ID id, DATA data) {
        Pair<ID, DATA> pair = new Pair<>(id, data);
        listData.add(pair);
    }

    public void update(ID id,DATA data) {
        listData.stream()
                .filter(pair -> pair.getId().equals(id))
                .peek(pair -> pair.setData(data))
                .collect(Collectors.toList());
    }

    public DATA findById(ID id) {
        return listData.stream()
                .filter(pair -> pair.getId().equals(id))
                .findAny().get().getData();
    }

    public void remove(ID id) {
        listData.removeIf(pair -> pair.getId().equals(id));
    }

    public Collection<Pair<ID, DATA>> getListData() {
        return listData;
    }
}