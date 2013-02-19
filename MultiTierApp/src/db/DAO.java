package db;

import java.util.List;

import android.content.Context;
import business.VinylRecord;
 
public interface DAO{
	
	public List<VinylRecord> read(Context ctx);
	
}
