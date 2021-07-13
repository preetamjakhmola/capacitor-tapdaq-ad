package com.readysteadygo.app.cap.tapdaq.ad.rewarded;


import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.util.Supplier;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.google.android.gms.common.util.BiConsumer;
import com.readysteadygo.app.cap.tapdaq.ad.TapdaqInitListener;
import com.readysteadygo.app.cap.tapdaq.ad.models.Executor;
import com.tapdaq.sdk.STATUS;
import com.tapdaq.sdk.Tapdaq;
import com.tapdaq.sdk.TapdaqConfig;
import com.tapdaq.sdk.adnetworks.TMMediationNetworks;

import java.util.Arrays;
import java.util.Set;

public class AdRewardExecutor extends Executor {
    private static String  AdUnitId= "";

    private final String TAG = AdRewardExecutor.class.getSimpleName();

    public AdRewardExecutor(
        Supplier<Context> contextSupplier,
        Supplier<Activity> activitySupplier,
        BiConsumer<String, JSObject> notifyListenersFunction,
        String pluginLogTag
    ) {
        super(contextSupplier, activitySupplier, notifyListenersFunction, pluginLogTag, "AdRewardExecutor");
    }

    @PluginMethod
    public void prepareRewardVideoAd(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {
        //final AdOptions adOptions = AdOptions.getFactory().createRewardVideoOptions(call);

        activitySupplier
            .get()
            .runOnUiThread(
                () -> {
                    try {
                        //final AdRequest adRequest = RequestHelper.createRequest(adOptions);
                        final String adUnitId =call.getString("adId"); //AdViewIdHelper.getFinalAdId(adOptions, adRequest, logTag, contextSupplier.get());
                        final String clientKey =call.getString("clientKey");
                        AdUnitId = adUnitId;

                        TapdaqConfig config = Tapdaq.getInstance().config();
                        config.setUserSubjectToGDPR(STATUS.TRUE); //GDPR declare if user is in EU
                        config.setConsentStatus(STATUS.TRUE); //GDPR consent must be obtained from the user
                        config.setAgeRestrictedUserStatus(STATUS.FALSE); //Is user subject to COPPA or GDPR age restrictions

                        config.registerTestDevices(TMMediationNetworks.ADCOLONY, Arrays.asList("vzca8158d3744449a6a8"));
                        Tapdaq.getInstance().initialize(activitySupplier.get(),
                                AdUnitId, clientKey, config,
                                new TapdaqInitListener(call, activitySupplier.get(),notifyListenersFunction));

                         JSObject jsObject = new JSObject();
                         jsObject.put("Ad Prepared","Add is ready to show now.");
                        call.resolve(jsObject);
                    } catch (Exception ex) {
                        call.reject(ex.getLocalizedMessage(), ex);
                    }
                }
            );
    }



    @PluginMethod
    public void showRewardVideoAd(final PluginCall call, BiConsumer<String, JSObject> notifyListenersFunction) {

        try {
            activitySupplier
                .get()
                .runOnUiThread(
                    () -> {


                        JSObject jsObject = new JSObject();
                        jsObject.put("Ad showed","Add is showed.");
                        call.resolve(jsObject);
                    }
                );
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }
}
