package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TournamentController {

    @Autowired
    TournamentService service;

    Logger logger = LoggerFactory.getLogger(TournamentController.class);

    @PostMapping("/tournaments")
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return service.save(tournament);
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournament(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long tournamentId = Long.parseLong(id);
        return service.get(tournamentId);
    }


    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments(
            @RequestParam(required = false) String owner
    ) {
        if (owner == null || owner.isEmpty()) {
            return service.getAllWithoutOwner();
        }
        return service.getAllOwnedBy(owner);
    }
}
