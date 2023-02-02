package com.NhanLearnSpring.ProjectLearn.repository;

import com.NhanLearnSpring.ProjectLearn.dto.CountryDto;
import com.NhanLearnSpring.ProjectLearn.dto.CountryNameDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String sayHello() {
        int total = jdbcTemplate
                .queryForObject("select count(*) as T from COUNTRIES", Integer.class);
        return "Hello World, everything is awesome! \n Total row is " + Integer.toString(total);
    }

    public List<CountryDto> getAllCountry() {
        List<CountryDto> total = jdbcTemplate
                .query("select * from COUNTRIES",
                        (res, row) ->
                                new CountryDto(
                                        res.getInt("id"),
                                        res.getString("name")
                                )
                );
        return total;
    }

    public List<CountryNameDto> getAllNameCountry() {
        List<CountryNameDto> total = jdbcTemplate
                .query("select name from COUNTRIES",
                        (res, row) ->
                                new CountryNameDto(
                                        res.getString("name")
                                )
                );
        return total;
    }
}
