package com.data.dashboardNotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "DOCUMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "CATEGORY")
    private Integer category;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "DATE_CREATE")
    private Date date;

    @ManyToMany(mappedBy = "documents")
    private Set<Sample> samples;
}
