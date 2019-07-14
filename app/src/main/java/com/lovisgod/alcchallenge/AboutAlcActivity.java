package com.lovisgod.alcchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutAlcActivity extends AppCompatActivity {

    private ProgressDialog newProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("About ALC");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        newProgress = new ProgressDialog(AboutAlcActivity.this);
        newProgress.setMessage("Please wait while page is loading!!!");
        newProgress.show();

        WebView webView = (WebView) findViewById(R.id.webview);
        //Enabling javascript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://andela.com/alc/");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                newProgress.dismiss();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //handle the error
                handler.proceed();
            }
        });
    }
}
