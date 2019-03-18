package br.com.castgroup.diff.unit;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.castgroup.diff.controller.DiffController;
import br.com.castgroup.diff.model.Diff;
import br.com.castgroup.diff.service.DiffService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffControllerTest {

	
	@Autowired
	public DiffController diffController;
	
	@Autowired
	public DiffService diffService;
	
	@Test
	public void salvaDiffLeff() {
		diffController.salvaDiffLeft(1,  "{\"json\":\"teste\"}");
		Diff diffLeft = diffService.diffs.get(1);
		assertEquals("A DiffLeft não foi encontrada","teste", null!=diffLeft.getDiffLeft()?diffLeft.getDiffLeft():"");
	}
	
	@Test
	public void salvaDiffRight() {
		diffController.salvaDiffRight(1,  "{\"json\":\"teste\"}");
		Diff diffRight = diffService.diffs.get(1);
		assertEquals("A DiffRight não foi encontrada","teste", null!=diffRight.getDiffRight()?diffRight.getDiffRight():"");
	}
	
	@Test
	public void comparaSeAsDiffsSaoIguals() {
		diffController.salvaDiffRight(1, "{\"json\":\"teste\"}");
		diffController.salvaDiffLeft(1, "{\"json\":\"teste\"}");
		diffController.comparaDiff(1);
	}
}
