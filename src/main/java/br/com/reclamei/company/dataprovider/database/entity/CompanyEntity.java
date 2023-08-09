package br.com.reclamei.company.dataprovider.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "sac_phone", nullable = false)
    private String sacPhone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL})
    private List<HeadEntity> heads;

}
