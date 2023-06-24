package com.group.libraryapp.service.user;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    public final UserJdbcRespository userJdbcRespository;

    public UserService(UserJdbcRespository userJdbcRespository) {
        this.userJdbcRespository = userJdbcRespository;
    }

    public void updateUser(UserUpdateRequest request) {
        if (userJdbcRespository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        userJdbcRespository.UpdateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name) {
        if (userJdbcRespository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userJdbcRespository.deleteUser(name);
    }

    public void saveUser(UserCreateRequest request) {
        userJdbcRespository.saveUser(request.getName(),request.getAge());
    }

    public List<UserResponse> getUsers(){
        return userJdbcRespository.getUsers();
    }
}
