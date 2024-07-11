package com.graphqlangularproject.graphql_angular_project.controller;

<<<<<<< HEAD
=======
import com.graphqlangularproject.graphql_angular_project.dto.BrandDto;
>>>>>>> 27d3b13 (commit sb)
import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import com.graphqlangularproject.graphql_angular_project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    ModelRepository modelRepository;


    @QueryMapping
    public List<Brand> findAllBrands(){
        return brandService.findAllBrands();
    }
//    query{
//        findAllBrands{
//            id,
//            name,
//            country
//        }
//    }

//
//    find a brand and it's models
//    # query{
//#   findAllBrands{
//#     id,
//#     name,
//#     country
//#     models {
//#       id
//#       name
//#     }
//#   }
//# }

<<<<<<< HEAD
=======

//    query{
//        findAllBrands{
//            id,
//                    name,
//                    models{
//                name
//            }
//        }
//    }

>>>>>>> 27d3b13 (commit sb)
    @QueryMapping
    public Brand findBrand(@Argument int id){
        return brandService.findBrand(id);
    }

    @MutationMapping
<<<<<<< HEAD
    public Brand saveBrand(@Argument String name, @Argument Country country){
        return brandService.saveBrand(name, country);
=======
    public Brand saveBrand(@Argument BrandDto brandDto){
        return brandService.saveBrand(brandDto);
>>>>>>> 27d3b13 (commit sb)
    }
//    mutation{
//        saveBrand(name: "Nissan", country: JAP){
//            id
//                    name
//            country
//        }
//    }

<<<<<<< HEAD
    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument String name, @Argument Country country){
        return brandService.updateBrand(id, name, country);
=======

//    mutation{
//        saveBrand(brandDto: {
//            name: "Seat",
//                    country: ES
//        }){
//            id
//                    name
//            country
//        }
//    }

    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument BrandDto brandDto){
        return brandService.updateBrand(id, brandDto);
>>>>>>> 27d3b13 (commit sb)
    }
//    mutation{
//        updateBrand(id: 2, name: "bmw", country: GER){
//            id
//                    name
//            country
//        }
//    }

    @MutationMapping
    public Brand deleteBrand(@Argument int id){
        return brandService.deleteBrand(id);
    }
//    mutation{
//        deleteBrand(id: 2){
//            id
//        }
//    }
}
