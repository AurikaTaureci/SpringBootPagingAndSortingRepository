package com.example.SpringBootPagingAndSortingRepository.controller;

import com.example.SpringBootPagingAndSortingRepository.model.Actor;
import com.example.SpringBootPagingAndSortingRepository.service.ActorsService;
import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    private final ActorsService actorsService;

    public ActorController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/sort")
    public Iterable<Actor> getActorsSortedAlfabetically(){
        return actorsService.getActorsSortedAlfabetically(Sort.by("firstName").ascending());
    }

    @GetMapping("/paginable") //http://localhost:8080/paginable?page=0&size=1
    public Iterable<Actor> getActorsInPages(@RequestParam int page, @RequestParam int size){
        return actorsService.getActorsInPages(PageRequest.of(page,size));
    }

    @GetMapping("/get/nationality/{nationality}") //http://localhost:8080/get/nationality/roman?page=0&size=2
    public List<Actor> getActorBynationality(@PathVariable String nationality, @RequestParam int page, @RequestParam int size){
        final Sort sort = Sort.by("firstName").ascending();
        final Pageable pageable = PageRequest.of(page,size,sort);
        return actorsService.findActorByNationality(nationality,pageable);
    }
}
