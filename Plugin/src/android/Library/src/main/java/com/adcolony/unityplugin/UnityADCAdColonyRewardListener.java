package com.adcolony.unityplugin;

import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;

public class UnityADCAdColonyRewardListener implements AdColonyRewardListener {

    public void onReward(AdColonyReward reward) {
        UnityADCAds.sendUnityMessage("_OnRewardGranted", UnityADCUtils.rewardToJson(reward));
    }
}
