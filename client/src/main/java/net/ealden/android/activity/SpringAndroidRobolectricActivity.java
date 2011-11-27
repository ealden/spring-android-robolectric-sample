package net.ealden.android.activity;

import android.app.Activity;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import net.ealden.android.R;

@EActivity(R.layout.main)
public class SpringAndroidRobolectricActivity extends Activity {
    @ViewById(R.id.outputArea)
    TextView outputArea;

    @Click(R.id.callWebService)
    public void callWebService() {
        outputArea.setText("Hello!");
    }
}
