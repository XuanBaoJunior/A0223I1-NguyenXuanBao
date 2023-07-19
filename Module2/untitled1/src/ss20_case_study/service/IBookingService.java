package ss20_case_study.service;

import ss20_case_study.model.Booking;

public interface IBookingService extends Service{
    void checkBookingStatus(Booking booking);
    void cancelBooking(Booking booking);
}
