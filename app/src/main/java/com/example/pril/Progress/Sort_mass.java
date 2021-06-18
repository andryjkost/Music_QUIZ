package com.example.pril.Progress;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort_mass implements Comparator<ArrayList<Object>> {
    @Override
    public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
        if (Integer.parseInt(String.valueOf(o1.get(1))) < Integer.parseInt(String.valueOf(o2.get(1)))) {
            return 1;
        } else if (Integer.parseInt(String.valueOf(o1.get(1))) > Integer.parseInt(String.valueOf(o2.get(1)))){
            return -1;
        }

        else{
            return 0;
        }


    }
}
