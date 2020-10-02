package eu.kyberorg.yals.api.controllers;

import eu.kyberorg.yals.api.jsons.get.GetOutput;
import eu.kyberorg.yals.api.models.Link;
import eu.kyberorg.yals.api.services.LinkService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

	private final LinkService linkService;

	public GetController(LinkService linkService) {
		this.linkService = linkService;
	}

	@GetMapping(value = "/get/{ident}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getLink(@PathVariable("ident") String ident) {
		Optional<Link> foundLink = linkService.getLinkByIdent(ident);
		if (foundLink.isPresent()) {
			GetOutput output = GetOutput.builder().link(foundLink.get().getLink()).build();
			return ResponseEntity.ok(output);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
