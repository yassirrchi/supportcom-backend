package com.supportcom.supportcom.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomRole {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rolename;

}
