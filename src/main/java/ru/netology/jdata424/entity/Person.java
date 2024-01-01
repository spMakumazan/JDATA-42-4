package ru.netology.jdata424.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONS")
public class Person {

    @EmbeddedId
    private Contact contact;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 20)
    private String cityOfLiving;
}
