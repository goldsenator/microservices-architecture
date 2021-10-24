package kz.iitu.liquor.eshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String surName;

    @Column(name = "middlemen")
    private String middleName;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "email")
    private String email;

    @Column(name = "contacting")
    private String contact;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

    @Column(name = "status")
    private String status;
}
