package net.ealden.android.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import net.ealden.android.R;

import static net.ealden.android.RestTemplateFactory.*;

@EActivity(R.layout.main)
public class SpringAndroidRobolectricActivity extends Activity {
    @ViewById(R.id.outputArea)
    TextView outputArea;

    @Click(R.id.callWebService)
    public void callWebService() {
        new GetAsyncTask().execute();
    }

    private class GetAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            String result = getRestTemplate().getForObject("http://10.0.2.2:8080/server", String.class);

            return result;
        }

        @Override
        protected void onPostExecute(final String result) {
            outputArea.setText(result);
        }
    }
}
