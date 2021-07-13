package com.readysteadygo.app.cap.tapdaq.ad.rewarded;

import android.app.Activity;
import android.widget.Toast;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.google.android.gms.common.util.BiConsumer;
import com.readysteadygo.app.cap.tapdaq.ad.models.PluginEventNames;
import com.tapdaq.sdk.Tapdaq;
import com.tapdaq.sdk.common.TMAdError;
import com.tapdaq.sdk.listeners.TMAdListener;
import com.tapdaq.sdk.model.rewards.TDReward;

public class RewardedVideoListener extends TMAdListener {

    private Activity mCurrentActivity = null;
    private PluginCall  _call=null;
    public String placementName ="";
    private BiConsumer<String, JSObject> _notifyListenersFunction=null;
    public RewardedVideoListener(final PluginCall call, Activity context, BiConsumer<String, JSObject> notifyListenersFunction) {
        mCurrentActivity = context;
        _call = call;
        placementName =_call.getString("placementName");
         _notifyListenersFunction = notifyListenersFunction;
    }
    @Override
    public void didLoad() {
        // Rewarded video is loaded, enable your rewarded video button

        boolean isReady = Tapdaq.getInstance().isRewardedVideoReady(mCurrentActivity,placementName);
        if (isReady) {
            Tapdaq.getInstance().showRewardedVideo(mCurrentActivity, placementName, new TMAdListener(){
                @Override
                public void didClose() {
                   /* Toast t = Toast.makeText(mCurrentActivity.getApplicationContext(),
                            "Reward is Added",Toast.LENGTH_LONG);
                    t.show();*/
                    JSObject jsObject = new JSObject();
                    jsObject.put("Reward","Milestone").put("value","1");
                    _notifyListenersFunction.accept(RewardAdPluginEvents.Rewarded, jsObject);
                    _call.resolve(jsObject);
                }
            });
        } else {
            // Do something else
            JSObject jsObject  = new JSObject();
            jsObject.put("Error","Something went wrong! Instance is not ready.");

            _notifyListenersFunction.accept(RewardAdPluginEvents.FailedToShow, jsObject);
            _call.resolve(jsObject);
        }

    }
    @Override
    public void didVerify(TDReward reward) {

    String ss="";
    }

    @Override
    public void didRefresh() {
    }

    @Override
    public void didFailToRefresh(TMAdError error) {

    }

    @Override
    public void willDisplay() {
    }

    @Override
    public void didDisplay() {
    }

    @Override
    public void didFailToDisplay(TMAdError error) {

    }

    @Override
    public void didClick() {
    }

    @Override
    public void didClose() {
        JSObject jsObject  = new JSObject();
        jsObject.put("Reward","Milestone").put("Value","1");

        _notifyListenersFunction.accept(RewardAdPluginEvents.Rewarded, jsObject);
        _call.resolve(jsObject);
    }

    @Override
    public void didFailToLoad(TMAdError error) {

        JSObject jsObject  = new JSObject();
        jsObject.put("Code",error.getErrorCode()).put("Message",error.getErrorMessage());

        _notifyListenersFunction.accept(RewardAdPluginEvents.FailedToLoad, jsObject);
        _call.resolve(jsObject);
       /* Toast t = Toast.makeText(mCurrentActivity.getApplicationContext(),
                error.getErrorMessage(),Toast.LENGTH_LONG);
        t.show();*/
    }

    @Override
    public void didComplete() {


    }

    @Override
    public void didEngagement() {
    }

    @Override
    public void didRewardFail(TMAdError error) {
    }

    @Override
    public void onUserDeclined() {
    }
}
