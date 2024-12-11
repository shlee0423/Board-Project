package com.board.service;

import com.board.dto.BoardDTO;
import com.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired private BoardMapper boardMapper;

    public void createPost(BoardDTO boardDTO) {
        boardMapper.insertBoardPost(boardDTO);
    }
}
