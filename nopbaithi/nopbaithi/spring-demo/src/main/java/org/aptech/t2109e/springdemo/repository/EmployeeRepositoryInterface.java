package org.aptech.t2109e.springdemo.repository;


import org.aptech.t2109e.springdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositoryInterface extends JpaRepository<Product, Long>, JpaSpecificationExecutor {

    Optional<Product> findByName(@Param("name") String productName);

}
