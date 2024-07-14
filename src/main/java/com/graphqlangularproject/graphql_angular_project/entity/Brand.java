package com.graphqlangularproject.graphql_angular_project.entity;

import com.graphqlangularproject.graphql_angular_project.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    List<Model> models;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
