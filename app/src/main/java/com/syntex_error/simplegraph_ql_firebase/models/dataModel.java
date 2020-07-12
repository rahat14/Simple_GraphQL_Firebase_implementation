package com.syntex_error.simplegraph_ql_firebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dataModel {

    @SerializedName("donors")
    @Expose
    private List<donorModel> donors = null;

    public List<donorModel> getDonors() {
        return donors;
    }

    public void setDonors(List<donorModel> donors) {
        this.donors = donors;
    }
}
