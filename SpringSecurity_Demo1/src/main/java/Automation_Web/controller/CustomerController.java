package Automation_Web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Automation_Web.model.CustomerModel;

@RestController
@EnableMethodSecurity
public class CustomerController {

	final private List<Automation_Web.model.CustomerModel> customers = List
		    .of(
		        CustomerModel.builder().id("001").name("Nguyen Minh Trung").email("minhtrung@gmail.com").build(),
		        CustomerModel.builder().id("002").name("Trung Nguyen Minh").email("trung@gmail.com").build()
		    );

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello is Guest");
	}

	@GetMapping("/customer/all")
	@PreAuthorize("hasAuthority( 'ROLE_ADMIN')")
	public ResponseEntity<List<CustomerModel>> getCustomerList() {
		List<CustomerModel> list = this.customers;
		return ResponseEntity.ok(list);
	}

	@GetMapping("/customer/{id}")
	@PreAuthorize("hasAuthority( 'ROLE_USER' ) ")
	public ResponseEntity<CustomerModel> getCustomerList(@PathVariable("id") String id) {
		List<CustomerModel> customers = this.customers.stream().filter(customer -> customer.getId().equals(id))
				.toList();
		return ResponseEntity.ok(customers.get(0));
	}
}
