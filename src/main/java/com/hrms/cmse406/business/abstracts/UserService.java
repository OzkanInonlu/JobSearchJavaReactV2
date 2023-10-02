package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    Result add(User user);

    DataResult<User> getUserByEmail(String email);

    Result delete(User user);
}