package com.przcode.controller;

import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DataProviderImpl<PAIR> implements DataProvider<PAIR> {
    private String nameFile;
    private ArrayList<String[]> listContent;
    private int countElement;



    public DataProviderImpl(String nameFile) {
        this.listContent = new ArrayList<>();
        countElement = 0;
        this.nameFile = nameFile;
    }

    @Override
    public int count(){
        return countElement;
    }

    @Override
    public Collection<PAIR> getAll() {
        this.readFile();
        Collection<PAIR> dataList = new ArrayList<>();
        for(String[] elem : listContent) {
            String[] data = {elem[1], elem[2]};
            PAIR pair = (PAIR) new Pair<>(new Id(new Long(elem[0])), new Data(data));
            dataList.add(pair);
        }
        return dataList;
    }

    @Override
    public Collection<PAIR> get(int page, int pageLength) {
        return null;
    }

    private void readFile() {
        this.countElement = 0;
        listContent.clear();
        File file = new File(this.nameFile);
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] splittedCode = line.split(";");
                countElement+=splittedCode.length;
                listContent.add(splittedCode);
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
