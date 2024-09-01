package org.example.rentcar.entity;

import org.example.rentcar.utility.core_entity.CoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Like extends CoreEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    Car car;
}
