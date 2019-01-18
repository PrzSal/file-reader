package com.przcode.controller;

import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.util.Collection;

public class DataProvider<T> {
    private int count(){
        return 0;
    }
    public Collection<Pair<Id, Data>> get(int page, int pageLength) {
        return null;
    }
}
