package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {
    @Test
    void checkDataProcessor() {
        Database databaseMock = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(databaseMock);
        //anyString применяется чтобы не передавать ничего конкретного, а получать конкретный результат
        //метод query возвращает список - используем Arrays.asList для преобразования массива строк в Список
        when(databaseMock.query(anyString())).thenReturn(Arrays.asList("one", "two"));

        //вызов основного тестируемого метода с любой строкой (anyString)
        List<String> result = dataProcessor.processData("three");

        //Проверка вызывался ли метод, с какими параметрами и сколько раз
        verify(databaseMock, times(1)).query("three");
        assertThat(result).isNotEmpty().hasSize(2).isEqualTo(Arrays.asList("one","two"));
    }
}