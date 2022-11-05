package com.ronald.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//JPA
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollment;
    @Column(nullable = false)
    private LocalDateTime localDateTime;
    //Establecer una relacion de ONE TO ONE
    //Se utiliza el JoinColumn para relacionar las tablas
    @OneToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_Enrollment_Student"))
    private Student student;
    //Relacion Logica Maestro - Detalle
    //El mappedBy debe tener el nombre que tiene la clase EnrollmentDetail
    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<EnrollmentDetail> details;
    @Column(nullable = false)
    private boolean status;
}
