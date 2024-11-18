package br.com.topper.respository;

import br.com.topper.dto.entity.PlayerData;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDataRepository extends CrudRepository<PlayerData, Long> {
}
