package com.asc.pojo;

import java.util.ArrayList;
import java.util.HashMap;

public class Section {

	private HashMap<Integer, ArrayList<Seat>> SeatMap;
	private int totalSeats;

	public HashMap<Integer, ArrayList<Seat>> getSeatMap() {
		return SeatMap;
	}

	public void setSeatMap(HashMap<Integer, ArrayList<Seat>> seatMap) {
		SeatMap = seatMap;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "Section [SeatMap=" + SeatMap + ", totalSeats=" + totalSeats + "]\n";
	}
	
	
}
