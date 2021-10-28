package enums;

import lombok.Getter;

@Getter
public enum Status {
    IGNORE("unknown", "Светло-багровый 35 %", "#eae6ff"),
    FAILED("failed", "Светло-красный 35 %", "#ffebe6"),
    BROKEN("broken", "Светло-желтый 35 %", "#fffae6"),
    SKIPPED("skipped", "Светло-серый 100 %", "#f4f5f7"),
    PASSED("passed", "", "");

    private String status;
    private String colorName;
    private String colorValue;

    Status(String status, String colorName, String colorValue) {
        this.status = status;
        this.colorName = colorName;
        this.colorValue = colorValue;
    }

    public static String getColorName(String status) {
        switch (status) {
            case "unknown": return IGNORE.colorName;
            case "failed": return FAILED.colorName;
            case "broken": return BROKEN.colorName;
            case "skipped": return SKIPPED.colorName;

            default: throw new EnumConstantNotPresentException(
                    Status.class,
                    "Некорректное значение статуса прохождения теста: " + status
            );
        }
    }

    public static String getColorValue(String status) {
        switch (status) {
            case "unknown": return IGNORE.colorValue;
            case "failed": return FAILED.colorValue;
            case "broken": return BROKEN.colorValue;
            case "skipped": return SKIPPED.colorValue;

            default: throw new EnumConstantNotPresentException(
                    Status.class,
                    "Некорректное значение статуса прохождения теста: " + status
            );
        }
    }
}
