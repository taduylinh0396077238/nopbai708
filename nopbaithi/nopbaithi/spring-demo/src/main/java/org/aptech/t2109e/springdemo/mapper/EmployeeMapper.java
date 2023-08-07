package org.aptech.t2109e.springdemo.mapper;

import org.aptech.t2109e.springdemo.dto.EmployeeDto;
import org.aptech.t2109e.springdemo.dto.EmployeeDto;
import org.aptech.t2109e.springdemo.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Product DtoToEntity(EmployeeDto employeeDto);

    EmployeeDto EntityToDto(Product product);
}
