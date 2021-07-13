package com.readysteadygo.app.cap.tapdaq.ad;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.readysteadygo.app.cap.tapdaq.ad.rewarded.AdRewardExecutor;

import org.json.JSONException;

@CapacitorPlugin(name = "CapTapdaqAd")
public class CapTapdaqAdPlugin extends Plugin {

    private final String TAG = CapTapdaqAdPlugin.class.getSimpleName();
    public static final JSArray EMPTY_TESTING_DEVICES = new JSArray();

    private final AdRewardExecutor adRewardExecutor = new AdRewardExecutor(
            this::getContext,
            this::getActivity,
            this::notifyListeners,
            getLogTag()
    );

    // Initialize Facebook with appId
   /* @PluginMethod
    public void initialize(final PluginCall call) {
        final boolean initializeForTesting = call.getBoolean("initializeForTesting", false);

        if (initializeForTesting) {
            JSArray testingDevices = call.getArray("testingDevices", CapTapdaqAdPlugin.EMPTY_TESTING_DEVICES);
            this.setTestingDevicesTo(call, testingDevices);
        } else {
            this.setTestingDevicesTo(call, EMPTY_TESTING_DEVICES);
        }

        try {
            //bannerExecutor.initialize();
            call.resolve();
        } catch (Exception ex) {
            call.reject(ex.getLocalizedMessage(), ex);
        }
    }*/

    @PluginMethod
    public void prepareRewardVideoAd(final PluginCall call) {

        adRewardExecutor.prepareRewardVideoAd(call, this::notifyListeners);

    }

   /* @PluginMethod
    public void showRewardVideoAd(final PluginCall call) {
        adRewardExecutor.showRewardVideoAd(call, this::notifyListeners);
    }*/
   /* private void setTestingDevicesTo(final PluginCall call, JSArray testingDevices) {
        // TODO: create a function to automatically get the device ID when isTesting is true? https://stackoverflow.com/a/36242494/1255819
        try {
            final RequestConfiguration configuration = new RequestConfiguration.Builder()
                    .setTestDeviceIds(testingDevices.<String>toList())
                    .build();

            MobileAds.setRequestConfiguration(configuration);
        } catch (JSONException error) {
            call.reject(error.toString());
        }
    }*/
}
