package com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intensiveimmersiontrainingboardproject_cqrs_board_command.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
	void deleteBoardById(Long id);

	Optional<Board> findBoardById(Long id);
}
