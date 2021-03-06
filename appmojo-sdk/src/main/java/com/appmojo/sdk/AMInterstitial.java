package com.appmojo.sdk;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.Log;

import com.appmojo.sdk.base.AMAdNetwork;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class AMInterstitial implements AMView {
    private static final String TAG = "AMInterstitial";

    @IntDef({DAY, HOUR, SESSION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrequencyCap {}
    public static final int DAY = 0;
    public static final int HOUR = 1;
    public static final int SESSION = 2;

    private final AMController mAMController;
    private String mPlacementUid;
    private AMListener mListener;
    private Context mContext;

    public AMInterstitial(Context context) {
        mContext = context;
        mAMController = AMViewControllerFactory.create(mContext, this, AMAdType.INTERSTITIAL);
    }

    public void setListener(AMInterstitialListener listener) {
        mListener = listener;
    }

    public int getSessionFrequency() {
        return ((AMInterstitialController)mAMController).getSessionFrequency();
    }

    public int getHourFrequency() {
        return ((AMInterstitialController)mAMController).getHourFrequency();
    }

    public int getDayFrequency() {
        return ((AMInterstitialController)mAMController).getDayFrequency();
    }

    @Override
    public void setPlacementUid(String placementUid) {
        mPlacementUid = placementUid;
    }

    @Override
    public String getPlacementUid() {
        return mPlacementUid;
    }

    @Override
    @AMAdNetwork.Network
    public String getAdNetwork() {
        return mAMController.getAdNetwork();
    }

    @Override
    public AMListener getListener() {
        return mListener;
    }

    @Override
    public String getCurrentAdUnitId() {
        return mAMController.getCurrentAdUnitId();
    }

    @Override
    public void reloadAd() {
        mAMController.reloadAd();
    }

    @Override
    public void loadAd(AMAdRequest adRequest) {
        mAMController.loadAd(adRequest);
    }

    public boolean isLoaded() {
        return mAMController instanceof AMInterstitialController && ((AMInterstitialController) mAMController).isLoaded();
    }

    public void show() {
        if(mAMController instanceof AMInterstitialController) {
            ((AMInterstitialController) mAMController).show();
        }
    }

    @Override
    public void destroy() {
        Log.d(TAG, "destroy...");
        mAMController.onDestroy();
        mContext = null;
    }

    AMController getController() {
        return mAMController;
    }
}
