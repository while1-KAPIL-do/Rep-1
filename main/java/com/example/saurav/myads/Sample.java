package com.example.saurav.myads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class Sample extends AppCompatActivity {

    AdView mAdView_01;
    RewardedVideoAd mRewardedVideoAd;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        MobileAds.initialize(this,getResources().getString(R.string.sample_app_Id));

//********** Banner *********
        mAdView_01 = (AdView)findViewById(R.id.adview1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView_01.loadAd(adRequest1);
//*********/ Banner *********

// ******** video
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.getRewardedVideoAdListener();
        loadRewordedVideoAds();
    }

    private void loadRewordedVideoAds(){
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(getResources().getString(R.string.sample_rewarded_addId),new AdRequest.Builder().build());
        }
    }

    public void reward_1_btn(View view) {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }else{
            Toast.makeText(Sample.this, "Reward ad is Not Loaded !", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }
    @Override
    protected void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

//*********/ video



    public void ind_1_btn(View view) {
        AdRequest mAdRequest2 = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(Sample.this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.sample_interstitial_addId));
        mInterstitialAd.loadAd(mAdRequest2);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else{
                    Toast.makeText(Sample.this, "Interstitial ad is Not Loaded !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
