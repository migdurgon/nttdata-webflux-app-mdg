/**
 * 
 */
package com.nttdata.webflux.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.webflux.models.Person;

import reactor.core.publisher.Flux;

/**
 * @author DURAN
 *
 */
@Service
public class PersonService {

	public Flux<Person> allPersons() {
		Flux<Person> p1 = WebClient.create("http://localhost:8080/person-list-1").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> p2 = WebClient.create("http://localhost:8080/person-list-2").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> p3 = WebClient.create("http://localhost:8080/person-list-3").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> p4 = WebClient.create("http://localhost:8080/person-list-4").get().retrieve().bodyToFlux(Person.class);
		Flux<Person> p = Flux.merge(p1, p2, p3, p4);
		return p;
	}
}
