package com.lodenrogue.jmaker;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class JMaker {
	private String eventName;
	private String key;

	public JMaker(String eventName, String key) {
		this.eventName = eventName;
		this.key = key;
	}

	public void trigger() throws IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("https://maker.ifttt.com/trigger/" + eventName + "/with/key/" + key);
		httpClient.execute(request);
	}

	public void trigger(List<String> values) throws IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("https://maker.ifttt.com/trigger/" + eventName + "/with/key/" + key);
		StringEntity params = new StringEntity(buildJson(values));
		request.addHeader("content-type", "application/json");
		request.setEntity(params);
		httpClient.execute(request);
	}

	private String buildJson(List<String> values) {
		String json = "{";
		for (int i = 0; i < 3; i++) {
			if (values.size() > i) {
				json += "\"value" + (i + 1) + "\":\"" + values.get(i) + "\"";
				if (i != 2) {
					json += ",";
				}
			}
			else {
				break;
			}
		}
		json += "}";
		return json;
	}

}
