package com.shivas.mvvmimplementation;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class NicePlaceRepository {
    private static NicePlaceRepository instance;

    private ArrayList<NicePlace> dataList = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if(instance == null) {
            instance = new NicePlaceRepository();
        }

        return instance;
    }
    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        setData();
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataList);
        return data;
    }

    private void setData() {
        dataList.add(new NicePlace("Banglore", "imageuri"));
    }
}
