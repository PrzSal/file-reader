package com.przcode.dao;

import com.przcode.controller.DataProvider;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.util.ArrayList;
import java.util.Collection;

public class DataContainer<K, V> {
    private Collection<Pair<Id, Data>> listData;

    public DataContainer() {
        this.listData = new ArrayList<>();
    }

    public void load(DataProvider<Pair<K, V>> dataProvider) {
        this.listData = dataProvider.getAll();
    }

    public void add(Id id, Data data) {
        Pair<Id, Data> pair = new Pair<>(id, data);
        listData.add(pair);
    }
}
