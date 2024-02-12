package com.example.middleware2.fakeDB;

import com.example.middleware2.entities.Month;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeDB {
    public ArrayList<Month> lista;

    public FakeDB() {
        this.lista = new ArrayList<>(Arrays.asList(
                new Month(1, "January", "Gennaio", "Januar"),
                new Month(2, "February", "Febbraio", "Februar"),
                new Month(3, "March", "Marzo", "März"),
                new Month(4, "April", "Aprile", "April"),
                new Month(5, "May", "Maggio", "Mai"),
                new Month(6, "June", "Giugno", "Juni")));
    }
    public Month findMonth(int monthNumber) {
        for (Month x : lista) {
            if (x.getMonthNumber() == monthNumber) {
                return x;
            }
        }
        return null;
    }
}
