package com.aula.app.ws.userservice;

import com.aula.app.ws.ui.model.request.UserDetailsRequestModel;
import com.aula.app.ws.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);
}
