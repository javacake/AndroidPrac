package business;

import java.io.Serializable;


public class VinylRecord implements Serializable{
	
	private String title;
	private String artist;
	private String producer;
	private int tracks;
	private String sample;
	private String desc;
	
	public VinylRecord(String title, String artist, String producer,
			int tracks, String sample, String desc) {
	
		this.title = title;
		this.artist = artist;
		this.producer = producer;
		this.tracks = tracks;
		this.sample = sample;
		this.desc = desc;
	}
	
	public String getTitleArtist(){
		return title + ", " + artist;
	}
	
	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getProducer() {
		return producer;
	}

	public int getTracks() {
		return tracks;
	}

	public String getSample() {
		return sample;
	}

	public String getDesc() {
		return desc;
	}
	
	
	
}
