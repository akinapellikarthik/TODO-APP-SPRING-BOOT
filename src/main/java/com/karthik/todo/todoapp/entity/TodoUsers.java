package com.karthik.todo.todoapp.entity;

import lombok.*;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "todousers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TodoUsers {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "todousers_sequence")
    private Integer userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "passwd")
    private String password;


}
