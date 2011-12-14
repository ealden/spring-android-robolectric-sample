package net.ealden.android.activity;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import net.ealden.android.R;
import org.springframework.web.client.RestClientException;

import static net.ealden.android.RestTemplateFactory.*;

@EActivity(R.layout.main)
public class SpringAndroidRobolectricActivity extends Activity {
    protected static final String TAG = SpringAndroidRobolectricActivity.class.getSimpleName();

    @ViewById(R.id.outputArea)
    TextView outputArea;

    @Click(R.id.callWebService)
    public void callWebService() {
        retrieveData();
    }

    @Background
    void retrieveData() {
        String result = null;

        try {
            result = getRestTemplate().getForObject("http://10.0.2.2:8080/server", String.class);
        } catch (RestClientException e) {
            Log.e(TAG, "Unable to connect to webservice", e);
        }

        System.out.println("DONE retrieveData()");

        displayData(result);
    }

    @UiThread
    void displayData(final String result) {
        if (result != null) {
            outputArea.setText(result);
        } else {
            Toast.makeText(SpringAndroidRobolectricActivity.this, "Unable to connect to webservice.", Toast.LENGTH_LONG).show();
        }
    }
}
