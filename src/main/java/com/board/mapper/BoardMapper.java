package com.board.mapper;

import com.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectBoards();
    void insertBoardPost(BoardDTO boardDTO);
    BoardDTO selectBoardByNo(int no);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(int no);
}
