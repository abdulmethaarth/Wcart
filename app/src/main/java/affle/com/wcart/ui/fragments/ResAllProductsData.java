package affle.com.wcart.ui.fragments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResAllProductsData {
    @SerializedName("productID")
    @Expose
    private String productID;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("name")
    @Expose
    private String name;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
