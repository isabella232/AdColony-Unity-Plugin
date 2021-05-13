package com.adcolony.unityplugin;

import android.util.Log;

import com.adcolony.sdk.AdColonyCustomMessage;
import com.adcolony.sdk.AdColonyCustomMessageListener;

import java.util.HashMap;
import java.util.Map;

public class UnityADCAdColonyCustomMessageListener implements AdColonyCustomMessageListener {

    public void onAdColonyCustomMessage(AdColonyCustomMessage message) {
        Map<String, Object> data = new HashMap<>();
        if (message != null) {
            data.put("type", message.getType());
            data.put("message", message.getMessage());
            Log.d("UnityADCAds", "onAdColonyCustomMessage: type: " + message.getType() + ", message: " + message.getMessage());
        }
        UnityADCAds.sendUnityMessage("_OnCustomMessageReceived", UnityADCUtils.toJson(data));
    }
}
