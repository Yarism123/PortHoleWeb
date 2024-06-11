package com.porthole.porthole.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
public class PortPos {

    public PortPos(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id @GeneratedValue
    private Long id;

    //위도(latitude)
    public double latitude;
    //경도(longitude)
    public double longitude;
}
