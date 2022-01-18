package com.example.desarrollo.demo.hospital;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<MedicoUser> medicoUser;

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

    public List<MedicoUser> getMedicoUser() {
        return medicoUser;
    }

    public void setMedicoUser(List<MedicoUser> medicoUser) {
        this.medicoUser = medicoUser;
    }

}
