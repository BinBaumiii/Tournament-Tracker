package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository repo;

    public Tournament save(Tournament tournament) {
        return repo.save(tournament);
    }

    public Tournament get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Tournament> getAllWithoutOwner() {
        Iterable<Tournament> all = repo.findAll();
        List<Tournament> result = new ArrayList<>();

        for (Tournament tournament : all) {
            if (tournament.getOwner() == null || tournament.getOwner().isEmpty()) {
                result.add(tournament);
            }
        }

        return result;
    }


    public List<Tournament> getAllOwnedBy(String owner) {
        Iterable<Tournament> iterator = repo.findAll();
        List<Tournament> tournaments = new ArrayList<Tournament>();
        for (Tournament tournament : iterator) if(tournament.getOwner()!=null && tournament.getOwner().equals(owner)) tournaments.add(tournament);
        return tournaments;
    }


}
