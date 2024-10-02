package br.com.topper.respository;

import br.com.topper.dto.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByNameAndClub(String name, String club);

    Optional<Player> findPlayerById(Long id);

}
