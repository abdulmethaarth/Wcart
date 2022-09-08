package affle.com.wcart.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import affle.com.wcart.network.BaseResponse;

public class Banners extends BaseResponse {
    @SerializedName("productCatData")
    @Expose
    private ArrayList<Banner> banners;

    public ArrayList<Banner> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<Banner> banners) {
        this.banners = banners;
    }
}