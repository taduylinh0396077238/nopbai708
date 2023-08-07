package org.aptech.t2109e.springdemo.service.impl;

import org.aptech.t2109e.springdemo.dto.EmployeeDto;
import org.aptech.t2109e.springdemo.dto.PageDto;
import org.aptech.t2109e.springdemo.entity.Product;
import org.aptech.t2109e.springdemo.mapper.EmployeeMapper;
import org.aptech.t2109e.springdemo.repository.EmployeeRepositoryInterface;
import org.aptech.t2109e.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class EmployeeServiceImplement implements EmployeeService {
    @Autowired
    private EmployeeRepositoryInterface employeeRepositoryInterface;
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public PageDto<EmployeeDto> getAll(EmployeeDto criteria) {
        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPageSize());
        Page<Product> products = employeeRepositoryInterface.findAll(pageable);
        List<EmployeeDto> productDtos = products.getContent()
                .stream()
                .map(mapper::EntityToDto)
                .collect(Collectors.toList());

        PageDto<EmployeeDto> pageDto = new PageDto<>();
        pageDto.setPageSize(products.getSize());
        pageDto.setPageNumber(products.getNumber());
        pageDto.setTotalPages(products.getTotalPages());
        pageDto.setContent(productDtos);

        return pageDto;
    }
    @Override
    public EmployeeDto getById(Long id){
        // todo validate
        return mapper.EntityToDto(employeeRepositoryInterface.getById(id));
    }

    @Override
    public EmployeeDto save(EmployeeDto productDto){
        Product product = mapper.DtoToEntity(productDto);
        if (Objects.isNull(product)){
            return null;
        }else {
            Product returnEntity = employeeRepositoryInterface.save(product);
            return mapper.EntityToDto(returnEntity);
        }

    }


    @Override
    public EmployeeDto findByName(String productName){
        Optional<Product> p = employeeRepositoryInterface.findByName(productName);

        return p.isPresent() ? mapper.EntityToDto(p.get()) : null;
    }


    @Override
    public Product createProduct(EmployeeDto employeeDto) {
        Product product = mapper.DtoToEntity(employeeDto);
        return employeeRepositoryInterface.save(product);
    }
    @Override
    public Product updateProduct(Long id, EmployeeDto employeeDto) {
        Product existingProduct = employeeRepositoryInterface.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Product product = mapper.DtoToEntity(employeeDto);

        return employeeRepositoryInterface.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        employeeRepositoryInterface.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return employeeRepositoryInterface.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}
