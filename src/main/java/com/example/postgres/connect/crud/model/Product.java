package com.example.postgres.connect.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    public Product() {

    }

    public Product(Integer idProduct, String nameProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
    }

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;

    }


    public Integer getIdProduct() {

        return idProduct;
    }
    public void setIdProduct(Integer idProduct) {

        this.idProduct = idProduct;
    }


    public String getNameProduct() {

        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {

        this.nameProduct = nameProduct;
    }

//    @Override
//    public  String toString() {
//        return "Product [idProduct = " + idProduct + ", nameProduct = "+ nameProduct + "]";
//    }
}
