package models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class TestCase {
    private String epic;
    private String feature;
    private String story;

    @SerializedName("name")
    private String name;

    @SerializedName("status")
    private String status;

    @SerializedName("labels")
    private List<LabelsItem> labels;

    public void initLabels() {
        if (labels != null) {
            for (LabelsItem labelsItem : labels) {
                switch (labelsItem.getName()) {
                    case "epic" : epic = labelsItem.getValue();
                        break;
                    case "feature" : feature = labelsItem.getValue();
                        break;
                    case "story" : story = labelsItem.getValue();
                }
            }
        }
    }
}
