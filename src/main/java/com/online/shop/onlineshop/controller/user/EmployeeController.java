package com.online.shop.onlineshop.controller.user;

import com.online.shop.onlineshop.model.user.Employee;
import com.online.shop.onlineshop.model.user.dto.EmployeeRequestDTO;
import com.online.shop.onlineshop.model.user.dto.EmployeeResponseDTO;
import com.online.shop.onlineshop.service.user.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO savedEmployee = employeeService.save(employeeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable Long id) {
        EmployeeResponseDTO employeeToGet = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeToGet);
    }

    @GetMapping
    public ResponseEntity getAllEmployees() {
        List<EmployeeResponseDTO> employeeResponseDTOList = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDTOList);
    }
}
