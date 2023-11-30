package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired // new를 쓰지 않아도 스프링 부트가 알아서 읽어와 주입해준다
    private BoardRepository boardRepository;

    // 글 작성
    public void write(Board board) {
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> boardList(){
        // findAll : "Board" 라는 클래스가 담긴 List를 반환하는 것을 확인할 수 있다
        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardview(Integer id) {
        return boardRepository.findById(id).get(); // 어떤 게시그를 불러올지 지정해주어야 한다(Integer 값으로)
    }

    // 글 삭제2
    // 특정 게시글 삭제
    public void boardDelete(Integer id) { /* id값 n번을 넣어주면 n번을 삭제한다 */
        boardRepository.deleteById(id);
    }
}
