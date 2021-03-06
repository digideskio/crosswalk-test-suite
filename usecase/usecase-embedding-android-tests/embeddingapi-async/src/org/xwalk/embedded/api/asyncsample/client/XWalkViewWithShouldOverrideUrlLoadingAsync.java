package org.xwalk.embedded.api.asyncsample.client;

import org.xwalk.embedded.api.asyncsample.R;

import android.app.Activity;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

public class XWalkViewWithShouldOverrideUrlLoadingAsync extends Activity implements XWalkInitializer.XWalkInitListener {
    private XWalkView mXWalkView;
    private XWalkInitializer mXWalkInitializer;
    private TextView mTitleText1;
    private TextView mTitleText2;
    private int count;

    class TestXWalkResourceClientBase extends XWalkResourceClient {

        public TestXWalkResourceClientBase(XWalkView mXWalkView) {
            super(mXWalkView);
        }

        @Override
        public boolean shouldOverrideUrlLoading(XWalkView view, String url) {
            if(url.endsWith("openedWindow.html")) {
                count++;
                mTitleText1.setText("shouldOverrideUrlLoading triggered ");
                mTitleText2.setText(count + " times");
            }
            return super.shouldOverrideUrlLoading(mXWalkView, url);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mXWalkInitializer = new XWalkInitializer(this, this);
        mXWalkInitializer.initAsync();
    }

    @Override
    public final void onXWalkInitStarted() {
        // It's okay to do nothing
    }

    @Override
    public final void onXWalkInitCancelled() {
        // It's okay to do nothing
    }

    @Override
    public final void onXWalkInitFailed() {
        // Do crash or logging or anything else in order to let the tester know if this method get called
    }

    @Override
    public final void onXWalkInitCompleted() {
        StringBuffer mess = new StringBuffer();
        mess.append("Test Purpose: \n\n")
        .append("Verifies shouldOverrideUrlLoading can be triggered navigating to a link that will load externally.\n\n")
        .append("Expected Result:\n\n")
        .append("1. Test passes if app show 'shouldOverrideUrlLoading triggered' and the correct triggered times when click the links to navigate to one page.\n");
        new  AlertDialog.Builder(this)
        .setTitle("Info" )
        .setMessage(mess.toString())
        .setPositiveButton("confirm" ,  null )
        .show();

        setContentView(R.layout.embedding_main);
        mXWalkView = (XWalkView) findViewById(R.id.xwalkview_embedding);
        mXWalkView.setResourceClient(new TestXWalkResourceClientBase(mXWalkView));

        XWalkPreferences.setValue(XWalkPreferences.SUPPORT_MULTIPLE_WINDOWS, true);
        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        XWalkPreferences.setValue(XWalkPreferences.JAVASCRIPT_CAN_OPEN_WINDOW, true);
        mTitleText1 = (TextView) findViewById(R.id.titletext1);
        mTitleText2 = (TextView) findViewById(R.id.titletext2);
        mXWalkView.load("file:///android_asset/navigate.html", null);
    }
}
