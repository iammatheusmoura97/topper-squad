package br.com.topper.dto.entity;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.PlayerDataDTO;
import br.com.topper.dto.StatisticsAccumulatedDTO;
import br.com.topper.dto.StatisticsDTO;
import br.com.topper.dto.enuns.ClubsEnum;
import br.com.topper.dto.enuns.PositionEnum;
import br.com.topper.dto.enuns.StatusPlayerEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private Double price;
    private String status;
    private String club;
    private Boolean isBought;

//    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "player")
//    private PlayerData playerData;

    public Player() {}

    public Player(String name,
                  String club,
                  String position,
                  Double price,
                  String status,
                  Boolean isBought) {
        this.name = name;
        this.club = ClubsEnum.valueOfAbbreviation(club);
        this.position = PositionEnum.valueOfAbbreviation(position);
        this.price = price;
        this.status = StatusPlayerEnum.valueOfStatus(status);
        this.isBought = isBought;
    }

    public PlayerDTO convertToDto(Player player, List<StatisticsDTO> listStatisticsDTO, StatisticsAccumulatedDTO statisticsAccumulated) {
        return PlayerDTO.builder()
                .name(player.getName())
                .club(player.getClub())
                .position(player.getPosition())
                .price(player.getPrice())
                .status(player.getStatus())
                .isBought(player.getIsBought())
                .playerData(PlayerDataDTO.builder()
                        .statistics(listStatisticsDTO)
                        .statisticsAccumulated(statisticsAccumulated)
                        .build())
                .build();
    }

    public PlayerDTO convertToDto(Player player) {
        return PlayerDTO.builder()
                .name(player.getName())
                .club(player.getClub())
                .position(player.getPosition())
                .price(player.getPrice())
                .status(player.getStatus())
                .isBought(player.getIsBought())
                .build();
    }

}
