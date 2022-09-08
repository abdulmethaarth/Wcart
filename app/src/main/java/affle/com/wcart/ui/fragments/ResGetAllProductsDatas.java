package affle.com.wcart.ui.fragments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import affle.com.wcart.models.response.ResBase;

public class ResGetAllProductsDatas extends ResBase {
    @SerializedName("allProductData")
    @Expose
    private ArrayList<ResAllProductsData> allProductData = new ArrayList<ResAllProductsData>();


    public ArrayList<ResAllProductsData> getAllProductData() {
        return allProductData;
    }

    public void setAllProductData(ArrayList<ResAllProductsData> allProductData) {
        this.allProductData = allProductData;
    }

}
