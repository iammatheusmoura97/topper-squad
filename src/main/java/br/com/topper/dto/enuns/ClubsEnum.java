package br.com.topper.dto.enuns;

public enum ClubsEnum {

    // crie um enum com todos os clubes do campeonato brasileiro serie A de 2024
    // cada clube deve ter um nome e uma abreviação
    // e em ordem alfabetica
    // exemplo: FLAMENGO("Flamengo", "FLA")
    // exemplo: ATLETICO_MG("Atlético Mineiro", "CAM")

    ATLETICO_GO("Atlético Goianiense", "ACG"),
    ATLETICO_MG("Atlético Mineiro", "CAM"),
    ATLETICO_PR("Atlético Paranaense", "CAP"),
    BAHIA("Bahia", "BAH"),
    BOTAFOGO("Botafogo", "BOT"),
    BRAGANTINO("Red Bull Bragantino", "RBB"),
    CORINTHIANS("Corinthians", "COR"),
    CRICIUMA("Criciúma", "CRI"),
    CRUZEIRO("Cruzeiro", "CRU"),
    CUIABA("Cuiabá", "CUI"),
    FLAMENGO("Flamengo", "FLA"),
    FLUMINENSE("Fluminense", "FLU"),
    FORTALEZA("Fortaleza", "FOR"),
    GREMIO("Grêmio", "GRE"),
    INTERNACIONAL("Internacional", "INT"),
    JUVENTUDE("Juventude", "JUV"),
    PALMEIRAS("Palmeiras", "PAL"),
    SANTOS("Santos", "SAN"),
    SAO_PAULO("São Paulo", "SAO"),
    VASCO("Vasco", "VAS"),
    VITORIA("Vitória", "VIT");

    private final String nameTeam;
    private final String abbreviationTeam;

    ClubsEnum(String nameTeam, String abbreviationTeam) {
        this.nameTeam = nameTeam;
        this.abbreviationTeam = abbreviationTeam;
    }

    public static String valueOfAbbreviation(String abbreviation) {
        for (ClubsEnum club : ClubsEnum.values()) {
            if (club.abbreviationTeam.equals(abbreviation)) {
                return club.nameTeam;
            }
        }
        throw new IllegalArgumentException("No enum constant with abbreviation " + abbreviation);
    }
}
