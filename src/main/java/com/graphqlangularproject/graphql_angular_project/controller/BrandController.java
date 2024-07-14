package com.graphqlangularproject.graphql_angular_project.controller;

import com.graphqlangularproject.graphql_angular_project.dto.BrandDto;
import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import com.graphqlangularproject.graphql_angular_project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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


//    query{
//        findAllBrands{
//            id,
//                    name,
//                    models{
//                name
//            }
//        }
//    }

    @SubscriptionMapping
    public Flux<Brand> findAllBrandsFlux(){
        return brandService.findAllBrandsFlux();
    }
//    subscription{
//        findAllBrandsFlux{
//            id
//                    name
//        }
//    }

//    subscription{
//        findAllBrandsFlux{
//            name
//            models{
//                id
//                        name
//            }
//        }
//    }


    @QueryMapping
    public Brand findBrand(@Argument int id){
        return brandService.findBrand(id);
    }

    @SubscriptionMapping
    public Mono<Brand> findBrandMono(@Argument int id){
        return brandService.findBrandMono(id);
    }

//    subscription{
//        findBrandMono(id: 1){
//            name
//        }
//    }

    @MutationMapping
    public Brand saveBrand(@Argument BrandDto brandDto){
        return brandService.saveBrand(brandDto);
    }
//    mutation{
//        saveBrand(name: "Nissan", country: JAP){
//            id
//                    name
//            country
//        }
//    }


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


//Exception handling
//    query{
//        findBrand(id: 50){
//            name
//        }
//    }
//
//    {
//            "errors": [
//            {
//            "message": "id does not exist"
//            }
//            ],
//            "data": {
//            "findBrand": null
//            }
//            }