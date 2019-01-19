package com.przcode.controller;

import java.util.Collection;

public interface DataProvider<PAIR> {
    int count();
    Collection<PAIR> get(int page, int pageLength);
    Collection<PAIR> getAll();

}
