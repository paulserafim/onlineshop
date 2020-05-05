package com.online.shop.onlineshop.service.user;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.Employee;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.model.user.dto.EmployeeRequestDTO;
import com.online.shop.onlineshop.model.user.dto.EmployeeResponseDTO;
import com.online.shop.onlineshop.repository.user.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponseDTO save(EmployeeRequestDTO employeeRequestDTO) {
        Employee savedEmployee = (Employee) employeeRepository.save(new Employee(
                employeeRequestDTO.getFirstName(),
                employeeRequestDTO.getLastName(),
                employeeRequestDTO.getEmail(),
                employeeRequestDTO.getCity(),
                employeeRequestDTO.getCounty(),
                employeeRequestDTO.getCountry(),
                employeeRequestDTO.getStreet(),
                employeeRequestDTO.getHouseNumber(),
                employeeRequestDTO.getEncryptedPass(),
                employeeRequestDTO.getAge(),
                employeeRequestDTO.getPhoneNumber(),
                employeeRequestDTO.getRole()
        ));

        return new EmployeeResponseDTO(
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getCity(),
                savedEmployee.getCounty(),
                savedEmployee.getCountry(),
                savedEmployee.getStreet(),
                savedEmployee.getHouseNumber(),
                savedEmployee.getId(),
                savedEmployee.getAge(),
                savedEmployee.getPhoneNumber(),
                savedEmployee.getRole()
        );
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        return new EmployeeResponseDTO(
                employee.map(Employee::getFirstName).orElse(null),
                employee.map(Employee::getLastName).orElse(null),
                employee.map(Employee::getEmail).orElse(null),
                employee.map(Employee::getCity).orElse(null),
                employee.map(Employee::getCounty).orElse(null),
                employee.map(Employee::getCountry).orElse(null),
                employee.map(Employee::getStreet).orElse(null),
                employee.map(Employee::getHouseNumber).orElse(null),
                employee.map(Employee::getId).orElse(null),
                employee.map(Employee::getAge).orElse(null),
                employee.map(Employee::getPhoneNumber).orElse(null),
                employee.map(Employee::getRole).orElse(null)
        );
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        Iterable <Employee> employeeIterable = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList= new ArrayList<>();
        Iterator<Employee> employeeIterator = employeeIterable.iterator();
        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            employeeResponseDTOList.add(new EmployeeResponseDTO(
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getCity(),
                    employee.getCounty(),
                    employee.getCountry(),
                    employee.getStreet(),
                    employee.getHouseNumber(),
                    employee.getId(),
                    employee.getAge(),
                    employee.getPhoneNumber(),
                    employee.getRole()
            ));
        }
        return employeeResponseDTOList;
    }
}
