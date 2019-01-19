package com.przcode;

import com.przcode.controller.DataProviderImpl;
import com.przcode.dao.DataContainer;
import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

public class App 
{
    public static void main( String[] args ){
        DataProviderImpl<Pair<Id, Data>> dP = new DataProviderImpl<>(args[0]);
//        dC.readFile();
        DataContainer<Id, Data> dC = new DataContainer<>();
//
        String[]h={"Pol","War"};
//        dC.add(new Id(new Long(5)), new Data(h));
//        System.out.println(dC.getListData().size());
//        dC.add(new Id(new Long(4)), new Data(h));
        dC.load(dP);
//        Data d = dC.findById(new Id(new Long(3)));
//        System.out.println(d.getData()[1]);
        //        dC.update(new Id(new Long(1)), new Data(h));
//
        dC.print(0,1);
    }
}
