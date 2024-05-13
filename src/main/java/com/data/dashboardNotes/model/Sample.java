package com.data.dashboardNotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "SAMPLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @ManyToMany
    @JoinTable(name = "SAMPLE_DOCUMENT",
            joinColumns = @JoinColumn(name = "SAMPLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOCUMENT_ID"))
    Set<Document> documents;

    @ManyToMany
    @JoinTable(name = "SAMPLE_PROBLEM",
            joinColumns = @JoinColumn(name = "SAMPLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROBLEM_ID"))
    Set<Problem> problems;
}
