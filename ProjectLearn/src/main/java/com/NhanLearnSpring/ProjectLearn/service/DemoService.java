package com.NhanLearnSpring.ProjectLearn.service;

import com.NhanLearnSpring.ProjectLearn.dto.CountryDto;
import com.NhanLearnSpring.ProjectLearn.dto.CountryNameDto;
import com.NhanLearnSpring.ProjectLearn.repository.MyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NhanLearnSpring.ProjectLearn.repository.DemoRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService implements IDemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Resource
    private MyBatisRepository myBatisRepository;

    public String sayHello() {
        return demoRepository.sayHello();
    }

    @Override
    public List<CountryDto> viewAllCountries() {
//        return demoRepository.getAllCountry();
        return myBatisRepository.getAllCountry();
    }

    @Override
    public List<CountryNameDto> viewAllNameCountries() {
        return demoRepository.getAllNameCountry();
    }

    @Override
    public CountryNameDto viewNameCountriesById(int id) {
        return myBatisRepository.getNameCountryByID(id);
    }

    @Override
    public int addCountry(CountryDto country) {
        return myBatisRepository.addCountry(country);
    }

    @Override
    public int updateCountry(CountryDto country) {
        return myBatisRepository.updateCountry(country);
    }

    @Override
    public int delCountry(int id) {
        return myBatisRepository.delCountry(id);
    }
}
