package com.przcode.service;

import com.przcode.controller.DataProvider;
import com.przcode.model.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
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

    public void printAll() {
        listData.forEach(pair -> System.out.println(pair.getId().toString() + pair.getData()));
    }

    public void print(int from, int to) {
        this.get(from, to).forEach(data -> System.out.println(data.toString()));
    }

    public void clear() {
        listData.clear();
    }

    public Collection<DATA> get(int from, int to) {
        Collection<Pair> filterPair = new ArrayList<>();
        for (int i = 0; i < listData.size(); i++) {
            if(i>=from && i <= to){
                ((ArrayList<Pair>) filterPair).add((Pair) listData.toArray()[i]);
            }
        }
        Collection<DATA> filterData = new ArrayList<>();
        filterPair.forEach(pair -> ((ArrayList<DATA>) filterData).add((DATA) pair.getData()));
        return filterData;
    }

    public Collection<DATA> filter(Predicate<DATA> filter) {
        Collection<DATA> filterData = new ArrayList<>();
        listData.forEach(pair -> ((ArrayList<DATA>) filterData).add(pair.getData()));
        filterData.stream()
                .filter(filter)
                .collect(Collectors.toList());
        return filterData;
    }
    public Collection<Pair<ID, DATA>> getListData() {
        return listData;
    }
}