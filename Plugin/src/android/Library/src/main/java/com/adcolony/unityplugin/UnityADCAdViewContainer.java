package com.adcolony.unityplugin;


import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyAdViewListener;
import com.adcolony.sdk.AdColonyZone;
import com.unity3d.player.UnityPlayer;

import java.util.UUID;

public class UnityADCAdViewContainer extends AdColonyAdViewListener {
    public String id = UUID.randomUUID().toString();
    public UnityADCAdViewAds ad = null;
    int adPosition;

    UnityADCAdViewContainer(int adPosition) {
        this.adPosition = adPosition;
    }

    @Override
    public void onRequestFilled(AdColonyAdView adColonyAdView) {
        this.ad = new UnityADCAdViewAds(adColonyAdView, id, adPosition);
        if (isAdViewAdded()) {
            UnityADCAds.sendUnityMessage("_OnAdColonyAdViewLoaded", this.ad.toJson());
        } else {
            UnityADCAds.sendUnityMessage("_OnAdColonyAdViewFailedToLoad", UnityADCUtils.adDetailsToJson(adColonyAdView.getZoneId(),adPosition));
            UnityADCAds.destroyAdView(id);
        }
    }

    protected void finalize() throws Throwable {
    }

    @Override
    public void onLeftApplication(AdColonyAdView ad) {
        String json = this.ad.toJson();
        UnityADCAds.sendUnityMessage("_OnAdColonyAdViewLeftApplication", json);
    }

    @Override
    public void onClosed(AdColonyAdView ad) {
        String json = this.ad.toJson();
        UnityADCAds.sendUnityMessage("_OnAdColonyAdViewClosed", json);
    }

    @Override
    public void onOpened(AdColonyAdView ad) {
        if (this.ad == null) {
            Log.e("UnityADCAds", "onOpened called without request handled");
            return;
        }
        String json = this.ad.toJson();
        UnityADCAds.sendUnityMessage("_OnAdColonyAdViewOpened", json);
    }

    @Override
    public void onClicked(AdColonyAdView ad) {
        String json = this.ad.toJson();
        UnityADCAds.sendUnityMessage("_OnAdColonyAdViewClicked", json);
    }

    @Override
    public void onRequestNotFilled(AdColonyZone zone) {
        UnityADCAds.sendUnityMessage("_OnAdColonyAdViewFailedToLoad", UnityADCUtils.adDetailsToJson(zone,adPosition));
        UnityADCAds.destroyAdView(id);
    }

    boolean isAdViewAdded() {
        if(this.ad != null) {
            FrameLayout.LayoutParams adContainerParams = new FrameLayout.LayoutParams(-2, -2);
            switch (this.ad.getAdPosition()) {
                case 0:
                    adContainerParams.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                    break;
                case 1:
                    adContainerParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                    break;
                case 2:
                    adContainerParams.gravity = Gravity.TOP | Gravity.LEFT;
                    break;
                case 3:
                    adContainerParams.gravity = Gravity.TOP | Gravity.RIGHT;
                    break;
                case 4:
                    adContainerParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
                    break;
                case 5:
                    adContainerParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
                    break;
                case 6:
                    adContainerParams.gravity = Gravity.CENTER;
            }

            Activity activity = UnityPlayer.currentActivity;
            activity.addContentView(this.ad.get_ad(), adContainerParams);
            return true;
        }
        return false;
    }
}
