package com.project.vo;

public class Music {
	private int userNo;
	private String songName;
	private String musician;
	private String mood;
	
	public Music() {
		
	}
	
	
	public Music(String songName, String musician, String mood) {
		
		this.songName = songName;
		this.musician = musician;
		this.mood = mood;
	}
	
	public Music(int userNo, String songName, String musician) {
		this.userNo = userNo;
		this.songName = songName;
		this.musician = musician;
	}
	
	
	public Music(int userNo ) {
		this.userNo = userNo;
	
	}
	
	

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getMusician() {
		return musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public String getMood() {
		return mood;
	}

	public void setMood(String mood) {
		this.mood = mood;
	}
	
	public String toString() {
		return 	"[  제목 : " + songName + "\t\t| 가수 : " + musician+ "\t\t| 분위기 : " + mood + "  ]";
	}
	
	public String print() {
		return "[  제목 : " + songName + "\t\t| 가수 : " + musician + "  ]";
	}
}

