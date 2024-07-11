package com.graphqlangularproject.graphql_angular_project.service;

import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.entity.Model;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.BrandRepository;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    BrandRepository brandRepository;

    public List<Model> findAllModels(){
        return modelRepository.findAll();
    }

    public Model findModel(int id){
        return modelRepository.findById(id).orElseThrow(() -> new RuntimeException("id does not exist"));
    }

//    public Model saveModel(int brand_id, String name){
//        Brand brand = brandRepository.findById(brand_id).orElseThrow(()-> new RuntimeException("no id found"));
//
//        return modelRepository.save(Model.builder().name(name).brand(brand).build());
//    }


    public Model updateModel(int id, String name){
        Model  model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        model.setName(name);

        return modelRepository.save(model);
    }

    public Model deleteModel(int id){
        Model model = modelRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        modelRepository.delete(model);
        return model;
    }





}
