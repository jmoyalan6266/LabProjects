import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapProbs {
	public static void main(String ars[]) throws IOException{
		HashMap<String, String> animalSounds = new HashMap<>();
		animalSounds.put("Dog", "Woof");
		animalSounds.put("Geetu", "I'm Stupid");
		animalSounds.put("Srujan", "I'm Smart");
		animalSounds.put("Kapil", "COMPSCIIIII");
		System.out.println(animalSounds);
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(animalSounds.get(str));
		System.out.println(animalSounds.size());
		String newAnimal = in.nextLine();
		String newSound = in.nextLine();
		System.out.println(animalSounds.put(newAnimal, newSound));
		System.out.println(animalSounds);
		HashMap<String, String> map = new HashMap<>();
		map.put("a", "candy");
		map.put("b", "dirt");
		System.out.println(mapBully(map));
		map = new HashMap<>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		System.out.println(mapShare(map));
		System.out.println(wordCloud("dream.txt"));
	}

	public static HashMap<String, String> mapBully(HashMap<String, String> map) {
		map.put("b", map.put("a", ""));
		return map;
	}

	public static HashMap<String, String> mapShare(HashMap<String, String> map) {
		map.remove("c");
		map.put("b", map.get("a"));
		return map;
	}

	public static HashMap<String, Integer> wordCloud(String fileName) throws IOException{
		HashMap<String, Integer> w = new HashMap<>();
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			String v = in.next();
			if (w.containsKey(v)) {
				w.put(v, w.get(v) + 1);
			} else {
				w.put(v, 0);
			}
		}
		HashMap<String, Integer> lFreq = new HashMap<>();
		int max = Collections.max(w.values());
		for (String word : w.keySet())
		{
			if (w.get(word) == max)
			{
				lFreq.put(word, max);
			}
		}
		
		return lFreq;
	}

}