package com.example.devsokdak.board.controller;


import com.example.devsokdak.board.dto.BoardRequestDto;
import com.example.devsokdak.board.dto.BoardResponseDto;
import com.example.devsokdak.board.service.BoardService;
import com.example.devsokdak.global.MsgResponseDto;
import com.example.devsokdak.global.exception.SuccessCode;
import com.example.devsokdak.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class BoardController {

    private final BoardService boardService;

    @PostMapping(value = "/board", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public BoardResponseDto createBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                        @RequestPart BoardRequestDto request,
                                        @RequestPart("image") MultipartFile multipartFile) throws IOException {
        return boardService.createBoard(request, userDetails.getUser(), multipartFile);
    }

    //게시글 수정
    @PutMapping("/boards/{boardId}")
    public BoardResponseDto updateBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                        @PathVariable Long id,
                                        @RequestPart BoardRequestDto requestDto,
                                        @RequestPart("image") List<MultipartFile> multipartFile) throws IOException {
        return boardService.updateBoard(userDetails.getUser(), id, requestDto, multipartFile);
    }


    // 게시글 전체 조회
    @GetMapping("/boards")
    public List<BoardResponseDto> getListBoards() {
        return boardService.getListBoards();
    }

    //카테고리 별 조회
    @GetMapping("/boadrs")
    public List<BoardResponseDto> getCategoryBoards(@RequestParam int interestTag) {
        return boardService.getCategoryBoards(interestTag);
    }


    // 게시글 상세 조회 boardId
    @GetMapping("/boards/{boardId}")
    public BoardResponseDto getBoards(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.getBoard(id, userDetails.getUser());
    }



    // 게시글 삭제
    @DeleteMapping("/boards/{boardId}")
    public MsgResponseDto deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardService.deleteBoard(id, userDetails.getUser());
        return new MsgResponseDto(SuccessCode.DELETE_BOARD);
    }

    // 게시글 좋아요
    @PostMapping("/boards/{boardId}/boardLike")
    public ResponseEntity<MsgResponseDto> saveBoardLike(
            @PathVariable Long boardId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(boardService.saveBoardLike(boardId, userDetails.getUser()));
    }

    // 게시글 좋아요 취소
    @DeleteMapping("/boards/{boardId}/boardLike")
    public ResponseEntity<MsgResponseDto> cancelBoardLike(
            @PathVariable Long boardId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok().body(boardService.cancelBoardLike(boardId, userDetails.getUser()));
    }
}