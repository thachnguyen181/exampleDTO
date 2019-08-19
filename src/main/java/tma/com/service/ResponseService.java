package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.ResponseDTO;
import tma.com.model.Customer;
import tma.com.model.CustomerGroup;
import tma.com.repository.ICustomerGroupRepository;
import tma.com.repository.ICustomerRepository;

@Service
public class ResponseService implements IResponseService{

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private ICustomerGroupRepository customerGroupRepository;
	
	private CustomerGroup customerGroup;
	private Customer customer;
	
	public ResponseDTO save(ResponseDTO responseDto) {
		// TODO Auto-generated method stub
		
		if (responseDto != null) {
			if (customerGroupRepository.findByName(responseDto.getName()) == null) {
				customerGroup = new CustomerGroup(responseDto.getName());
				customerGroupRepository.save(customerGroup);
			} else {
				customerGroup = customerGroupRepository.findByName(responseDto.getName());
			}
			if (responseDto.getCustomers() != null) {
				for (Customer cus : responseDto.getCustomers()) {
					if (customerRepository.findByName(cus.getName()) == null) {
						customer = new Customer();
						customer.setName(cus.getName());
						customer.setAddress(cus.getAddress());
						customer.setCustomerGroup(customerGroup);
						customerRepository.save(customer);
					}
				}
			} else {
				return responseDto;
			}
		} else {
			return responseDto;
		}
		return responseDto;
	}
	
}
