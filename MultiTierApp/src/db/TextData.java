package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import business.VinylRecord;

public class TextData implements DAO {

	@Override
	public List<VinylRecord> read(Context ctx) {
		// TODO Read whole file
		List<VinylRecord> records = new ArrayList<VinylRecord>();
		
		///MuliTierPrac/src/database/VinylAlbums.db

		Log.d("TextData", "In textData");
		FileReader fr = null;
		InputStream is = null;
		try {
			AssetManager assetManager = ctx.getAssets();
			is = assetManager.open("VinylAlbums.txt");
			
			//AssetFileDescriptor descriptor = assetManager.openFd("VinylAlbums.txt");
			//AssetFileDescriptor descriptor =  ctx.getAssets().openFd("file:///android_asset/VinylAlbums.txt");
			//fr = new FileReader(descriptor.getFileDescriptor());
		}catch (FileNotFoundException e) {
			Log.d("TextData", "File not found");
			return null;
		}
		catch (IOException e1) {	
			Log.d("TextData", "io exc");
			return null;
		}
		
		//Scanner scanReader = new Scanner(fr);
		Scanner scanReader = new Scanner(is);
		scanReader.useDelimiter("\n");

		while(scanReader.hasNext()){
			//read line
			String[] fields = scanReader.next().trim().split(":");
			
			//split and create object
			String title = fields[0];
			String artist = fields[1];
			String producer = fields[2];
			int tracks = Integer.parseInt(fields[3]);
			String sample = fields[4];
			String desc = fields[5];		
	
			//add to records
			records.add(new VinylRecord(title, artist, producer, tracks, sample, desc));			
		}
		
		scanReader.close();

		return records;
	}



}
