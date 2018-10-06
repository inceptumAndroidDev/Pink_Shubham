package com.gbcontest.gbcontest.Model;

import java.util.ArrayList;

public class ResponseModel {
    ArrayList<TVShowModel> listData;

    public ResponseModel(ArrayList<TVShowModel> listData) {
        this.listData = listData;
    }

    public ArrayList<TVShowModel> getListData() {
        return listData;
    }

    public void setListData(ArrayList<TVShowModel> listData) {
        this.listData = listData;
    }
}
