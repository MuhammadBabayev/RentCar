package org.example.rentcar.service;

import org.example.rentcar.entity.Apeal;
import org.example.rentcar.entity.Users;
import org.example.rentcar.mapper.appeal.ApealAcceptedMapper;
import org.example.rentcar.repository.ApealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApealService {

    private final ApealRepository apealRepository;

    private final UserService userService;

    public Apeal createApeal(Long userId) {
        Optional<Users> user = Optional.ofNullable(userService.getUserById(userId));
        Apeal apeal = ApealAcceptedMapper.dtoToEntity(user.get());
        return apealRepository.save(apeal);
    }


    private boolean isLicenseValid(String license) {
        // compare mentiqi yazilmalidi
        return license != null && !license.isEmpty();
    }

//    @Scheduled(fixedDelay = 60000)
//    public void updateApealsInProgress() {
//        apealRepository.findByApealProgress(ApealProgress.PROGRESS_2)
//                .forEach(apeal -> {
//                    apeal.(ApealProgress.CONTINUE_3);
//                    apealRepository.save(apeal);
//                });
//    }
}
