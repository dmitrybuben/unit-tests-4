package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class NotificationServiceTest {
    @Test
    void checkSendNotification() {
        MessageService messageServiceMock = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageServiceMock);

        notificationService.sendNotification("Test", "TestUser");

        verify(messageServiceMock, times(1)).sendMessage("Test","TestUser");
    }
}