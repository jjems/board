package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired // new를 쓰지 않아도 스프링 부트가 알아서 읽어와 주입해준다
    private BoardRepository boardRepository;

    public void write(Board board) {
        boardRepository.save(board);
    }
}
