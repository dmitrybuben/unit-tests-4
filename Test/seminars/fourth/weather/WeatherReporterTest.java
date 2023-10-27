package seminars.fourth.weather;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    void checkWeatherReporter() {
        //главный (source код) - WeatherReporter поэтому мок на WeatherService
        WeatherService weatherServiceMock = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherServiceMock);
        /*Тестируем метод GenerateReport, есть возвращаемый тип данных - используем when, предустанавливаем поведение
        для мокированного сервиса - вместо настоящего ответа связного сервиса ставим свою реализацию*/
        when(weatherServiceMock.getCurrentTemperature()).thenReturn(25);
        // Вызов настоящего метода в основном коде
        String report = weatherReporter.generateReport();

        verify(weatherServiceMock, times(1)).getCurrentTemperature();
        assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }

}