package com.alaoui.evente.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long IdUser;
    private String firstName;
    private String lastName;
    private String Email;
    @Column(name = "user_name")
    private String Username;
    private String password;
    private boolean Actived;
    @OneToMany
    @JoinColumn(name = "user_id")
    private Collection<Role> roles;

    public User(String omar, String password) {
        Username = omar;
        this.password = password;
    }
}
