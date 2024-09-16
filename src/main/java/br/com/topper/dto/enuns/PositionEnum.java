package br.com.topper.dto.enuns;

public enum PositionEnum {
    GOLEIRO("Goleiro", "GOL"),
    LATERAL("Lateral", "LAT"),
    ZAGUEIRO("Zagueiro", "ZAG"),
    MEIA("Meia", "MEI"),
    ATACANTE("Atacante", "ATA");

    private final String position;
    private final String abbreviation;

    PositionEnum(String position, String abbreviation) {
        this.position = position;
        this.abbreviation = abbreviation;
    }

    public static String valueOfAbbreviation(String abbreviation) {
        for (PositionEnum position : PositionEnum.values()) {
            if (position.abbreviation.equals(abbreviation)) {
                return position.position;
            }
        }
        throw new IllegalArgumentException("Invalid abbreviation for PositionEnum: " + abbreviation);
    }

}
