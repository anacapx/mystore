package com.corp.mystore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // indica que a classe eh mapeada para uma tabela
@Table(name = "tb_customer")  // nome da tabela no banco de dados
public class Customer {

    @Id  // atributo é uma PK
    @Column(name = "customer_id")  // mapeia o atributo "id" para a coluna "customer_id" na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // indica que o valor eh gerado e gerenciado pelo BD
    private Long id;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String name;

    @Column(name = "customer_email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "customer_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "customer_dob")
    private LocalDate dob;

    @Column(name = "customer_cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "customer_num_res", length = 10, nullable = false)
    private String numRes;

    @Column(name = "customer_complement", length = 50)
    private String complement;

    @OneToMany(mappedBy = "customer") //nome do atributo da classe na outra ponta do relacionamento
    @JsonIgnoreProperties("customer")
    private List<Order> orderList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumRes() {
        return numRes;
    }

    public void setNumRes(String numRes) {
        this.numRes = numRes;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


}
