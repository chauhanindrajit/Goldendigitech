package dotcom.com.sam.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import dotcom.com.sam.R;

public class EDoctor extends AppCompatActivity {
    private WebView mWebview;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edoctor);
        mWebview = (WebView) findViewById(R.id.help_webview);
        mWebview = new WebView(this);
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        final Activity activity = this;

        mWebview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                setTitle("Loading...");
                setProgress(progress * 100); //Make the bar disappear after URL is loaded

                // Return the app name after finish loading
                if (progress == 100)
                    setTitle(R.string.app_name);
            }
        });
        //  mWebview.setWebViewClient(new EDoctor());
        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.loadUrl("http://worldindia.in/sam1/e-doctor.html");
//        pDialog.hide();
        setContentView(mWebview);
    }
}
