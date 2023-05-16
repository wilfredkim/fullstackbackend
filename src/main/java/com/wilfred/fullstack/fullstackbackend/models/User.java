package com.wilfred.fullstack.fullstackbackend.models;

import com.wilfred.fullstack.fullstackbackend.util.ValidEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;
    @NotNull
    private String name;

    @ValidEmail
    @NotNull
    private String emailAddress;
}
