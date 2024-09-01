package org.example.rentcar.mapper.appeal;

import org.example.rentcar.entity.Apeal;
import org.example.rentcar.entity.Users;
import org.example.rentcar.enums.ApealProgress;

public class ApealAcceptedMapper {
    public static Apeal dtoToEntity(Users user){
        return Apeal.builder()
                .user(user)
                .apealProgress(ApealProgress.ACCEPTED_0)
                .build();
    }
}
