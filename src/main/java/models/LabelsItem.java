package models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class LabelsItem {

	@SerializedName("name")
	private String name;

	@SerializedName("value")
	private String value;
}