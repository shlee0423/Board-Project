package com.board.mapper;

import com.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    void insertBoardPost(BoardDTO boardDTO);
}