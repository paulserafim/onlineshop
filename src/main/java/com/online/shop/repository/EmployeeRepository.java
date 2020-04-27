package com.online.shop.repository;

import com.online.shop.model.User.Employee;
import com.online.shop.model.User.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeRepository implements UserRepository {

    private HashMap<String, User> employeeHashMap = new HashMap<>();

    @Override
    public void addUserToRepo(String id, User employee) {
        employeeHashMap.put(id, employee);
    }

    public HashMap<String, User> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public void setEmployeeHashMap(HashMap<String, User> employeeHashMap) {
        this.employeeHashMap = employeeHashMap;
    }
}
