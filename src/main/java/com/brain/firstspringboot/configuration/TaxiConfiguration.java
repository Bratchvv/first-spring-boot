package com.brain.firstspringboot.configuration;

import com.brain.firstspringboot.model.Taxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaxiConfiguration {

    @Bean
    public List<Taxi> taxiList(){
        List<Taxi> list = new ArrayList<>();
        list.add(new Taxi("Toyota", "1122", "Zhorik", DayOfWeek.MONDAY, true));
        list.add(new Taxi("Mazda", "0992", "Rafik", DayOfWeek.FRIDAY, true));
        list.add(new Taxi("Geeley", "1299", "Igor", DayOfWeek.WEDNESDAY, true));
        return list;
    }
}
