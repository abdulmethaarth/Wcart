package affle.com.wcart.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 6/14/16.
 */
public class ResSignUp extends ResBase {
    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("shareCodeUser")
    @Expose
    private String shareCodeUser;

    /**
     * @return The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getShareCodeUser() {
        return shareCodeUser;
    }

    public void setShareCodeUser(String shareCodeUser) {
        this.shareCodeUser = shareCodeUser;
    }
}
