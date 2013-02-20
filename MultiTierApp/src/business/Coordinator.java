package business;

import java.util.Collections;
import java.util.List;

import android.content.Context;

import db.DAO;
import db.TextData;

public class Coordinator {
	DAO dataAccess;
	
    private List<VinylRecord> localRecords;
	
	public Coordinator(Context ctx){
		dataAccess = new TextData();
		localRecords = dataAccess.read(ctx);
	}
	
	public List<VinylRecord> read(){
		
		Collections.sort(localRecords);
		return localRecords; 
	}
	
	public List<VinylRecord> readSortByArtist(){
		
    	Collections.sort(localRecords, SortByArtist.getInstance());		
		return localRecords;
	}
	
	public List<VinylRecord> readSortByTitle(){
		
    	Collections.sort(localRecords, SortByTitle.getInstance());		
		return localRecords;
	}
	
}
