package seminars.fourth.httpService;

import org.junit.jupiter.api.Test;
import seminars.fourth.weather.WeatherService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WebServiceTest {
    @Test
    void checkWebService () {
        HttpClient httpClientMock = mock(HttpClient.class);
        WebService webService = new WebService(httpClientMock, "url");
        when(httpClientMock.sendRequest("url")).thenReturn(Arrays.asList("good!"));

        List<String> res = webService.receiveData("url");

        verify(httpClientMock,times(1)).sendRequest("url");
        assertThat(res).isNotEmpty().hasSize(1).isEqualTo(Arrays.asList("good!"));
    }
}
