package org.aptech.t2109e.springdemo.service;

import org.aptech.t2109e.springdemo.dto.EmployeeDto;
import org.aptech.t2109e.springdemo.dto.PageDto;
import org.aptech.t2109e.springdemo.entity.Product;

public interface EmployeeService {
    PageDto<EmployeeDto> getAll(EmployeeDto criteria);

    EmployeeDto save(EmployeeDto employeeDto);

    EmployeeDto findByName(String employeeDto);
    EmployeeDto getById(Long id);

    Product createProduct(EmployeeDto employeeDto);

    Product updateProduct(Long id, EmployeeDto employeeDto);

    void deleteProduct(Long id);
    Product getProductById(Long id);
}






