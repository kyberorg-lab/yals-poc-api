package eu.kyberorg.yals.api.controllers;

import eu.kyberorg.yals.api.jsons.count.CountOutput;
import eu.kyberorg.yals.api.services.LinkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

	private final LinkService linkService;

	public CountController(LinkService linkService) {
		this.linkService = linkService;
	}

	@Operation(summary = "Returns overall number of links")
	@ApiResponse(responseCode = "200", description = "number of links",
		content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
			schema = @Schema(implementation = CountOutput.class)))
	@GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountOutput> countLinks() {
		CountOutput countOutput = CountOutput.builder().overall(linkService.howManyLinksWeHave()).build();
		return ResponseEntity.ok(countOutput);
	}
}
