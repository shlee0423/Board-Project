package com.board.mapper;

import com.board.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int selectUsername(String id);
    void insertUser(UserDTO user);
}
