package eu.kyberorg.yals.api.controllers;

import eu.kyberorg.yals.api.core.IdentGenerator;
import eu.kyberorg.yals.api.jsons.ErrorJson;
import eu.kyberorg.yals.api.jsons.YalsJson;
import eu.kyberorg.yals.api.jsons.store.StoreInput;
import eu.kyberorg.yals.api.jsons.store.StoreOutput;
import eu.kyberorg.yals.api.models.Link;
import eu.kyberorg.yals.api.services.LinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController("/store")
public class StoreController {

	private final LinkService linkService;

	public StoreController(final LinkService linkService) {
		this.linkService = linkService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<YalsJson> store(final @RequestBody StoreInput storeInput) {
		String linkToStore = storeInput.getLink();

		try {
			Link storedLink = linkService.storeNew(IdentGenerator.generateNewIdent(), linkToStore);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{ident}")
				.buildAndExpand(storedLink.getIdent())
				.toUri();
			StoreOutput output = StoreOutput.builder().ident(storedLink.getIdent()).build();
			return ResponseEntity.created(uri).body(output);
		} catch (Exception e) {
			ErrorJson errorJson = ErrorJson.builder().errorMessage(e.getMessage()).build();
			return ResponseEntity.status(500).body(errorJson);
		}
	}

}
