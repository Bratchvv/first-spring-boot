package com.brain.firstspringboot;

import com.brain.firstspringboot.component.Person;
import com.brain.firstspringboot.model.Taxi;
import com.brain.firstspringboot.repository.TaxiRepository;
import com.brain.firstspringboot.service.TaxiCaller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.DayOfWeek;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class FirstSpringBootApplication {

	private final TaxiCaller taxiCaller;
	private final TaxiRepository taxiRepository;
	private final Person person;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);
		log.warn("{} Вот тут ничего не пишем {}, {}","START", 1000, true);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onRun() {
		log.info("Приложение запущено");
		taxiCaller.call("Вася");
		taxiCaller.call("Коля");

		taxiCaller.call("Оля");

		taxiRepository.getTaxiList().add(new Taxi("Audi R8", "0000", "Kris", DayOfWeek.WEDNESDAY, true));

		person.callTaxi();
	}

}
