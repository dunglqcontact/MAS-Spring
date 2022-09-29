package com.dunglq.masdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "createDate")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

}
