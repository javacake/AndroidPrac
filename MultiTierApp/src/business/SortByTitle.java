package business;

import java.util.Comparator;

public class SortByTitle implements Comparator<VinylRecord>{

	private static SortByTitle instance;
	
	private SortByTitle(){}
	
	public static SortByTitle getInstance(){
		if(instance == null)
			instance = new SortByTitle();
		return instance;
	}

	@Override
	public int compare(VinylRecord r1, VinylRecord r2) {
		return r1.getTitle().compareTo(r2.getTitle());
	}

	
}
