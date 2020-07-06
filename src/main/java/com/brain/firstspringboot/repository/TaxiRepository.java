package com.brain.firstspringboot.repository;

import com.brain.firstspringboot.model.Taxi;
import com.brain.firstspringboot.service.TaxiCaller;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter
public class TaxiRepository {

    private final List<Taxi> taxiList;

    public Taxi getFreeTaxi() {
        DayOfWeek today =  LocalDate.now().getDayOfWeek();
        return taxiList.stream()
                .filter(t -> !t.getRestDay().equals(today))
                .filter(Taxi::isFree)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдено ни одного такси"));
    }

    public Taxi createOrder(Taxi taxi) {
        if(!taxi.isFree()){
            throw new RuntimeException("Такси уже віехало на другой заказ");
        }
        taxi.setFree(false);
        return taxi;
    }
}
