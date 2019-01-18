package com.przcode.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

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
