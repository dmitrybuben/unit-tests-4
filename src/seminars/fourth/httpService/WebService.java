package seminars.fourth.httpService;

import java.util.List;

public class WebService {
    private HttpClient client;
    private String url;

    public WebService(HttpClient httpClient, String url) {
        this.client = httpClient;
        this.url = url;
    }

    public List<String> receiveData(String url) {
        return client.sendRequest(url);
    }
}
