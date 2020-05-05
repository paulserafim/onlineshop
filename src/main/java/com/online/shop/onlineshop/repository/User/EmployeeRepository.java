package com.online.shop.onlineshop.repository.user;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.Employee;
import com.online.shop.onlineshop.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> getEmployeeByFirstName(String firstName);
    List<Employee> getEmployeeByLastName(String lastName);
    Employee getEmployeeById(Long id);
}
