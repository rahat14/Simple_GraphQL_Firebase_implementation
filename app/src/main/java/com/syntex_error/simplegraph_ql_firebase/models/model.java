package com.syntex_error.simplegraph_ql_firebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class model {
    @SerializedName("data")
    @Expose
    private dataModel data;

    public dataModel getData() {
        return data;
    }

    public void setData(dataModel data) {
        this.data = data;
    }
}
