package com.graphqlangularproject.graphql_angular_project.repository;

import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
