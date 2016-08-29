package com.entity;

public class Yonetmen {
	
	private int id;
	private String ad;

	public Yonetmen() {
		// TODO Auto-generated constructor stub
	}

	public Yonetmen(int id, String ad) {
		super();
		this.id = id;
		this.ad = ad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.ad;
	}
}
