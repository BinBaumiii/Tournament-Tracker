package com.example.demo;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {

    private Long id;

    private String name;

    private Map<Integer, String> player = new HashMap<>();
    // Startposition und Name

    private Map<Integer, String> results = new HashMap<>();
    // Spielposition und Ergebnis als String (z.B. 2:1 weil erstmal einfacher)

    private Map<String, Integer> scoreboard = new HashMap<>();
    // Name und Anzahl der gewonnenen Turniere

    private String winner;

    public Tournament() {}

    public Tournament(String name) {
        this.name = name;
    }

    // --- Getter & Setter ---
/*
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

 */
}
