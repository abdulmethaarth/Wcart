package affle.com.wcart.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import affle.com.wcart.network.BaseResponse;

public class Banner extends BaseResponse {
    @SerializedName("IMG")
    @Expose
    private String IMG;

    public String getIMG() {
        return IMG;
    }

    public void setIMG(String IMG) {
        this.IMG = IMG;
    }
}
