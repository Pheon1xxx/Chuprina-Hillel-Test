import org.apache.hc.core5.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.ResponseUtil;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpClientGeek {
    private static final String GFG_URL = "https://www.geeksforgeeks.org/";
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse httpResponse;

    @Before
    public final void before() {
        httpClient = HttpClientBuilder.create().build();
    }
    @After
    public final void after() throws IllegalStateException, IOException {
        ResponseUtil.closeResponse(httpResponse);
    }

    @Test
    public final void usageOfCustomUserAgentCheck() throws ClientProtocolException, IOException {
        httpClient = HttpClients.custom().setUserAgent("Mozilla/5.0 Firefox/26.0").build();
        final HttpGet getRequest = new HttpGet(GFG_URL);
        httpResponse = httpClient.execute(getRequest);
        assertThat(httpResponse.getStatusLine()
                .getStatusCode()).isEqualTo((200));
    }

    @Test
    public final void usageOfCustomUserType1() throws ClientProtocolException, IOException {
        httpClient = HttpClients.custom().build();
        final HttpUriRequest request = RequestBuilder
                .get().setUri(GFG_URL).
                setHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();
        httpResponse = httpClient.execute(request);
        assertThat(httpResponse.getStatusLine()
                .getStatusCode()).isEqualTo((200));
    }

    @Test
    public final void usageOfCustomUserType2() throws ClientProtocolException, IOException {
        final CloseableHttpClient client2 = HttpClients.custom().build();
        final HttpGet request = new HttpGet(GFG_URL);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpResponse = client2.execute(request);
        assertThat(httpResponse.getStatusLine()
                .getStatusCode()).isEqualTo((200));

    }

    @Test
    public final void usageOfCustomUserAgentCheckWithContentType() throws ClientProtocolException, IOException {
        httpClient = HttpClients.custom().build();
        final HttpGet request = new HttpGet(GFG_URL);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpResponse = httpClient.execute(request);
        assertThat(httpResponse.getStatusLine()
                .getStatusCode()).isEqualTo((200));
    }

}
