package br.com.alura.order.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceOrderKafkaApplication {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SpringApplication.run(ServiceOrderKafkaApplication.class, args);
	}

}
