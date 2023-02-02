package com.NhanLearnSpring.ProjectLearn.controller;

import com.NhanLearnSpring.ProjectLearn.dto.CountryDto;
import com.NhanLearnSpring.ProjectLearn.dto.CountryNameDto;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.NhanLearnSpring.ProjectLearn.service.IDemoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonTypeName("NhanObject")
@Getter
@Setter
class Nhan {

    @JsonAlias("name2")
    @NotNull
    private String name;

    private String ids;
}

@Controller
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("say")
    public String sayHelloWorld(final ModelMap model) {
        String data = demoService.sayHello();
        model.addAttribute("data", data);

        return "hello_world";
    }

    @PostMapping("say/{id}")
    @ResponseBody
    public String postHelloWorld(@PathVariable(name = "id") int id, @RequestBody Nhan nhan) {
        String data = demoService.sayHello();

        return nhan.getIds();
    }

    @PutMapping("say")
    @ResponseBody
    public String putHelloWorld(final ModelMap model) {
        String data = demoService.sayHello();

        return "put" + data;
    }

    @DeleteMapping("say")
    @ResponseBody
    public String delHelloWorld(final ModelMap model) {
        String data = demoService.sayHello();

        return "Delete : " + data;
    }

    @GetMapping("all_countries")
    @ResponseBody
    public Map<String, Object> viewAllCountries() {
        List<CountryDto> data = demoService.viewAllCountries();

        Map<String, Object> map = new HashMap<>();
        map.put("country_list_full", data);

        return map;
    }

    @GetMapping("all_name_countries")
    @ResponseBody
    public Map<String, Object> viewAllNameCountries() {
        List<CountryNameDto> data = demoService.viewAllNameCountries();

        Map<String, Object> map = new HashMap<>();
        map.put("country_name_list", data);

        return map;
    }

    @GetMapping("name_country/{id}")
    @ResponseBody
    public Map<String, Object> getNameCountryByID(@PathVariable(name = "id") int id) {
        CountryNameDto data = demoService.viewNameCountriesById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("country_name_list", data);

        return map;
    }

    @PostMapping("add_country")
    @ResponseBody
    public Map<String, Object> addCountry(@RequestBody CountryDto country) {
        int data = demoService.addCountry(country);

        Map<String, Object> map = new HashMap<>();
        map.put("Row affected", data);

        return map;
    }

    @PutMapping("update_country")
    @ResponseBody
    public Map<String, Object> updateCountry(@RequestBody CountryDto country) {
        int data = demoService.updateCountry(country);

        Map<String, Object> map = new HashMap<>();
        map.put("Row affected", data);

        return map;
    }

    @DeleteMapping("del_country/{id}")
    @ResponseBody
    public Map<String, Object> addCountry(@PathVariable(name = "id") int id) {
        int data = demoService.delCountry(id);

        Map<String, Object> map = new HashMap<>();
        map.put("Row affected", data);

        return map;
    }
}
