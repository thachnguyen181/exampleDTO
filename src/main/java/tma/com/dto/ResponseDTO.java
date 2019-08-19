package tma.com.dto;

import java.util.List;

import tma.com.model.Customer;

public class ResponseDTO {

	private int Id;
	private String name;
	private List<Customer> customers;
	
	public ResponseDTO() {}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
