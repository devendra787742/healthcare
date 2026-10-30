package com.app.service;

import com.app.dto.LoginDto;
import com.app.dto.RespLoginDto;

public interface IHomeService {

	RespLoginDto loginUser(LoginDto credentials);

}
