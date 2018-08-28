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

public class MyApp_02 extends AppCompatActivity {

    AdView mAdView_01,mAdView_02,mAdView_03,mAdView_04,mAdView_05,mAdView_06,mAdView_07,mAdView_08,mAdView_09,mAdView_10;
    RewardedVideoAd mRewardedVideoAd;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_app_02);

        MobileAds.initialize(this,getResources().getString(R.string.app_02_Id));

//********** Banner *********
        mAdView_01 = (AdView)findViewById(R.id.adview_01);
        mAdView_02 = (AdView)findViewById(R.id.adview_02);
        mAdView_03 = (AdView)findViewById(R.id.adview_03);
        mAdView_04 = (AdView)findViewById(R.id.adview_04);
        mAdView_05 = (AdView)findViewById(R.id.adview_05);
        mAdView_06 = (AdView)findViewById(R.id.adview_06);
        mAdView_07 = (AdView)findViewById(R.id.adview_07);
        mAdView_08 = (AdView)findViewById(R.id.adview_08);
        mAdView_09 = (AdView)findViewById(R.id.adview_09);
        mAdView_10 = (AdView)findViewById(R.id.adview_10);

        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView_01.loadAd(adRequest1);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView_02.loadAd(adRequest2);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView_03.loadAd(adRequest3);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        mAdView_04.loadAd(adRequest4);
        AdRequest adRequest5 = new AdRequest.Builder().build();
        mAdView_05.loadAd(adRequest5);
        AdRequest adRequest6 = new AdRequest.Builder().build();
        mAdView_06.loadAd(adRequest6);
        AdRequest adRequest7 = new AdRequest.Builder().build();
        mAdView_07.loadAd(adRequest7);
        AdRequest adRequest8 = new AdRequest.Builder().build();
        mAdView_08.loadAd(adRequest8);
        AdRequest adRequest9 = new AdRequest.Builder().build();
        mAdView_09.loadAd(adRequest9);
        AdRequest adRequest10 = new AdRequest.Builder().build();
        mAdView_10.loadAd(adRequest10);
//*********/ Banner *********

// ******** video
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.getRewardedVideoAdListener();
        loadRewordedVideoAds();
    }

    private void loadRewordedVideoAds(){
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(getResources().getString(R.string.app_02_rewarded_addId),new AdRequest.Builder().build());
        }
    }

    public void reward_1_btn(View view) {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }else{
            Toast.makeText(MyApp_02.this, "Reward ad is Not Loaded !", Toast.LENGTH_SHORT).show();
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
        mInterstitialAd = new InterstitialAd(MyApp_02.this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.app_02_interstitial_addId));
        mInterstitialAd.loadAd(mAdRequest2);
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else{
                    Toast.makeText(MyApp_02.this, "Interstitial ad is Not Loaded !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
