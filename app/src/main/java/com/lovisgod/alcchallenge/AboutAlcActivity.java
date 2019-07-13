package com.lovisgod.alcchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("About ALC");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        WebView webView = (WebView) findViewById(R.id.webview);
        //Enabling javascript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://andela.com/alc/");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //handle the error
                handler.proceed();
            }
        });
    }
}
