package com.lakshay.admob

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val adsFrameLayout = findViewById<AdView>(R.id.adsFrameLayout)

//        AdSize.BANNER
//        loadBannerAds(this, adsFrameLayout, AdSize.BANNER, R.string.banner_ads1)
//        AdSize.LARGE_BANNER
//        loadBannerAds(this,adsFrameLayout,AdSize.LARGE_BANNER,R.string.banner_ads1)
//        AdSize.FULL_BANNER
        loadBannerAds(this, adsFrameLayout, AdSize.FULL_BANNER, R.string.banner_ads1)

        val showInterstitialAdsBtn = findViewById<Button>(R.id.showInterstitialAdsBtn)

        val myInterstitialAds = MyInterstitialAds(this)
        myInterstitialAds.loadInterstitialAds(R.string.myInterstitialAds)

        showInterstitialAdsBtn.setOnClickListener {
            myInterstitialAds.showInterstitialAds {

                //here interstitial finish or dismiss or not load after execute
                val afterIntent= Intent(this,AfterInterstitialFinishedActivity::class.java)
                startActivity(afterIntent)
            }
        }
    }
}