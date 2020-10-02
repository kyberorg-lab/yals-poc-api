package eu.kyberorg.yals.api.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorJson implements YalsJson {
	@JsonProperty("message")
	String errorMessage;
}
