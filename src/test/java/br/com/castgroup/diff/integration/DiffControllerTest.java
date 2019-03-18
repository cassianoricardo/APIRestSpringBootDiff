package br.com.castgroup.diff.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.castgroup.diff.model.Diff;
import br.com.castgroup.diff.service.DiffService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DiffControllerTest {

	final String BASE_URI = "http://localhost:8080/v1/diff";

	@Autowired
	private DiffService diffService;

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void salvarDiffLeft() {
		ResponseEntity<String> response = restTemplate.postForEntity(BASE_URI + "/1/left",
				new String("{\"json\":\"teste\"}"), String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Diff diffLeft = recuperaDiff(1);
		Assert.assertEquals("teste", diffLeft.getDiffLeft());
	}

	@Test
	public void salvarDiffRight() {
		ResponseEntity<String> response = restTemplate.postForEntity(BASE_URI + "/1/right",
				new String("{\"json\":\"teste\"}"), String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Diff diffRight = recuperaDiff(1);
		Assert.assertEquals("teste", diffRight.getDiffRight());
	}

	@Test
	public void salvarDiff() {
		salvarDiffRight();
		salvarDiffLeft();
		ResponseEntity<Boolean> response = restTemplate.getForEntity(BASE_URI + "/1", Boolean.class);
		Assert.assertTrue(response.getStatusCode() == HttpStatus.OK && response.getBody() == true);

	}

	public Diff recuperaDiff(int id) {
		return diffService.diffs.containsKey(id) ? diffService.diffs.get(id) : new Diff();
	}

}
