package com.ohgiraffers.springsecurity.query;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public class UserQueryService {
    private final UserMapper userMapper;
}
