package net.ealden.android.activity;

import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import net.ealden.android.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
public class SpringAndroidRobolectricActivityTest {
    private SpringAndroidRobolectricActivity_ activity;

    private TextView outputArea;
    private Button callWebService;

    @Before
    public void setUp() {
        activity = new SpringAndroidRobolectricActivity_();
        activity.onCreate(null);

        outputArea = (TextView) activity.findViewById(R.id.outputArea);
        callWebService = (Button) activity.findViewById(R.id.callWebService);
    }

    @Test
    public void shouldReplaceOutputAreaTextWhenWebServiceIsCalled() {
        activity.callWebService();

        assertThat(outputArea.getText().toString(), is(equalTo("Hello!")));
    }
}
