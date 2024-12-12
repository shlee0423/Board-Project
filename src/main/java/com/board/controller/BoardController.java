package com.board.controller;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    @Autowired private BoardService boardService;

    @GetMapping()
    public String getBoard(
            Model model
    ) {
        List<BoardDTO> boards = boardService.getBoards();
        model.addAttribute("boards", boards);
        return "board";
    }

    @GetMapping("/write")
    public String getWrite() {
        return "write";
    }

    @PostMapping("/write")
    public String postWrite(BoardDTO boardDTO) {
        System.out.println("post write: " + boardDTO);
        log.info("post write: " + boardDTO);
        boardService.createPost(boardDTO);
        return "redirect:/board";
    }

    @GetMapping("/{no}")
    public String getView(@PathVariable int no, Model model) {
        BoardDTO board = boardService.getBoard(no);
        model.addAttribute("board", board);
        return "view";
    }

}
