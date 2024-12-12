package com.board.service;

import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired private BoardMapper boardMapper;

    public List<BoardDTO> getBoards() {
        return boardMapper.selectBoards();
    }

    public BoardDTO getBoard(int no) {
        return boardMapper.selectBoardByNo(no);
    }
    public void createPost(BoardDTO boardDTO) {
        boardMapper.insertBoardPost(boardDTO);
    }
}
