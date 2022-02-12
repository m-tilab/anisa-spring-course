package com.example.reactivestreams;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

@Slf4j
class ReactiveExampleTests {

    Person ali = new Person("Ali", "Ahmadi");
    Person mehdi = new Person("Mehdi", "Tilab");
    Person taghi = new Person("Taghi", "Alizadeh");
    Person zahra = new Person("zahra", "mousavi");

    @Test
    public void monoTests() throws Exception {
        //create new person mono
        Mono<Person> personMono = Mono.just(ali);

        //get person object from mono publisher
        Person person = personMono.block();

        // output name
        log.info(person.toString());
    }

    @Test
    public void monoTransform() throws Exception {
        //create new person mono
        Mono<Person> personMono = Mono.just(zahra);

        PersonCommand command = personMono
                .map(person -> { //type transformation
                    return new PersonCommand(person);
                }).block();

        log.info(command.sayMyName());
    }

    @Test
    public void monoFilter() throws Exception {

        Assertions.assertThrows(NullPointerException.class, () -> {

            Mono<Person> personMono = Mono.just(ali);

            //filter example
            Person samAxe = personMono
                    .filter(person -> person.getFirstName().equalsIgnoreCase("foo"))
                    .block();


            log.info(samAxe.sayMyName()); //throws NPE
        });
    }

    @Test
    public void fluxTest() throws Exception {

        Flux<Person> people = Flux.just(ali, mehdi, taghi, zahra);

        people.subscribe(person -> log.info(person.sayMyName()));

    }

    @Test
    public void fluxTestFilter() throws Exception {

        Flux<Person> people = Flux.just(ali, mehdi, taghi, zahra);

        people.filter(person -> person.getFirstName().equals(mehdi.getFirstName()))
                .subscribe(person -> log.info(person.sayMyName()));

    }

    @Test
    public void fluxTestDelayNoOutput() throws Exception {

        System.out.println(System.currentTimeMillis());

        Flux<Person> people = Flux.just(ali, mehdi, taghi, zahra);

        people.delayElements(Duration.ofSeconds(1))
                .subscribe(person -> log.info(person.sayMyName()));

        System.out.println(System.currentTimeMillis());

        Thread.sleep(10000);

    }

    @Test
    public void fluxTestDelay() throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Flux<Person> people = Flux.just(ali, mehdi, taghi, zahra);

        people.delayElements(Duration.ofSeconds(1))
                .doOnComplete(countDownLatch::countDown)
                .subscribe(person -> log.info(person.sayMyName()));



        countDownLatch.await();

        System.out.println("finished");
    }

    @Test
    public void fluxTestFilterDelay() throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Flux<Person> people = Flux.just(ali, mehdi, taghi, zahra);

        people.delayElements(Duration.ofSeconds(1))
                .filter(person -> person.getFirstName().contains("i"))
                .doOnComplete(countDownLatch::countDown)
                .subscribe(person -> log.info(person.sayMyName()));

        countDownLatch.await();
    }


}
