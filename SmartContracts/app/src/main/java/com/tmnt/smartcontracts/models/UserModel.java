package com.tmnt.smartcontracts.models;

/**
 * Created by ajayrahul on 2/12/17.
 */

public class UserModel {

    String name;
    String units;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserModel(String name, String units) {
        this.name = name;
        this.units = units;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
