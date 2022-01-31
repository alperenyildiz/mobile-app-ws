package com.aula.app.ws.userservice;

import com.aula.app.ws.ui.model.request.UserDetailsRequestModel;
import com.aula.app.ws.ui.model.response.UserRest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetailsRequestModel.getEmail());
        returnValue.setFirstName(userDetailsRequestModel.getFirstName());
        returnValue.setLastName(userDetailsRequestModel.getLastName());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);
        return returnValue;
    }
}
