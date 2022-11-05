package com.ronald.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStudent;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50,nullable = false)
    private String lastname;
    @Column(length = 8, nullable = false)
    private String dni;
    @Column(nullable = false)
    private int age;
}
