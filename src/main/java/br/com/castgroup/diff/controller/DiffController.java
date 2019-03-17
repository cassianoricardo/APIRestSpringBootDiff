package br.com.castgroup.diff.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.castgroup.diff.service.DiffService;

@RestController
@RequestMapping(value = "/v1/diff")
public class DiffController {
	
	@Autowired
	DiffService diffService;
	
	@PostMapping("/{id}/left")
	public void salvaDiffLeft(@PathVariable(value = "id") int id,@RequestBody String json) {
		diffService.salvarDiffLeft(converteJsonParaString(json) , id);
	}
	
	@PostMapping("/{id}/right")
	public void salvaDiffRight(@PathVariable(value = "id") int id,@RequestBody String json) {
		diffService.salvarDiffRight(converteJsonParaString(json) , id);
	}
	
	@GetMapping("/{id}")
	public boolean recuperarDiff(@PathVariable(value = "id") int id){
		return diffService.compareDiffs(id);
	}
	
	public String converteJsonParaString(String json) {
		 JSONObject ObjectJson = new JSONObject(json);
		return ObjectJson.get("json").toString();
	}
}
