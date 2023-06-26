package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.dto.BoardDto;
import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;

	@Override
	public void save(BoardDto boardDto) throws Exception {
		try{
			Board boardEntity = Board.builder().title(boardDto.getTitle()).content(boardDto.getContent()).build();
			boardRepository.save(boardEntity);
		}catch (Exception e){
			throw new Exception("저장에 실패했습니다.");
		}

	}

	@Override
	@Transactional
	public void deleteBoard(Long id) throws Exception {
		try{
			boardRepository.deleteBoardById(id);
		}catch (Exception e){
			throw new Exception("삭제에 실패했습니다.");
		}
	}
}