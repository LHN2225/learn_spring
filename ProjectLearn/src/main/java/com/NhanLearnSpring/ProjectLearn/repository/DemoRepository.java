package com.NhanLearnSpring.ProjectLearn.repository;

import org.springframework.stereotype.Repository;
@Repository
public class DemoRepository {

    public String sayHello() {
        return "Hello World, everything is awesome!";
    }
}
