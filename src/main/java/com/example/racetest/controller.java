package com.example.racetest;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class controller {

    testRepo testRepo;

    @GetMapping("/a")
    public String test(@RequestParam("amount") int amount) {
        Optional<testEntity> test = testRepo.findById(UUID.fromString("c8885399-f3f1-4a48-847d-dcb6b63fa593"));
        if (test.isEmpty()) {
            return "nop";
        }
        testRepo.findById(UUID.fromString("c8885399-f3f1-4a48-847d-dcb6b63fa593"));
        int balance = test.get().balance - amount;
        test.get().setBalance(balance);
        testRepo.update(UUID.fromString("c8885399-f3f1-4a48-847d-dcb6b63fa593"), balance);
        Optional<testEntity> end = testRepo.findById(UUID.fromString("c8885399-f3f1-4a48-847d-dcb6b63fa593"));

        System.out.println(end.get().balance);
        return end.get().balance + "";
        // System.out.println(test.get().balance);
        //  return test.get().balance + "";
    }

}
