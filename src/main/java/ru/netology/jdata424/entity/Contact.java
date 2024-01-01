package ru.netology.jdata424.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contact implements Serializable {

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    private String surname;

    private int age;
}
