package br.com.castgroup.diff.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.castgroup.diff.model.Diff;

@Service
public class DiffService {

	Map<Integer, Diff> diffs = new HashMap();

	public void salvarDiffRight(String json, int id) {
		salvarDiff("right", json, id);
	}

	public void salvarDiffLeft(String json, int id) {
		salvarDiff("left", json, id);
	}

	private void salvarDiff(String posicao, String json, int id) {

		Diff diff = diffs.containsKey(id) ? diffs.get(id) : new Diff();
		if (posicao.equals("right")) {
			diff.setDiffRight(json);
		} else if (posicao.equals("left")) {
			diff.setDiffLeft(json);
		}
		diffs.put(id, diff);
	}

	public boolean compareDiffs(int id) {
		if (diffs.containsKey(id) && 
		    null != diffs.get(id).getDiffLeft() && 
		    null != diffs.get(id).getDiffRight()) {
			
			return diffs.get(id).getDiffLeft().equals(diffs.get(id).getDiffRight());
		}else {
			return false;	
		}
	}
}
