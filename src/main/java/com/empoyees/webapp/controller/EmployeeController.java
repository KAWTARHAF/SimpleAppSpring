package com.empoyees.webapp.controller;
import com.empoyees.webapp.model.Employee;
import com.empoyees.webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Employee> employees = service.getEmployees();
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "formUpdateEmployee";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") final Long id, Model model) {
        Employee employee = service.getEmployee(Math.toIntExact(id));
        model.addAttribute("employee", employee);
        return "formUpdateEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final Long id) {
        service.deleteEmployee(Math.toIntExact(id));
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        service.saveEmployee(employee);
        return new ModelAndView("redirect:/");
    }
}
