package ss20_case_study.repository;

import ss20_case_study.model.Booking;

import java.util.List;

public interface IBookingRepository extends Repository {
    Booking getBookingById(String id);
    List<Booking> getAllBookings();
}
