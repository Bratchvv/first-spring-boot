package com.brain.firstspringboot.component;

import com.brain.firstspringboot.service.TaxiCaller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class Person {

    private final TaxiCaller taxiCaller;

    @Value("${conf.person.name}")
    private String name;

    @Value("${conf.person.phone}")
    private String phone;

    public void callTaxi() {
        taxiCaller.call(name);
    }
}
