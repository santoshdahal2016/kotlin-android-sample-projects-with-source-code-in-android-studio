package com.visitbazar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {

    internal lateinit var webView: WebView

    internal lateinit var swipe: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_main)

        swipe = findViewById(R.id.swipe) as SwipeRefreshLayout
        swipe.setOnRefreshListener { LoadWeb() }

        LoadWeb()


    }


    fun LoadWeb() {

        webView = findViewById(R.id.webView) as WebView
        webView.settings.javaScriptEnabled = true
        webView.settings.setAppCacheEnabled(true)
        webView.loadUrl("https://visitbazar.com/")
        swipe.isRefreshing = true
        webView.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {

                webView.loadUrl("file:///android_asset/error.html")
            }

            override fun onPageFinished(view: WebView, url: String) {

                //Hide the SwipeReefreshLayout

                swipe.isRefreshing = false
            }

        }
    }


    override fun onBackPressed() {

        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}
