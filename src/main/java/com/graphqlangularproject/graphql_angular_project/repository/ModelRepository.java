package com.graphqlangularproject.graphql_angular_project.repository;

import com.graphqlangularproject.graphql_angular_project.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    Optional<Model> findByName(String name);
    @Query("SELECT m FROM Model m WHERE m.brand.id = :brand_id")
    List<Model> findModelsByBrandId(int brand_id);
}
