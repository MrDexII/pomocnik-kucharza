import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

public class Pomoc {
	
	private String SkladnikiJakieMamy = "[_]"; 
	private String Przepis = "X";
	private String Danie = "Y";
	private String Link =  "Z";
	private String filePath;
	public List<String> slownikSkladniki;
	
	public Pomoc(String filePath) {
		this.filePath = filePath;
		consult();
	}
	
	private void consult() {
		String consultQuery = "consult('" + filePath + "')";
		Query query = new Query(consultQuery);
		System.out.println(consultQuery + " " + (query.hasSolution() ? "succeeded" : "failed"));
	}
	
	public void initFilds() {
		int checker;
		String queryString = "potrawa("+ Przepis + ",_,_)";
		slownikSkladniki = new ArrayList<String>();
		Map<String, Term>[] output = findAllSolution(queryString);
		
		for (Map<String, Term> solution : output) {
			String temp ;
			temp = solution.get(Przepis).toString();
			temp = temp.replaceAll("[^\\p{L}\\p{Nd}\\_\\,]", "");
			List<String> temp3 = new ArrayList<String>(Arrays.asList(temp.split(",")));
			if (slownikSkladniki.isEmpty()) {
				slownikSkladniki = temp3;
				slownikSkladniki.add(0, " ");
			}else {
				for (String nowySkladnik : temp3) {
					checker = 0;
					for (String skladnik : slownikSkladniki) {
						if (nowySkladnik.equals(skladnik)) {
							checker++;
							break;
						}
					}
					if (checker == 0) {						
						slownikSkladniki.add(nowySkladnik);
					}
				}
			}
		}
	}

	public String help(String queryItemsListString) {
		queryItemsListString = checkEmptyFilds(queryItemsListString);
		if (!queryItemsListString.isEmpty()) {
			String queryString = "pomoc([" + queryItemsListString +"], _, " + Danie + ", " + Link + ")";
			List<String> listaPrzepisow = new ArrayList<String>();
			Map<String, Term>[] output = findAllSolution(queryString);
			for (Map<String, Term> map : output) {
				listaPrzepisow.add(map.get(Danie).toString());
			}
			Map<Integer, String> wys = new HashMap<>();
			while (!listaPrzepisow.isEmpty()) {
				String current = listaPrzepisow.get(0);
				wys.put(Collections.frequency(listaPrzepisow, current), current);
				while (listaPrzepisow.contains(current)) {
					listaPrzepisow.remove(current);
				}
			}
			Collection<Integer> v = wys.keySet();
			
			int max = 0;
			for (int object : v) {
				if (object > max) {
					max = object;
				}
			}
			queryString = "pomoc(" + SkladnikiJakieMamy + "," + Przepis +"," + wys.get(max) + "," + Link + ")";
			System.out.println(queryString);
			Query przepisQuery = new Query(queryString);
			String newPrzepis = przepisQuery.oneSolution().get(Przepis).toString();
			newPrzepis = newPrzepis.replaceAll("[^\\p{L}\\p{Nd}\\_\\,]", "");
			return "Danie: " + wys.get(max) + "\n" + "Sk³adniki: " + newPrzepis + "\n" + "Link do przepisu: " + przepisQuery.oneSolution().get(Link);
		}
		return null;
	}
	
	private String checkEmptyFilds(String queryItemsListString) {
		String[] list = queryItemsListString.split(",");
		List<String> newList = new ArrayList<String>(); 
		for (String string : list) {
			if (string.length() == 1 || string.length() == 2) {
				continue;
			}else {
				newList.add(string);
			}
		}
		return String.join(", ", newList);
	}

	private Map<String, Term>[] findAllSolution(String queryString){
		Map<String, Term>[] output;
		Query query = new Query(queryString);
		output = query.allSolutions();
		return output;
	}

}