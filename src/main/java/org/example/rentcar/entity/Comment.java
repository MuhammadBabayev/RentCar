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

import java.util.List;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment extends CoreEntity {

    String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    Car car;

    @OneToMany(mappedBy = "comment")
    List<Reply> replies;

}
