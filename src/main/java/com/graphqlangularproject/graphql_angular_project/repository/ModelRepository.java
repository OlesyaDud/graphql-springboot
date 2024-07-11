package com.graphqlangularproject.graphql_angular_project.repository;

import com.graphqlangularproject.graphql_angular_project.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
