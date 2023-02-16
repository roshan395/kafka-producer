package com.course.kafkaproducer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.kafkaproducer.entity.Employee;
import com.course.kafkaproducer.producer.EmployeeJsonProducer;

@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeJsonProducer producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//helloKafkaProducer.sendHello("roshan" + Math.random());
		/*for(int i=0; i<1000; i++) {
			var key = "key-"+(i%4);
			var data = "data " + i + " with key " + key;
			producer.send(key, data);
			
			Thread.sleep(500);*/
		for(int i=0; i<5; i++) {
			var employee = new Employee("emp-"+i, "Employee-"+i, i);
			producer.sendMessage(employee);
		}
	}

}
