package com.asc.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.asc.pojo.Section;
import com.asc.util.CommonUtils;
import com.asc.util.PropertyReader;

public class AllocationImpl {
	
	public static void main(String[] args) throws IOException {
		
		PropertyReader propReader = new PropertyReader("input.properties");
		ArrayList<int[]> input = CommonUtils.getArrayList(propReader.getPropValues("input"));
		int noOfPassengers = Integer.parseInt(propReader.getPropValues("passengerCount"));
	    List<Section> seating = SeatGenerator.generateSeats(input);
	    Allocator.allocate(seating,noOfPassengers);
		for(Section section:seating)System.out.println(section.toString());
	}

}
