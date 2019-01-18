package com.przcode.dao;

import com.przcode.controller.DataProvider;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.util.Collection;

public class DataContainer<K, V> {
    private Collection<Pair<Id, Data>> listData;
    
    public void load(DataProvider<Pair<K, V>> dataProvider){
        this.listData = dataProvider.getAll();
    }
}
