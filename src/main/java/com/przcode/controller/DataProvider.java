package com.przcode.controller;

import com.przcode.model.Data;
import com.przcode.model.Id;
import com.przcode.model.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DataProvider<PAIR> {
    private String nameFile;
    private ArrayList<String[]> listContent;

    public DataProvider(String nameFile) {
        this.listContent = new ArrayList<>();
        this.nameFile = nameFile;
    }

    private int count(){
        return 0;
    }

    public Collection<PAIR> getAll() {
        this.readFile();
        Collection<PAIR> dataList = new ArrayList<>();
        for(String[] elem : listContent) {
            String[] data = {elem[1], elem[2]};
            PAIR pair = (PAIR) new Pair<>(new Id(Long.getLong(elem[0])), new Data(data));
            dataList.add(pair);
        }
        return dataList;
    }

    public Collection<PAIR> get(int page, int pageLength) {
        return null;
    }

    private void readFile() {
        File file = new File(this.nameFile);
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] splittedCode = line.split(";");
                listContent.add(splittedCode);
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
