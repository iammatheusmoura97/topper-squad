package br.com.topper.dto.entity;

import br.com.topper.dto.PlayerDataDTO;
import br.com.topper.dto.StatisticsDTO;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Type;

@Entity
@Getter
public class PlayerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private StatisticsDTO statistics;

//    @Type(JsonBinaryType.class)
//    @Column(columnDefinition = "jsonb")
//    private Map<String, Object> generalData;

    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    public PlayerData(Player player, StatisticsDTO statistics) {
        this.statistics = statistics;
        this.player = player;
    }

    public PlayerData() {}

    public PlayerDataDTO convertToDto(PlayerData playerData) {
        return PlayerDataDTO.builder()
                .statistics(playerData.getStatistics())
                .build();
    }
}
