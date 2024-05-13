package com.data.dashboardNotes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PROBLEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROBLEM")
    private String problem;

    @Column(name = "SOLUTION")
    private String solution;


    @ManyToMany(mappedBy = "problems")
    private List<Sample> samples;
}
