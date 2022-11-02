package travel.w2m.prueba;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.security.test.context.support.WithUserDetails;

@RunWith(Parameterized.class)
public class IntegrationTest {

	@Parameterized.Parameters
	public static Collection testFindByName() {
		return Arrays.asList(new Object[][] {
				{ "http://localhost:8081/heroes/findByName?name=man", 5L },
				{ "http://localhost:8081/heroes/findByName?name=super", 2L },
				{ "http://localhost:8081/heroes/findByName?name=e", 6L },
				{ "http://localhost:8081/heroes/findByName?name=ruiz", 1L },
				{ "http://localhost:8081/heroes/findByName?name=mus", 1L } });
	}

	@ParameterizedTest
	@MethodSource("testFindByName")
	@WithUserDetails(value = "admin")
	void test(String url, long expectedValue) {
		System.out.println("testing Url : " + url);
		urlTest(url, expectedValue);
	}

	private void urlTest(String url, long expectedValue) {
		try {
			// Given
			String jsonMimeType = "application/json";
			HttpUriRequest request = new HttpGet(url);

			CredentialsProvider credentialsPovider = new BasicCredentialsProvider();
			credentialsPovider.setCredentials(new AuthScope(null, 8081), 
					   new UsernamePasswordCredentials("admin", "1234"));
			
			// When
			HttpResponse response = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsPovider).build().execute(request);
			// Then
			String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
			assertEquals(jsonMimeType, mimeType);
			HttpEntity entity = response.getEntity();
			String jsonString = EntityUtils.toString(entity);
			JSONArray jsonArray = new JSONArray(jsonString);
			assertEquals(expectedValue, jsonArray.length());

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
