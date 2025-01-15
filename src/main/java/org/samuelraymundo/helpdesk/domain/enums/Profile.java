package org.samuelraymundo.helpdesk.domain.enums;

public enum Profile {

    ADMIN(0, "ROLE_ADMIN"),
    CLIENT(1, "ROLE_CLIENT"),
    TECHNICIAN(2, "ROLE_TECHNICIAN");

    private final Integer code;
    private final String description;

    Profile(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Profile profile : Profile.values()) {
            if (code.equals(profile.getCode())){
                return profile;
            }
        }

        throw new IllegalArgumentException("Invalid profile");
    }
}
