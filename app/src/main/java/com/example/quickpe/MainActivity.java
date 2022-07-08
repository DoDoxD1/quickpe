package com.example.quickpe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Toolbar toolbar;
    String url = "http://quikpe.in/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading quickpe...");
        progressDialog.setMessage("Hang on!");

        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webSettings.setUseWideViewPort(true);
        webView.setInitialScale(1);
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
    }
}