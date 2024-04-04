package br.edu.uniara.lpi2.rest.controller;

import br.edu.uniara.lpi2.rest.model.Employee;
import br.edu.uniara.lpi2.rest.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Erro pesquisando o id: " + id));
    }
}
