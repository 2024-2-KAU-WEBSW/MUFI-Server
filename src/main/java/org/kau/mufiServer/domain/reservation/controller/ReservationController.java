package org.kau.mufiServer.domain.reservation.controller;

import org.kau.mufiServer.domain.reservation.dto.ReservationDto;
import org.kau.mufiServer.domain.reservation.service.ReservationService;
import org.kau.mufiServer.global.common.dto.ApiResponse;
import org.kau.mufiServer.global.common.dto.enums.SuccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.registerReservation(reservationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(SuccessType.PROCESS_CREATED));
    }
}
