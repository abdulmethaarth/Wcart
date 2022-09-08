package affle.com.wcart.models.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akash on 13/10/16.
 */
public class ReqPrizeMoneyDetails extends ReqBase {
    @SerializedName("userID")
    @Expose
    private String userID;

    /**
     *
     * @return
     * The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
}
