package affle.com.wcart.models;

import affle.com.wcart.interfaces.IViewType;

/**
 * Created by root on 7/22/16.
 */
public class ChallengeNoDataModel implements IViewType {
    private String mChallengeTitle;

    public ChallengeNoDataModel(String challengeTitle) {
        this.mChallengeTitle = challengeTitle;
    }

    public String getChallengeTitle() {
        return this.mChallengeTitle;
    }

    public void setChallengeTitle(String challengeTitle) {
        this.mChallengeTitle = challengeTitle;
    }

    @Override
    public int getViewType() {
        return IViewType.VIEW_TYPE_NO_DATA;
    }
}
