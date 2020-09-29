package eu.kyberorg.yals.api.controllers;

import eu.kyberorg.yals.api.StubMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stub")
public class StubRestController {

	@GetMapping({"/", ""})
	public StubMessage stub() {
		return new StubMessage("hello hello");
	}
}
