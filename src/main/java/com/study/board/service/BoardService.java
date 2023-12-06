package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired // new를 쓰지 않아도 스프링 부트가 알아서 읽어와 주입해준다
    private BoardRepository boardRepository;

    // 글 작성 처리
    /* MultipartFile file 추가 */ /* 예외처리 */
    public void write(Board board, MultipartFile file) throws Exception {
        /* 프로젝트 결로를 담아주게 된다 - 저장할 경로를 지정 */
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        /* 식별자, 랜덤으로 이름 만들어줌 */
        UUID uuid = UUID.randomUUID();

        /* 랜덤식별자_원래파일이름 = 저장될 파일이름 지정 */
        String fileName = uuid + "_" + file.getOriginalFilename();

        /* 빈 껍데기 생성 */
        /* File을 생성할건데, 이름은 "name"으로 하고, projectPath라는 경로에 담긴다는 뜻 */
        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        /* db에 파일 넣기 */
        board.setFilename(fileName);
        /* 저장되는 경로 */
        board.setFilepath("/files/" + fileName); /* 저장된 파일의 이름, 경로 */

        /* 파일 저장 */
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
