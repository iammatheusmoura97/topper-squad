package br.com.topper.dto.enuns;

public enum StatusPlayerEnum {

    PROVAVEL("Provável"),
    DUVIDA("Dúvida"),
    SUSPENSO("Suspenso"),
    CONTUNDIDO("Contundido");

    private final String status;

    StatusPlayerEnum(String status) {
        this.status = status;
    }

    public static String valueOfStatus(String name) {
        for (StatusPlayerEnum statusPlayerEnum : StatusPlayerEnum.values()) {
            if (statusPlayerEnum.name().equalsIgnoreCase(name)) {
                return statusPlayerEnum.status;
            }
        }
        throw new IllegalArgumentException("Invalid Status for StatusPlayerEnum: " + name);
    }
}
