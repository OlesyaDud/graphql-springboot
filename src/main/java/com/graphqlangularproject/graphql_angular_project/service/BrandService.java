package com.graphqlangularproject.graphql_angular_project.service;

import com.graphqlangularproject.graphql_angular_project.dto.BrandDto;
import com.graphqlangularproject.graphql_angular_project.dto.ModelDto;
import com.graphqlangularproject.graphql_angular_project.entity.Brand;
import com.graphqlangularproject.graphql_angular_project.entity.Model;
import com.graphqlangularproject.graphql_angular_project.enums.Country;
import com.graphqlangularproject.graphql_angular_project.repository.BrandRepository;
import com.graphqlangularproject.graphql_angular_project.repository.ModelRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

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

    public Brand saveBrand(BrandDto brandDto){
        Optional<Brand> brandOptional = brandRepository.findByName(brandDto.getName());
        if(brandOptional.isPresent()) throw new RuntimeException("name already in use");
        Brand brand = Brand.builder().name(brandDto.getName()).country(brandDto.getCountry()).build();
        return brandRepository.save(brand);
    }

    public Model saveModel(ModelDto modelDto){
        Optional<Model> modelOptional = modelRepository.findByName(modelDto.getName());
        if(modelOptional.isPresent()) throw new RuntimeException("model name is already in use");
        Brand brand = brandRepository.findById(modelDto.getBrand_id()).orElseThrow(()-> new RuntimeException("no id found"));

        return modelRepository.save(Model.builder().name(modelDto.getName()).brand(brand).build());
    }

    public Brand updateBrand(int id, BrandDto brandDto) {
        log.info("Attempting to update brand with id: {}", id);

        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found"));
        log.info("Brand found: {}", brand);

        Optional<Brand> brandOptional = brandRepository.findByName(brandDto.getName());
        log.info("Checking if name '{}' is already in use by another brand", brandDto.getName());
        log.info("Result of findByName: {}", brandOptional);

        if (brandOptional.isPresent()) {
            Brand existingBrand = brandOptional.get();
            log.info("Existing brand found with id: {}, name: {}", existingBrand.getId(), existingBrand.getName());
            if (existingBrand.getId() != id) {
                log.error("Brand name '{}' already in use by another brand with id: {}", brandDto.getName(), existingBrand.getId());
                throw new RuntimeException("name already in use");
            }
        }

        brand.setName(brandDto.getName());
        brand.setCountry(brandDto.getCountry());
        log.info("Updated brand details: {}", brand);

        return brandRepository.save(brand);
    }

//    throw exception if id is trying to update brand name which is used by other id/brand
//mutation{
//    updateBrand(id: 1, brandDto: {
//        name: "BMW", country: GER
//    }){
//        id
//    }
//}

    public Brand deleteBrand(int id){
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        brandRepository.delete(brand);
        return brand;
    }

    public Flux<Brand> findAllBrandsFlux() {
        return Flux.fromIterable(findAllBrands())
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }
    public Mono<Brand> findBrandMono(int id) {
        return Mono.justOrEmpty(brandRepository.findById(id))
                .switchIfEmpty(Mono.error(new RuntimeException("brand not found")));
    }

//    throws brand not found
//subscription{
//    findBrandMono(id: 10){
//        name
//    }
//}

    @PostConstruct
    private void loadData(){
        saveBrand(new BrandDto("Mercedes", Country.GER));
        saveBrand(new BrandDto("BMW", Country.GER));
        saveBrand(new BrandDto("Jaguar", Country.ENG));
        saveModel(new ModelDto(1, "Clase S"));
        saveModel(new ModelDto(2, "Serie 5"));
        saveModel(new ModelDto(3, "F Pace"));
    }
}
