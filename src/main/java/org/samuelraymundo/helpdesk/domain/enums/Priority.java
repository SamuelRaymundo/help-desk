package org.samuelraymundo.helpdesk.domain.enums;

public enum Priority {
    LOW(0,"LOW"),
    MEDIUM(1,"MEDIUM"),
    HIGH(2,"HIGH");

    private Integer code;
    private String description;

    Priority(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (Priority priority : Priority.values()) {
            if (code.equals(priority.getCode())) {
                return priority;
            }
        }

        throw new IllegalArgumentException("Invalid priority");
    }
}
