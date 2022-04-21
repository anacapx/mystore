package com.corp.mystore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDate date;

    @Column(name = "total_before_discount", nullable = false)
    private Double totalBeforeDiscount;

    @Column(name = "discount", nullable = false)
    private Double discount;

    @Column(name = "total_after_discount", nullable = false)
    private Double totalAfterDiscount;

    @ManyToOne
    @JoinColumn(name = "customer_id") //nome da coluna desta tabela que vai conectar a outra
    @JsonIgnoreProperties("orderList") //nome do atributo da outra classe que deve ser ignorado para nao dar loop
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //nome do atributo da classe na outra ponta do relacionamento. Cascade = o que acontecer com o pai afeta os filhos
    @JsonIgnoreProperties("order") //nome do atributo da outra classe que deve ser ignorado para nao dar loop
    private List<Item> itemsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalBeforeDiscount() {
        return totalBeforeDiscount;
    }

    public void setTotalBeforeDiscount(Double totalBeforeDiscount) {
        this.totalBeforeDiscount = totalBeforeDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getTotalAfterDiscount() {
        return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(Double totalAfterDiscount) {
        this.totalAfterDiscount = totalAfterDiscount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }
}
