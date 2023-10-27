package seminars.fourth.hotel;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class BookingServiceTest {
    @Test
    void bookingTestPositive() {
        HotelService hotelServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelServiceMock);
        when(hotelServiceMock.isRoomAvailable(2)).thenReturn(true);

        boolean response = bookingService.bookRoom(2);

        verify(hotelServiceMock, times(1)).isRoomAvailable(2);
        assertThat(response).isEqualTo(true);
    }
    @Test
    void bookingTestNegative() {
        HotelService hotelServiceMock = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelServiceMock);
        when(hotelServiceMock.isRoomAvailable(3)).thenReturn(false);

        boolean response = bookingService.bookRoom(3);

        verify(hotelServiceMock, times(1)).isRoomAvailable(3);
        assertThat(response).isEqualTo(false);
    }
}