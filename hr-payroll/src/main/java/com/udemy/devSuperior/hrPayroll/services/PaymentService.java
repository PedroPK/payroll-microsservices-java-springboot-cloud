package com.udemy.devSuperior.hrPayroll.services;

import org.springframework.stereotype.Service;

import com.udemy.devSuperior.hrPayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(
		long 	pWorkerId,
		int		pDays
	) {
		return new Payment("Bob", 200.0, pDays);
	}

}
