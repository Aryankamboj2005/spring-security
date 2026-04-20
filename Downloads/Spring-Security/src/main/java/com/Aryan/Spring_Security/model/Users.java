package com.Aryan.Spring_Security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // this is for the jpa and told the jpa this class for the table
@Data
public class Users {
    @Id
    private int  id;
    private String username;
    private String password;
}
