package com.keyin.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.keyin.model.Member;
import com.keyin.service.TournamentService;
import com.keyin.model.Tournament;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public Tournament createOrUpdateTournament(@RequestBody Tournament tournament) {
        return tournamentService.saveTournament(tournament);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTournamentById(@PathVariable Long id) {
        tournamentService.deleteTournamentById(id);
    }

    @PostMapping("/{tournamentId}/add-member/{memberId}")
    public Tournament addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        System.out.println("Received request to add member: " + memberId + " to tournament: " + tournamentId);
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }


    @GetMapping("/{tournamentId}/members")
    public List<Member> getAllMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.getAllMembersInTournament(tournamentId);
    }
}
