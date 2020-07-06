package com.brain.firstspringboot.service;

import com.brain.firstspringboot.model.Taxi;
import com.brain.firstspringboot.repository.TaxiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaxiCaller {

    private final TaxiRepository taxiRepository;

    public void call(String person) {
        try {
            log.info("Вызываем такси для {}", person);
            Taxi taxi = taxiRepository.getFreeTaxi();
            taxiRepository.createOrder(taxi);
            log.info("Вызвано такси {} для {}", taxi, person);
        } catch (Exception e) {
            log.error("Не удалось найти такси для {}", person);
        }
    }
}
