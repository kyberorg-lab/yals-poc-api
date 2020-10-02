package eu.kyberorg.yals.api.controllers;

import eu.kyberorg.yals.api.core.IdentGenerator;
import eu.kyberorg.yals.api.jsons.store.StoreInput;
import eu.kyberorg.yals.api.jsons.store.StoreOutput;
import eu.kyberorg.yals.api.models.Link;
import eu.kyberorg.yals.api.services.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class StoreController {

	private final LinkService linkService;

	public StoreController(final LinkService linkService) {
		this.linkService = linkService;
	}

	@Operation(summary = "Stores long link")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "Link stored successfully",
			content = {@Content(mediaType = "application/json",
				schema = @Schema(implementation = StoreOutput.class))}),
		@ApiResponse(responseCode = "500", description = "When server error occurs",
			content = @Content)
	})
	@PostMapping(value = "/store",
		consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoreOutput> store(final @RequestBody StoreInput storeInput) throws Exception {
		String linkToStore = storeInput.getLink();
		Link storedLink = linkService.storeNew(IdentGenerator.generateNewIdent(), linkToStore);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
			.path("/get/{ident}")
			.buildAndExpand(storedLink.getIdent())
			.toUri();
		StoreOutput output = StoreOutput.builder().ident(storedLink.getIdent()).build();
		return ResponseEntity.created(uri).body(output);
	}

}
