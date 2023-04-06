package com.mertkagan.hobbyto.conrollers;

import com.mertkagan.hobbyto.business.abstracts.UserService;
import com.mertkagan.hobbyto.business.requests.CreateUsersRequest;
import com.mertkagan.hobbyto.business.requests.LoginRequest;
import com.mertkagan.hobbyto.business.responses.LoginResponse;
import com.mertkagan.hobbyto.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @PostMapping("/signUp")
    public Long createOneUser(@RequestBody CreateUsersRequest createUsersRequest){
         return userService.createOneUser(createUsersRequest);


    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        LoginResponse loginResponse = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponse);


    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }


}
