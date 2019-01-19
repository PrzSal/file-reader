package com.przcode.dao;

import com.przcode.controller.DataProvider;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class DataContainerTest {

    DataProvider<Pair<Id, Data>> dataProvider;
    DataContainer<Id, Data> dataContainer;
    Collection<Pair<Id, Data>> expectedList;

    @Test
    public void loadTest() {
        dataProvider = new DataProvider<>("test.csv");
        dataContainer = new DataContainer<>();
        dataContainer.load(dataProvider);
        String[] expectedData1 = {"France", "Paris"};
        String[] expectedData2 = {"Poland", "Warsaw"};
        expectedList = new ArrayList<>();
        expectedList.add(new Pair<>(new Id(new Long(1)), new Data(expectedData1)));
        expectedList.add(new Pair<>(new Id(new Long(2)), new Data(expectedData2)));
        assertEquals(2, dataContainer.getListData().size());
        assertEquals(expectedList, dataContainer.getListData());
    }

    @Test
    public void addTest() {
        dataContainer = new DataContainer<>();
        String[] newData = {"Germany", "Berlin"};
        expectedList = new ArrayList<>();
        expectedList.add(new Pair<>(new Id(new Long(3)), new Data(newData)));
        dataContainer.add(new Id(new Long(3)), new Data(newData));
        assertEquals(1, dataContainer.getListData().size());
        assertEquals(expectedList, dataContainer.getListData());
    }

    @Test
    public void updateTest() {
        dataProvider = new DataProvider<>("test.csv");
        dataContainer = new DataContainer<>();
        dataContainer.load(dataProvider);
        String[] newData = {"Germany", "Berlin"};
        dataContainer.update(new Id(new Long(2)), new Data(newData));
        String[] expectedData1 = {"France", "Paris"};
        String[] expectedData2 = {"Germany", "Berlin"};
        expectedList = new ArrayList<>();
        expectedList.add(new Pair<>(new Id(new Long(1)), new Data(expectedData1)));
        expectedList.add(new Pair<>(new Id(new Long(2)), new Data(expectedData2)));
        assertEquals(2, dataContainer.getListData().size());
        assertEquals(expectedList, dataContainer.getListData());
    }
}