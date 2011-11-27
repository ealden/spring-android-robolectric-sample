package net.ealden.android.activity;

import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import net.ealden.android.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import static net.ealden.android.RestTemplateFactory.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(RobolectricTestRunner.class)
public class SpringAndroidRobolectricActivityTest {
    private SpringAndroidRobolectricActivity_ activity;

    private RestTemplate restTemplate;

    private TextView outputArea;
    private Button callWebService;

    @Before
    public void setUp() {
        activity = new SpringAndroidRobolectricActivity_();
        activity.onCreate(null);

        restTemplate = mock(RestTemplate.class);
        setRestTemplate(restTemplate);

        outputArea = (TextView) activity.findViewById(R.id.outputArea);
        callWebService = (Button) activity.findViewById(R.id.callWebService);
    }

    @Test
    public void shouldReplaceOutputAreaTextWhenWebServiceIsCalled() {
        String message = "Hello, world!";

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(message);

        activity.callWebService();

        assertThat(outputArea.getText().toString(), is(equalTo(message)));
        verify(restTemplate).getForObject(anyString(), eq(String.class));
    }
}
