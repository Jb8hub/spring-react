package com.jb8hub.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb8hub.dsmovie.entities.Score;
import com.jb8hub.dsmovie.entities.ScorePK;
import com.jb8hub.dsmovie.entities.User;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
