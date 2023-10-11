package com.example.SpringBootPagingAndSortingRepository.service;

import com.example.SpringBootPagingAndSortingRepository.model.Actor;
import com.example.SpringBootPagingAndSortingRepository.repository.ActorRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsService {

    private final ActorRepository actorRepository;


    public ActorsService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Iterable<Actor> getActorsSortedAlfabetically(Sort sort){
        return actorRepository.findAll(sort);
    }

    public Iterable<Actor> getActorsInPages(Pageable pageable){
        return actorRepository.findAll(pageable);
    }

    public List<Actor> findActorByNationality(String nationality, Pageable pageable){
        return actorRepository.findActorByNationality(nationality,pageable);
    }
}
