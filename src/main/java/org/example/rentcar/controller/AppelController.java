package org.example.rentcar.controller;

import org.example.rentcar.entity.Apeal;
import org.example.rentcar.service.ApealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apeals")
@RequiredArgsConstructor
public class AppelController {

    private final ApealService apealService;

    @PostMapping("/create/{userId}")
    public Apeal createApeal(@PathVariable Long userId) {
        return apealService.createApeal(userId);
    }

    @PostMapping("/check-license/{apealId}")
    public void checkLicenseAndProgress(@PathVariable Long apealId) {
       // return apealService.checkLicenseAndProgress(apealId);
    }
}
