package com.empoyees.webapp.repository;

import com.empoyees.webapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Component
public class EmployeeProxy {
    @Autowired
    private CustomProperties props;

    public Iterable<Employee> getEmployees() {
        String url = props.getApiUrl() + "/employees";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {}
        );
        return response.getBody();
    }

    public Employee getEmployee(Long id) {
        String url = props.getApiUrl() + "/employees/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.GET, null, Employee.class);
        return response.getBody();
    }

    public Employee createEmployee(Employee employee) {
        String url = props.getApiUrl() + "/employees";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.POST, request, Employee.class);
        return response.getBody();
    }

    public Employee updateEmployee(Employee employee) {
        String url = props.getApiUrl() + "/employees/" + employee.getId();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(url, HttpMethod.PUT, request, Employee.class);
        return response.getBody();
    }

    public void deleteEmployee(Long id) {
        String url = props.getApiUrl() + "/employees/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
    }
}
