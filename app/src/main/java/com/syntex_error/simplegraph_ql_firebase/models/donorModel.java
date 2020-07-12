package com.syntex_error.simplegraph_ql_firebase.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class donorModel {

     @SerializedName("namee")
     @Expose
     private String namee;
     @SerializedName("ph")
     @Expose
     private String ph;

     public String getNamee() {
         return namee;
     }

     public void setNamee(String namee) {
         this.namee = namee;
     }

     public String getPh() {
         return ph;
     }

     public void setPh(String ph) {
         this.ph = ph;
     }

}