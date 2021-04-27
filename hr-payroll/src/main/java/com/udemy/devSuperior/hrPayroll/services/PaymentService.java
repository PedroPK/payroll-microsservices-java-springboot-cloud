package com.udemy.devSuperior.hrPayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.devSuperior.hrPayroll.entities.Payment;
import com.udemy.devSuperior.hrPayroll.entities.WorkerDup;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(
		long 	pWorkerId,
		int		pDays
	) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", String.valueOf(pWorkerId));
		
		WorkerDup worker = restTemplate.getForObject(
			workerHost + "/workers/{id}", 
			WorkerDup.class,
			uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), pDays);
	}

}
