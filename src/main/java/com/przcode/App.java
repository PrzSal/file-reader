package com.przcode;

import com.przcode.controller.DataProvider;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

public class App 
{
    public static void main( String[] args ){
        DataProvider<Pair<Id, Data>> dC = new DataProvider<>(args[0]);
//        dC.readFile();
    }
}
