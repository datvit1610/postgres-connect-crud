package com.example.postgres.connect.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer idCategory;

    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    public Category(){

    }

    public  Category(Integer idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory){

        this.nameCategory = nameCategory;
    }

    public Integer getIdCategory() {
        return  idCategory;
    }
    public void setIdCategory(Integer idCategory) {

        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }
    public void setNameCategory(String nameCategory) {

        this.nameCategory = nameCategory;
    }
}
