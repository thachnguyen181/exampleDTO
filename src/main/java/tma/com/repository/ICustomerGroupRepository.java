package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tma.com.model.CustomerGroup;

public interface ICustomerGroupRepository extends JpaRepository<CustomerGroup, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT cg FROM customer_group cg WHERE cg.name = :name")
	public CustomerGroup findByName(@Param("name") String name);
}