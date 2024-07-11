package com.graphqlangularproject.graphql_angular_project.controller;

<<<<<<< HEAD
=======
import com.graphqlangularproject.graphql_angular_project.dto.ModelDto;
>>>>>>> 27d3b13 (commit sb)
import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.entity.Model;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.BrandRepository;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import com.graphqlangularproject.graphql_angular_project.service.BrandService;
import com.graphqlangularproject.graphql_angular_project.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ModelController {


    @Autowired
    ModelService modelService;

    @Autowired
    BrandService brandService;


    @QueryMapping
    public List<Model> findAllModels(){
        return modelService.findAllModels();
    }


    @QueryMapping
    public Model findModel(@Argument int id){
        return modelService.findModel(id);
    }

    @MutationMapping
<<<<<<< HEAD
    public Model saveModel(@Argument int brand_id, @Argument String name){
        return brandService.saveModel(brand_id, name);
=======
    public Model saveModel(@Argument ModelDto modelDto){
        return brandService.saveModel(modelDto);
>>>>>>> 27d3b13 (commit sb)
    }
//    mutation {
//#   saveModel(brand_id: 1, name: "Clase E"){
//#     id
//#     name
//#   }
//# }

<<<<<<< HEAD
=======
//    mutation {
//        saveModel(modelDto: {
//            brand_id: 7
//            name: "Leon"
//        }){
//            id
//                    name
//        }
//    }
>>>>>>> 27d3b13 (commit sb)

    @MutationMapping
    public Model updateModel(@Argument int id, @Argument String name){
        return modelService.updateModel(id, name);
    }

    @MutationMapping
    public Model deleteModel(@Argument int id){
        return modelService.deleteModel(id);
    }
//    mutation{
//        deleteModel(id: 1){
//            id
//        }
//    }
}
