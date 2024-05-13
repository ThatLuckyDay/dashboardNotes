package com.stand_alone.docs.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "REFERENCE_TABLE")
public class ProgramReference {

    @Id
    @GeneratedValue
    @Column(name = "REFERENCE_ID")
    private Integer id;

    @Column(name = "DEPENDED_FILE_ID")
    private Integer dependentFileId;
}
