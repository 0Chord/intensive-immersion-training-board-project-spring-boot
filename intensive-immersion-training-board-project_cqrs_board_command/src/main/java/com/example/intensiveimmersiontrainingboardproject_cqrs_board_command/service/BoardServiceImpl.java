package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.PasswordDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	@Override
	public void save(BoardDto boardDto) throws Exception {
		try {
			Board boardEntity = Board.builder().title(boardDto.getTitle()).content(boardDto.getContent())
				.createdDate(boardDto.getCreatedDate()).nickname(boardDto.getNickname()).modifiedDate(
					boardDto.getModifiedDate()).password(boardDto.getPassword())
				.build();
			boardRepository.save(boardEntity);
		} catch (Exception e) {
			throw new Exception("저장에 실패했습니다.");
		}

	}

	@Override
	@Transactional
	public void deleteBoard(Long id, PasswordDto passwordDto) throws Exception {
		try {
			Board board = boardRepository.findBoardById(id).orElse(null);
			assert board != null;
			if (passwordDto.getPassword().equals(board.getPassword())) {
				boardRepository.deleteBoardById(id);
			}else{
				throw new IllegalArgumentException("비밀번호 이슈");
			}
		} catch (Exception e) {
			throw new Exception("삭제에 실패했습니다.");
		}
	}

	@Override
	@Transactional
	public void updateTitleAndContent(Long id, String title, String content) throws Exception {
		Board board = boardRepository.findBoardById(id).orElse(null);
		if (board != null) {
			board.updateTitleAndContent(title, content);
		} else {
			throw new Exception("이미 존재합니다.");
		}
	}

	@Override
	public Optional<Board> findBoard(Long id) {
		return boardRepository.findBoardById(id);
	}

}
