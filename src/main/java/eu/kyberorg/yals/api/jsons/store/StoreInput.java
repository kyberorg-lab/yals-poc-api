package eu.kyberorg.yals.api.jsons.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.kyberorg.yals.api.jsons.YalsJson;
import lombok.Data;

@Data
public class StoreInput implements YalsJson {
	@JsonProperty("link")
	public String link;
}
