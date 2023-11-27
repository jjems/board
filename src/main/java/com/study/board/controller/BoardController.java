package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //어떤 url로 접근할 것인지 정해주는 어노테이션
    public String boardWriteForm() {
        return "boardwrite";
    }

    //내용이 넘어오는 것을 확인
    @PostMapping("/board/writepro") //매개변수로 들어오는 것 작성
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
    }
}
