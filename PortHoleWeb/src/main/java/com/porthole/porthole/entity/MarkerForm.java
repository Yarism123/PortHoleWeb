package com.porthole.porthole.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarkerForm {

    //위도(latitude)
    public double latitude;
    //경도(longitude)
    public double longitude;
}
