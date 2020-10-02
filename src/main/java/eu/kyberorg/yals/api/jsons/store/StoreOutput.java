package eu.kyberorg.yals.api.jsons.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.kyberorg.yals.api.jsons.YalsJson;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StoreOutput implements YalsJson {
	@JsonProperty("ident")
	String ident;
}
