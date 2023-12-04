package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {
        //BoardService에서 만들어준 boardList가 반환되는데, list라는 이름으로 받아서 넘기겠다는 뜻
        model.addAttribute("list", boardService.boardList());
        return "boardList";
    }

    /* 상세페이지2 */
    @GetMapping("/board/view") //localhost:8090/board/view?id=1 // (get방식 파라미터)
    public String boardView(Model model, Integer id) {
        /* 상세페이지 4 */
        model.addAttribute("board", boardService.boardview(id));
        return "boardview";
    }

    // 글 삭제3
    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);
        // 게시물 삭제 후 리스트로 넘어가게 설정
        return "redirect:/board/list";
    }

    // 수정2
    // PathVariable은 modify 뒤에 있는 {id}가 인식되어 Integer형태의 id로 들어온다는 것
    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        // 수정4
        // 상세 페이지에 있는 내용과, 수정 페이지의 내용이 같기 때문에 위 코드와 같은 것을 확인할 수 있다
        model.addAttribute("board", boardService.boardview(id));
        return "boardmodify";
    }

    // 수정7
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {
        // 기존에 있던 글이 담겨온다
        Board boardTemp = boardService.boardview(id);

        // 기존에 있던 내용을 새로운 내용으로 덮어씌운다
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.write(boardTemp); // 수정한 내용을 boardService의 write부분에 넣기
        return "redirect:/board/list";
    }
}
