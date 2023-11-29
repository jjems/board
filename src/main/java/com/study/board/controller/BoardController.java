package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/board/write") //어떤 url로 접근할 것인지 정해주는 어노테이션
    public String boardWriteForm() {
        return "boardwrite";
    }

    // 내용이 넘어오는 것을 확인
    @PostMapping("/board/writepro") //매개변수로 들어오는 것 작성
    public String boardWritePro(Board board) {

        boardService.write(board);

        return "";
    }

    // 1번
    @GetMapping("/board/list")
    public String boardList(Model model) {
        //BoardService에서 만들어준 boardList가 반환되는데, list라는 이름으로 받아서 넘기겠다는 뜻
        model.addAttribute("list", boardService.boardList()); //4번
        return "boardList";
    }

    /* 상세페이지2 */
    @GetMapping("/board/view") //localhost:8090/board/view?id=1 // (get방식 파라미터)
    public String boardView(Model model, Integer id) {
        /* 상세페이지 4 */
        model.addAttribute("board");
        return "boardview";
    }
}
