package com.graphqlangularproject.graphql_angular_project.service;

<<<<<<< HEAD
=======
import com.graphqlangularproject.graphql_angular_project.dto.BrandDto;
import com.graphqlangularproject.graphql_angular_project.dto.ModelDto;
>>>>>>> 27d3b13 (commit sb)
import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.entity.Model;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.BrandRepository;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ModelRepository modelRepository;

    public List<Brand> findAllBrands(){
        return brandRepository.findAll();
    }

    public Brand findBrand(int id){
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("id does not exist"));
    }

<<<<<<< HEAD
    public Brand saveBrand(String name, Country country){
        Brand brand = Brand.builder().name(name).country(country).build();
        return brandRepository.save(brand);
    }

    public Model saveModel(int brand_id, String name){
        Brand brand = brandRepository.findById(brand_id).orElseThrow(()-> new RuntimeException("no id found"));

        return modelRepository.save(Model.builder().name(name).brand(brand).build());
    }

    public Brand updateBrand(int id, String name, Country country){
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        brand.setName(name);
        brand.setCountry(country);
=======
    public Brand saveBrand(BrandDto brandDto){
        Brand brand = Brand.builder().name(brandDto.getName()).country(brandDto.getCountry()).build();
        return brandRepository.save(brand);
    }

    public Model saveModel(ModelDto modelDto){
        Brand brand = brandRepository.findById(modelDto.getBrand_id()).orElseThrow(()-> new RuntimeException("no id found"));

        return modelRepository.save(Model.builder().name(modelDto.getName()).brand(brand).build());
    }

    public Brand updateBrand(int id, BrandDto brandDto){
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        brand.setName(brand.getName());
        brand.setCountry(brandDto.getCountry());
>>>>>>> 27d3b13 (commit sb)

        return brandRepository.save(brand);
    }

    public Brand deleteBrand(int id){
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        brandRepository.delete(brand);
        return brand;
    }

    @PostConstruct
    private void loadData(){
<<<<<<< HEAD
        saveBrand("Mercedes", Country.GER);
        saveBrand("BMW", Country.GER);
        saveBrand("Jaguar", Country.ENG);
        saveModel(1, "Clase S");
        saveModel(2, "Serie 5");
        saveModel(3, "F pace");
=======
        saveBrand(new BrandDto("Mercedes", Country.GER));
        saveBrand(new BrandDto("BMW", Country.GER));
        saveBrand(new BrandDto("Jaguar", Country.ENG));
        saveModel(new ModelDto(1, "Clase S"));
        saveModel(new ModelDto(2, "Serie 5"));
        saveModel(new ModelDto(3, "F Pace"));
>>>>>>> 27d3b13 (commit sb)
    }
}
