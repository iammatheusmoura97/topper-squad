package br.com.topper.dto.entity;

import br.com.topper.dto.PlayerDTO;
import br.com.topper.dto.enuns.ClubsEnum;
import br.com.topper.dto.enuns.PositionEnum;
import br.com.topper.dto.enuns.StatusPlayerEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private Double price;
    private String status;
    private String club;
    private Boolean isBought;

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
