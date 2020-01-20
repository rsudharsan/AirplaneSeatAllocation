package com.asc.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.asc.pojo.Seat;
import com.asc.pojo.SeatType;
import com.asc.pojo.Section;

public class SeatGenerator {

	public static List<Section> generateSeats(ArrayList<int[]> sections) {
		
		// each array is a section---create seat objects per section
	// Section -> contains hashmap of seats - key is row value list of seats
		//S1 [[1, {s11,s12}],[2, {s21,s22}],[3, {s31,s32}]]
		System.out.println("Generating seat configuration...");
		ArrayList<Section> sectionList = new ArrayList<Section>();
		int sectionNum = 1;
		for(int[] section: sections) {
			//System.out.println("---");
			Section sectionObj = new Section();
			sectionObj.setSeatMap(new HashMap<>());
			sectionList.add(sectionObj);
			ArrayList<Seat> seatList = new ArrayList<Seat>();
			int numRows = section[0],numColumns = section[1],totalSeats = numRows*numColumns;
			int rowNum = 1,columnNum = 1,currColumnCount = 1;
			sectionObj.setTotalSeats(totalSeats);
			
			for(int i=0; i<totalSeats;i++) {
				if(currColumnCount>numColumns) {
					sectionObj.getSeatMap().put(rowNum, seatList);
					rowNum++ ;
					currColumnCount=1;columnNum=1;
					seatList = new ArrayList<Seat>();
				} 
				Seat seat = new Seat();
				seat.setRowNum(rowNum).setColumnNum(columnNum).setSeatNum("S"+sectionNum+"-"+(rowNum)+"-"+columnNum);
				
				if(sectionList.size()==1) {
					if(columnNum == 1) {
						seat.setType(SeatType.WINDOW);
					}else if (columnNum == numColumns){
						seat.setType(SeatType.AISLE);
					}else{
						seat.setType(SeatType.MIDDLE);
					}
					
				}else if(sectionList.size() == sections.size()) {
					if(columnNum == 1) {
						seat.setType(SeatType.AISLE);
					}else if (columnNum == numColumns){
						seat.setType(SeatType.WINDOW);
					}else{
						seat.setType(SeatType.MIDDLE);
					}
					
				}else {
					if(columnNum == 1) {
						seat.setType(SeatType.AISLE);
					}else if (columnNum == numColumns){
						seat.setType(SeatType.AISLE);
					}else{
						seat.setType(SeatType.MIDDLE);
					}
					
				}
				
				//set window,aisle or middle indicators
				
				
				
				
				seatList.add(seat);
				currColumnCount++;
				columnNum++;
				//System.out.println(seat.toString());
			}
			sectionObj.getSeatMap().put(rowNum, seatList);
			sectionNum++;
		}
		return sectionList;
		
	}

}
