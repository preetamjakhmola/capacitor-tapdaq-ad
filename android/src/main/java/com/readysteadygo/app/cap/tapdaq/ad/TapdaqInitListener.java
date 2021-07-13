package com.readysteadygo.app.cap.tapdaq.ad;

import android.app.Activity;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.google.android.gms.common.util.BiConsumer;
import com.readysteadygo.app.cap.tapdaq.ad.rewarded.RewardAdPluginEvents;
import com.readysteadygo.app.cap.tapdaq.ad.rewarded.RewardedVideoListener;
import com.tapdaq.sdk.Tapdaq;
import com.tapdaq.sdk.common.TMAdError;
import com.tapdaq.sdk.listeners.TMInitListener;

public class TapdaqInitListener extends TMInitListener {
    private Activity mCurrentActivity = null;
    private PluginCall  _call=null;
    public String placementName ="";
    private BiConsumer<String, JSObject> _notifyListenersFunction=null;
    public TapdaqInitListener(final PluginCall call, Activity context, BiConsumer<String, JSObject> notifyListenersFunction) {
        mCurrentActivity = context;
        _call=call;
        _notifyListenersFunction= notifyListenersFunction;
        placementName =_call.getString("placementName");
    }

    public void didInitialise() {
        super.didInitialise();
        // Ads may now be requested
        Tapdaq.getInstance().loadRewardedVideo(mCurrentActivity, placementName, new RewardedVideoListener(_call,mCurrentActivity,_notifyListenersFunction));

    }

    @Override
    public void didFailToInitialise(TMAdError error) {
        super.didFailToInitialise(error);
        //Tapdaq failed to initialise
        String sss="";
        JSObject jsObject  = new JSObject();
        jsObject.put("Code",error.getErrorCode()).put("Message",error.getErrorMessage());

        _notifyListenersFunction.accept(RewardAdPluginEvents.FailedToLoad, jsObject);
        _call.resolve(jsObject);
    }
}
