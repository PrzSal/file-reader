package com.przcode.dao;

import com.przcode.controller.DataProvider;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.util.ArrayList;
import java.util.Collection;

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
}
