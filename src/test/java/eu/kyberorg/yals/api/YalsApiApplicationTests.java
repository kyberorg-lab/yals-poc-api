package eu.kyberorg.yals.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class YalsApiApplicationTests {

	/**
	 * This is empty test
	 */
	@Test
	void contextLoads() {
		String contextLoaded = "Yes";
		assertNotNull(contextLoaded);
	}

}
