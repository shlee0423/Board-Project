package com.board.controller;

import com.board.dto.BoardDTO;
import com.board.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    @Autowired private BoardService boardService;

    // 게시글 목록 조회
    @GetMapping()
    public String getBoardList(
            Model model
    ) {
        List<BoardDTO> boards = boardService.getBoards();
        model.addAttribute("boards", boards);
        return "board";
    }

    // 게시글 작성 페이지 요청
    @GetMapping("/write")
    public String getWrite() {
        return "write";
    }

    // 게시글 작성
    @PostMapping("/write")
    public String createBoard(BoardDTO boardDTO) {
        System.out.println("post write: " + boardDTO);
        log.info("post write: " + boardDTO);
        boardService.createPost(boardDTO);
        return "redirect:/board";
    }

    // 특정 게시글 조회
    @GetMapping("/{no}")
    public String getBoardDetail(@PathVariable int no, Model model) {
        BoardDTO board = boardService.getBoard(no);
        model.addAttribute("board", board);
        return "view";
    }

    // 게시글 수정 페이지 요청
    @GetMapping("/{no}/edit")
    public String getBoardEditPage(@PathVariable int no, Model model) {
        BoardDTO board = boardService.getBoard(no);
        model.addAttribute("board", board);
        return "update";
    }

    // 게시글 수정 처리
    @PostMapping("/{no}")
    public String updateBoard(
            @PathVariable Integer no,
            BoardDTO boardDTO) {
        boardDTO.setNo(no);
        boardService.updatePost(boardDTO);
        return "redirect:/board/" + no;
    }

    @DeleteMapping("/{no}/delete")
    public ResponseEntity<Void> deleteBoard(@PathVariable("no") int no) {
        boardService.deletePost(no);
        return ResponseEntity.noContent().build();  // 204 No Content
    }

}
