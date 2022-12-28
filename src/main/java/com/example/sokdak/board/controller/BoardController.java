package com.example.sokdak.board.controller;


import com.example.sokdak.board.dto.BoardRequestDto;
import com.example.sokdak.board.dto.BoardResponseDto;
import com.example.sokdak.board.service.BoardService;
import com.example.sokdak.global.MsgResponseDto;
import com.example.sokdak.global.exception.SuccessCode;
import com.example.sokdak.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
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
                                        @PathVariable Long boardId,
                                        @RequestPart BoardRequestDto request,
                                        @RequestPart(value = "image" ,required = false) MultipartFile multipartFile) throws IOException {
        return boardService.updateBoard(userDetails.getUser(), boardId, request, multipartFile);
    }
    // 게시글 전체 조회
    @GetMapping("/boards")
    public Page<BoardResponseDto> getListBoards(@PageableDefault(size = 20) Pageable pageable) {
        return boardService.getListBoards(pageable);
    }

    //카테고리 별 조회
    @GetMapping("/boards/category")
    public Page<BoardResponseDto> getCategoryBoards(@RequestParam("interestTag") int interestTag,@PageableDefault(size = 20) Pageable pageable) {
        return boardService.getCategoryBoards(interestTag,pageable);
    }
    // 게시글 상세 조회 boardId
    @GetMapping("/boards/{boardId}")
    public BoardResponseDto getBoards(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.getBoard(boardId, userDetails.getUser());
    }
    // 게시글 삭제
    @DeleteMapping("/boards/{boardId}")
    public MsgResponseDto deleteBoard(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardService.deleteBoard(boardId, userDetails.getUser());
        return new MsgResponseDto(SuccessCode.DELETE_BOARD);
    }

    //게시글 좋아요 기능
    @PostMapping("/boards/{boardId}/boardLike")
    public MsgResponseDto saveBoardLike(
            @PathVariable Long boardId,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.boardLike(boardId, userDetails.getUser());
    }
}