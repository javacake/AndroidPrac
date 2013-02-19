package business;

import java.util.List;

import android.content.Context;

import db.DAO;
import db.TextData;

public class Coordinator {
	DAO dataAccess;
	
	public Coordinator(){
		dataAccess = new TextData();
	}
	
	public List<VinylRecord> read(Context ctx){
		return dataAccess.read(ctx);
	}
	
}
