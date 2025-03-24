package com.keyin.service;

import java.util.List;
import java.util.Optional;
import com.keyin.model.Member;
import com.keyin.model.Tournament;
import com.keyin.repository.MemberRepository;
import com.keyin.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public void deleteTournamentById(Long id) {
        if (tournamentRepository.existsById(id)) {
            tournamentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException(
                    "Tournament with ID " + id + " does not exist."
            );
        }
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Tournament with ID " + tournamentId + " does not exist."
                ));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Member with ID " + memberId + " does not exist."
                ));

        tournament.getParticipatingMembers().add(member);
        return tournamentRepository.save(tournament);
    }

    public List<Member> getAllMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Tournament with ID " + tournamentId + " does not exist."
                ));
        return tournament.getParticipatingMembers();
    }
}