package org.kau.mufiServer.domain.reservation.service;

import org.kau.mufiServer.domain.reservation.Reservation;
import org.kau.mufiServer.domain.reservation.dto.ReservationDto;
import org.kau.mufiServer.domain.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void registerReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setDate(reservationDto.getDate());
        reservation.setUserName(reservationDto.getUserName());
        reservation.setFesName(reservationDto.getFesName());
        reservation.setPhone(reservationDto.getPhone());
        reservation.setAddress(reservationDto.getAddress());
        reservation.setAdditionalAddress(reservationDto.getAdditionalAddress());
        reservation.setPhotobooth(reservationDto.getPhotobooth());

        reservationRepository.save(reservation);
    }
}


