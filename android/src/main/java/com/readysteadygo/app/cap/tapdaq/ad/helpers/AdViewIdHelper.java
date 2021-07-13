package com.readysteadygo.app.cap.tapdaq.ad.helpers;

import android.content.Context;
import android.util.Log;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;*/
import com.readysteadygo.app.cap.tapdaq.ad.models.AdOptions;


public final class AdViewIdHelper {

    private AdViewIdHelper() {}

    public static String getFinalAdId(AdOptions adOptions, String adRequest, String logTag, Context context) {
        if (!adOptions.isTesting) {
            return adOptions.adId;
        }

        if (true) {
            Log.w(logTag, "This device is registered as Testing Device. The real Ad Id will be used");
            return adOptions.adId;
        }

        return adOptions.getTestingId();
    }

   /* public static void assignIdToAdView(AdView adView, AdOptions adOptions, AdRequest adRequest, String logTag, Context context) {
        String finalId = getFinalAdId(adOptions, adRequest, logTag, context);
        adView.setAdUnitId(finalId);
        Log.d(logTag, "Ad ID: " + finalId);
    }*/
}
