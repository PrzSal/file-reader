package com.przcode.controller;

import java.util.ArrayList;
import java.util.Collection;

public class DataProvider<T> {
    private String nameFile;
    private ArrayList<String[]> listContent;

    public DataProvider(String nameFile) {
        this.listContent = new ArrayList<>();
        this.nameFile = nameFile;
    }

    private int count(){
        return 0;
    }

    public Collection<T> get(int page, int pageLength) {
        return null;
    }
}
