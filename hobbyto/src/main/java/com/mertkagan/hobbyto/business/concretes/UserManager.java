package com.mertkagan.hobbyto.business.concretes;

import com.mertkagan.hobbyto.business.abstracts.UserService;
import com.mertkagan.hobbyto.business.requests.CreateUsersRequest;
import com.mertkagan.hobbyto.business.requests.LoginRequest;
import com.mertkagan.hobbyto.business.responses.LoginResponse;
import com.mertkagan.hobbyto.dataAccess.abstracts.UserRepository;
import com.mertkagan.hobbyto.entities.concretes.Post;
import com.mertkagan.hobbyto.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    @Override
    public Long createOneUser(CreateUsersRequest createUsersRequest) {
        User user = new User(
                createUsersRequest.getId(),
                createUsersRequest.getName(),
                createUsersRequest.getSurName(),
                createUsersRequest.getUserName(),
                createUsersRequest.getEmail(),
               this.passwordEncoder.encode(createUsersRequest.getPassword())


        );


        userRepository.save(user);

        return user.getId();
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        String msg = "";
        User user1 = userRepository.findByUserName(loginRequest.getUserName());
        if (user1 != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByUserNameAndPassword(loginRequest.getUserName(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true,user1.getId(),user1.getUserName(), user1.getProfilePic());
                } else {
                    return new LoginResponse("Login Failed", false,null,null,null);
                }
            } else {

                return new LoginResponse("Password Not Match", false,null,null,null);
            }
        }else {
            return new LoginResponse("Username not exits", false,null,null,null);
        }



    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


}
