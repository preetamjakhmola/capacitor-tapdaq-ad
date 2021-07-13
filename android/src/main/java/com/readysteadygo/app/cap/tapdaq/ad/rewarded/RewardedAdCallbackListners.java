package com.readysteadygo.app.cap.tapdaq.ad.rewarded;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

import com.google.android.gms.common.util.BiConsumer;

public class RewardedAdCallbackListners {
    public void getOnUserEarnedRewardListener(PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        JSObject response =new JSObject();
        response.put("type", "Milestone")
                .put("amount", 1);
        notifyListenersFunction.accept(RewardAdPluginEvents.Rewarded, response);
        call.resolve(response);
    }

    public void FailedToShowRewardAdListener(PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        JSObject response =new JSObject();
        response.put("type", "Milestone")
                .put("amount", 1);
        notifyListenersFunction.accept(RewardAdPluginEvents.FailedToShow, response);
        call.resolve(response);
    }
   /* public RewardedAdLoadCallback getRewardedAdLoadCallback(PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        JSObject response =new JSObject();
        response.put("type", "Milestone")
                .put("amount", 1);
        notifyListenersFunction.accept(RewardAdPluginEvents.FailedToShow, response);
        call.resolve(response);
    }*/


}
