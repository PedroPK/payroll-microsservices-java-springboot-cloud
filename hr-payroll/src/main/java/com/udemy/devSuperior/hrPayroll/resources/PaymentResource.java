package com.udemy.devSuperior.hrPayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.devSuperior.hrPayroll.entities.Payment;
import com.udemy.devSuperior.hrPayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{pWorkerId}/days/{pDays}")
	public ResponseEntity<Payment> getPayment(
		@PathVariable Long		pWorkerId,
		@PathVariable Integer	pDays
	) {
		Payment payment = service.getPayment(pWorkerId, pDays);
		
		return ResponseEntity.ok(payment);
	}
	
	
}