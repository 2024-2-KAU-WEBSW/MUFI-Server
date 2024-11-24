package org.kau.mufiServer.domain.reservation.dto;

import lombok.Data;

@Data
public class ReservationDto {
    private String date;
    private String userName;
    private String fesName;
    private String phone;
    private String address;
    private String additionalAddress;
    private Integer photobooth;
}