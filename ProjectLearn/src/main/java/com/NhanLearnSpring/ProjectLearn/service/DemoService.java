package com.NhanLearnSpring.ProjectLearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.NhanLearnSpring.ProjectLearn.repository.DemoRepository;

@Service
public class DemoService implements IDemoService {

    @Autowired
    private DemoRepository demoRepository;

    public String sayHello() {
        return demoRepository.sayHello();
    }
}
