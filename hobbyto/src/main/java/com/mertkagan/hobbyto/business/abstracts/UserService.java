package com.mertkagan.hobbyto.business.abstracts;

import com.mertkagan.hobbyto.business.requests.CreateUsersRequest;
import com.mertkagan.hobbyto.business.requests.LoginRequest;
import com.mertkagan.hobbyto.business.responses.LoginResponse;
import com.mertkagan.hobbyto.entities.concretes.User;

public interface UserService {
    Long createOneUser(CreateUsersRequest createUsersRequest);


    LoginResponse loginUser(LoginRequest loginRequest);


    User getUserById(Long userId);
}
