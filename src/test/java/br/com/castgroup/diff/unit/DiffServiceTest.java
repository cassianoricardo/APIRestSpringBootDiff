package br.com.castgroup.diff.unit;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.castgroup.diff.model.Diff;
import br.com.castgroup.diff.service.DiffService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffServiceTest {

	
	@Autowired
	public DiffService diffService;
	
	@Test
	public void salvarDiffLeff() {
		diffService.salvarDiffLeft(converteJsonParaString("{\"json\":\"teste\"}"),1);
		Diff diffLeft = diffService.diffs.get(1);
		assertEquals("A DiffLeft não foi encontrada","teste", null!=diffLeft.getDiffLeft()?diffLeft.getDiffLeft():"");
	}
	
	@Test
	public void salvarDiffRight() {
		diffService.salvarDiffRight(converteJsonParaString("{\"json\":\"teste\"}"),1);
		Diff diffRight = diffService.diffs.get(1);
		assertEquals("A DiffRight não foi encontrada","teste", null!=diffRight.getDiffRight()?diffRight.getDiffRight():"");
	}
	
	@Test
	public void comparaSeAsDiffsSaoIguals() {
		diffService.salvarDiffRight(converteJsonParaString("{\"json\":\"teste\"}"),1);
		diffService.salvarDiffLeft(converteJsonParaString("{\"json\":\"teste\"}"),1);
		diffService.compareDiffs(1);
	}
	
	public String converteJsonParaString(String json) {
		 JSONObject ObjectJson;
		 String strJson = "";
		try {
			ObjectJson = new JSONObject(json);
			strJson = ObjectJson.get("json").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return strJson;
	}
		
}
