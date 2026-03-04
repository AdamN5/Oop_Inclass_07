package ie.atu.week2lab.oop_inclass_07.controller;

import ie.atu.week2lab.oop_inclass_07.model.Booking;
import ie.atu.week2lab.oop_inclass_07.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
        return ResponseEntity.status(201).body(bookingService.addBooking(booking));
    }
    @GetMapping("/allBookings")
    public ResponseEntity<List<Booking>> getAllBookings()
    {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

}
