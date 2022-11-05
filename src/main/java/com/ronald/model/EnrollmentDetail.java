package com.ronald.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//JPA
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentDetail;
    //Debe tener una relacion con Enrollment
    //Muchos detalles pueden pertenecer a una matricula
    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false)
    @JsonBackReference
    private Enrollment enrollment;
    @ManyToOne
    @JoinColumn(name = "id_subject", nullable = false, foreignKey = @ForeignKey(name = "FK_EnrollmentDT_Subject"))
    private Subject subject;
    @Column(length = 10, nullable = false)
    private String room;
}
