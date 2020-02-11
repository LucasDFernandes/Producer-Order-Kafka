package br.com.alura.order.kafka.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.order.kafka.domain.Order;
import br.com.alura.order.kafka.dto.OrderDTO;
import br.com.alura.order.kafka.lib.KafkaDispatcher;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final String TOPIC_NAME_NEW_ORDER_SERVICE = "ECOMMERCE_ORDER_APPROVED";
	private static final String TOPIC_NAME_EMAIL_SERVICE = "ECOMMERCE_SEND_EMAIL";
	private static final String BODY = "thank you, we are processing you order!";

	@PostMapping
	public ResponseEntity<?> publicarOrdem(@RequestBody @Valid OrderDTO orderDTO) {
		try (KafkaDispatcher<Order> disptacherOrder = new KafkaDispatcher<Order>()) {
			try (KafkaDispatcher<String> disptacherEmail = new KafkaDispatcher<String>()) {
				for (Order order : orderDTO.getListaOrders()) {
					try {
						String userId = UUID.randomUUID().toString();
						
						disptacherOrder.send(TOPIC_NAME_NEW_ORDER_SERVICE, userId, order);
						disptacherEmail.send(TOPIC_NAME_EMAIL_SERVICE, userId, BODY);
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}

				return ResponseEntity.ok().build();
			}
		}
	}

}
