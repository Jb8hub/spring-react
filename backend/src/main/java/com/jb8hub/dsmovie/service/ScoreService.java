package com.jb8hub.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jb8hub.dsmovie.dto.MovieDTO;
import com.jb8hub.dsmovie.dto.ScoreDTO;
import com.jb8hub.dsmovie.entities.Movie;
import com.jb8hub.dsmovie.entities.Score;
import com.jb8hub.dsmovie.entities.User;
import com.jb8hub.dsmovie.repositories.MovieRepository;
import com.jb8hub.dsmovie.repositories.ScoreRepository;
import com.jb8hub.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository repository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if( user == null ) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setUser(user);
		score.setValue(dto.getScore());
		score.setMovie(movie);
		
		score = repository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s: movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}

}
