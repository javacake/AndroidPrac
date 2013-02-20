package business;

import java.util.Comparator;

public class SortByArtist implements Comparator<VinylRecord>{

	private static SortByArtist instance;
	
	private SortByArtist(){}
	
	public static SortByArtist getInstance(){
		if(instance == null)
			instance = new SortByArtist();
		return instance;
	}

	@Override
	public int compare(VinylRecord r1, VinylRecord r2) {
		
		return r1.getArtist().compareTo(r2.getArtist());
	}
	
}
