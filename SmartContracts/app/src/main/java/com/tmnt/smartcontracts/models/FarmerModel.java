package com.tmnt.smartcontracts.models;

import java.util.List;

/**
 * Created by ajayrahul on 2/12/17.
 */

public class FarmerModel {

    String name;
    List<String> crops;

    public FarmerModel(String name, List<String> crops) {
        this.name = name;
        this.crops = crops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUnits() {
        return crops;
    }

    public void setUnits(List<String> units) {
        this.crops = units;
    }
}
