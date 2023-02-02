package com.NhanLearnSpring.ProjectLearn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryNameDto {

    private String name;

    public CountryNameDto(String name) {
        this.name = name;
    }
}
