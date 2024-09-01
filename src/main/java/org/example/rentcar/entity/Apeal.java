package org.example.rentcar.entity;

import org.example.rentcar.enums.ApealProgress;
import org.example.rentcar.utility.core_entity.CoreEntity;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Apeal extends CoreEntity { //Muraciet

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Users user;

    @Enumerated(EnumType.STRING)
    ApealProgress apealProgress;
}
