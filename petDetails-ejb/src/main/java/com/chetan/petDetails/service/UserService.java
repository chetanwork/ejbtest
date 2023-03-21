package com.chetan.petDetails.service;

import com.chetan.petDetails.ejb.User;

public interface UserService {

    User login(String userName, String password);

}