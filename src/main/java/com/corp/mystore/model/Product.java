package com.corp.mystore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "product_name", length = 50, nullable = false)
    private String name;

    @Column(name = "product_description", length = 255)
    private String description;

    @Column(name = "product_photo")
    private String photo;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_stock", nullable = false)
    private Integer stock;

    @ManyToOne //relacao n:1 com department
    @JoinColumn(name = "product_department")  // nome da coluna nesta tabela. O nome da coluna desta tabela que eh FK eh diferente do nome da coluna PK da tabela departamento, portanto preciso explicitar
    @JsonIgnoreProperties("productList")
    private Department department;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
