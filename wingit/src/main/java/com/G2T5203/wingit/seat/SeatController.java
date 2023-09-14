package com.G2T5203.wingit.seat;

import com.G2T5203.wingit.entities.Seat;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {
    private final SeatService service;

    public SeatController(SeatService service) { this.service = service; }

    @GetMapping(path = "/seats")
    public List<Seat> getAllSeats() { return service.getAllSeats(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/seats/new")
    public Seat createSeat(@Valid @RequestBody Seat newSeat) {
        try {
            return service.createSeat(newSeat);
        } catch (Exception e) {
            throw new SeatBadRequestException(e);
        }
    }
}
