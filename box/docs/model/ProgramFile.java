package com.stand_alone.docs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "FILE_TABLE")
@Entity
public class ProgramFile {

    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "FILE_CODE")
    private String code;

    @Column(name = "FILE_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "FILE_ID")
    private Set<ProgramReference> references = new HashSet<>();
}
