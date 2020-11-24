package com.doufu.words.Service;

import com.doufu.words.Controller.DTO.UserParameter;
import com.doufu.words.Model.vo.Result;

public interface UserService {
    Result userInfo(UserParameter userParameter);
}
