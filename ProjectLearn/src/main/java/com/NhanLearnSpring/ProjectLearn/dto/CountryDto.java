package com.NhanLearnSpring.ProjectLearn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto {
    private int id;

    private String name;

    public CountryDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}