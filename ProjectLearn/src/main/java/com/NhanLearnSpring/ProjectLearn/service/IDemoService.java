package com.NhanLearnSpring.ProjectLearn.service;

import com.NhanLearnSpring.ProjectLearn.dto.CountryDto;
import com.NhanLearnSpring.ProjectLearn.dto.CountryNameDto;

import java.util.List;

public interface IDemoService {
    public String sayHello();

    public List<CountryDto> viewAllCountries();
    public List<CountryNameDto> viewAllNameCountries();
    public CountryNameDto viewNameCountriesById(int id);

    int addCountry(CountryDto country);
    int updateCountry(CountryDto country);
    int delCountry(int id);
}
