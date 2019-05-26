package com.jnshu.service.impl;

import com.jnshu.mapper.IAuthMapper;
import com.jnshu.pojo.Auth;
import com.jnshu.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthServiceImpl implements IAuthService {

        @Autowired
        @Qualifier("IAuthMapper")
        IAuthMapper iAuthMapper;

    @Override
    public boolean findAuth(Auth auth) {
        return iAuthMapper.findAuth(auth);
    }
}
