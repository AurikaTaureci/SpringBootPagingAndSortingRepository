package com.example.SpringBootPagingAndSortingRepository.repository;

import com.example.SpringBootPagingAndSortingRepository.model.Actor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {

    public List<Actor> findActorByNationality(String nationality, Pageable pageable);
}
