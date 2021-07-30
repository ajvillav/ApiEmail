package com.emailapi.EmailApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmailUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID userId;

    @OneToOne
    @JoinColumn(name = "fkPersonId")
    private Person personId;

    @Column
    private String userEmail;

    @Column
    private String userPassword;
}
