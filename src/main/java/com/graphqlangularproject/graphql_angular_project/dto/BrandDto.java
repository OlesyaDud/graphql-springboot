package com.graphqlangularproject.graphql_angular_project.dto;

import com.graphqlangularproject.graphql_angular_project.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDto {

    private String name;
    private Country country;
}
