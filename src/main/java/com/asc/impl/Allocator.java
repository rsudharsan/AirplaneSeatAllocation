package com.asc.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.asc.pojo.Seat;
import com.asc.pojo.SeatType;
import com.asc.pojo.Section;

public class Allocator {

	public static void allocate(List<Section> seating, int noOfPassengers) {
		
		int populatedCount = 0;
		int startingNumber = 1;
		int totalRows = getHighestRow(seating);
		//if noOfPassengers more than total seats - throw allocation error
		if(noOfPassengers> getTotalSeats(seating)) {
			System.out.println("no of passengers is more than total seats");
			System.exit(0);
		}
		
		while(startingNumber < noOfPassengers) {
			//fill aisle in each section
			populatedCount = PopulateSeating(seating,SeatType.AISLE,startingNumber,totalRows,noOfPassengers);
			startingNumber= startingNumber+populatedCount;
			if(startingNumber >= noOfPassengers) break;
			// fill window in each section
			populatedCount = PopulateSeating(seating,SeatType.WINDOW,startingNumber,totalRows,noOfPassengers);
			startingNumber= startingNumber+populatedCount;
			if(startingNumber >= noOfPassengers) break;
			//fill middle in each section
			populatedCount = PopulateSeating(seating,SeatType.MIDDLE,startingNumber,totalRows,noOfPassengers);
			startingNumber= startingNumber+populatedCount;
		}
	}

	private static int getTotalSeats(List<Section> seating) {
		int totalSeats = 0;
		for(Section section:seating) {
			HashMap<Integer, ArrayList<Seat>> seatMap = section.getSeatMap();
		    Iterator<Entry<Integer, ArrayList<Seat>>> iter = seatMap.entrySet().iterator();
			while(iter.hasNext()) {
				Entry<Integer, ArrayList<Seat>> currItem = iter.next();
				//System.out.println(currItem.getKey()+""+currItem.getValue().toString());
				totalSeats = totalSeats+ currItem.getValue().size();
			}
		}
		return totalSeats;
	}

	private static int getHighestRow(List<Section> seating) {
		int highestRow = 0;
		for(Section section: seating) {
			if(section.getSeatMap().size()>highestRow) {
				highestRow = section.getSeatMap().size();
			}
		}
		return highestRow;
	}
//for each section - get the row and set that seat type to occupied
	private static int PopulateSeating(List<Section> seating, SeatType type, int startingNumber, int totalRows, int noOfPassengers) {
		int popCount = 0;
		for(int i = 1; i<= totalRows; i++) {
			int currRow = i;
			for(Section section:seating) {
				ArrayList<Seat> currSeatList = section.getSeatMap().get(currRow);
				if(currSeatList == null)continue;
				if(startingNumber>noOfPassengers) return popCount;
				for(Seat seat:currSeatList) {
					if(seat.getType().equals(type) && !seat.isOccupied()) {
						seat.setOccupied(true);
						seat.setOccupiedByID(startingNumber);
						popCount++;
						startingNumber++;
						if(startingNumber>noOfPassengers) return popCount;
					}
				}
			}
		}
		return popCount;
	}

	
	

}
