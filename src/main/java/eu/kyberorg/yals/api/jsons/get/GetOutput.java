package eu.kyberorg.yals.api.jsons.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.kyberorg.yals.api.jsons.YalsJson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetOutput implements YalsJson {
	@JsonProperty("link")
	String link;
}
