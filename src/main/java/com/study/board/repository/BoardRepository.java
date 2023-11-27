package com.study.board.repository;

import com.study.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// <> 안에 어떤 엔티티를 넣을 것인가, 엔티티의 id 타입
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
