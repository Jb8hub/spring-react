package com.jb8hub.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jb8hub.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
