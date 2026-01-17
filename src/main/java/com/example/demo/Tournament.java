package com.example.demo;


import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String winner;
    private String owner;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tournament_players",
            joinColumns = @JoinColumn(name = "tournament_id") // <--- hier
    )
    @MapKeyColumn(name = "position")
    @Column(name = "player_name")
    private Map<Integer, String> players = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tournament_results",
            joinColumns = @JoinColumn(name = "tournament_id")
    )
    @MapKeyColumn(name = "match_position")
    @Column(name = "result")
    private Map<Integer, String> results = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tournament_scoreboard",
            joinColumns = @JoinColumn(name = "tournament_id")
    )
    @MapKeyColumn(name = "player_name")
    @Column(name = "points")
    private Map<String, Integer> scoreboard = new HashMap<>();


    public Tournament() {}

    public Tournament(String name, String Winner, String Owner) {
        this.name = name;
        this.winner = winner;
        this.owner = owner;
    }

    // --- Getter & Setter ---

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getOwner() { return owner; }


    public Map<Integer, String> getPlayers() {
        return players;
    }

    public void setPlayers(Map<Integer, String> players) {
        this.players = players;
    }

    public Map<Integer, String> getResults() {
        return results;
    }

    public void setResults(Map<Integer, String> results) {
        this.results = results;
    }

    public Map<String, Integer> getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Map<String, Integer> scoreboard) {
        this.scoreboard = scoreboard;
    }

}