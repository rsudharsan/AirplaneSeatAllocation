package com.asc.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import org.junit.Assert;
import org.junit.Test;

import com.asc.pojo.Seat;
import com.asc.pojo.SeatType;
import com.asc.pojo.Section;

public class SeatGeneratorTest {

	@Test
	public void testSingleSection() {
		
		ArrayList<int[]> sections = new ArrayList<int[]>();
		
		int[] test = {3,4};
		sections.add(test);
		List<Section> output = SeatGenerator.generateSeats(sections);
	    
		Section curr = output.get(0);
		//assert section size is 12 (3*4)
		Assert.assertTrue("section size mismatch", curr.getTotalSeats() == 12);
		
		/* 3rows 4columns
		 * assert following seat structure
		 *  window | middle | middle | aisle
		 * 
		 * */
		
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		//assert first row has only 4 seats
		Assert.assertTrue("row seat mismatch", currrow.size() == 4);
		//assert seat type
		//1.window
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.WINDOW));
		System.out.println(currrow.get(0).toString());
		//2.middle
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.MIDDLE));
		System.out.println(currrow.get(1).toString());
		//3.middle
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(2).getType().equals(SeatType.MIDDLE));
		System.out.println(currrow.get(2).toString());
		//4.window
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(3).getType().equals(SeatType.AISLE));
		System.out.println(currrow.get(3).toString());
	}
	
	@Test
    public void testSingleSectionWithoutMiddle() {
    	
    	ArrayList<int[]> sections = new ArrayList<int[]>();
		int[] test = {3,2};
		sections.add(test);
		List<Section> output = SeatGenerator.generateSeats(sections);
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		//assert first row has only 4 seats
		Assert.assertTrue("row seat mismatch", currrow.size() == 2);
		//assert seat type
		//1.window
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.WINDOW));
		System.out.println(currrow.get(0).toString());
		//2.middle
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.AISLE));
		System.out.println(currrow.get(1).toString());
    }
	
	@Test
    public void testmultiSectionWithMiddle() {
		ArrayList<int[]> sections = new ArrayList<int[]>();
		int[] firstSection = {1,3};
		int[] secondSection = {1,3};
		int[] thirdSection = {1,3};
		sections.add(firstSection);sections.add(secondSection);sections.add(thirdSection);
		List<Section> output = SeatGenerator.generateSeats(sections);
		/*
		 *assert following seat structure
		 *
		 * window middle aisle || aisle middle aisle || aisle middle window
		 * 
		 * */
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		//assert seat type 1
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.WINDOW));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.MIDDLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(2).getType().equals(SeatType.AISLE));
		
		curr = output.get(1);
		iter = curr.getSeatMap().entrySet().iterator();
		currrow = iter.next().getValue();
		//assert seat type 2
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.AISLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.MIDDLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(2).getType().equals(SeatType.AISLE));
		
		curr = output.get(2);
		iter = curr.getSeatMap().entrySet().iterator();
		currrow = iter.next().getValue();
		//assert seat type 3
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.AISLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.MIDDLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(2).getType().equals(SeatType.WINDOW));
	}
	
	@Test
    public void testTwoSectionsWithoutMiddle() {
		ArrayList<int[]> sections = new ArrayList<int[]>();
		int[] firstSection = {1,2};
		int[] secondSection = {1,2};
		sections.add(firstSection);sections.add(secondSection);
		List<Section> output = SeatGenerator.generateSeats(sections);
		/*
		 *assert following seat structure
		 *
		 * window aisle || aisle window
		 * 
		 * */
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		//assert seat type 1
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.WINDOW));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.AISLE));
	
		
		curr = output.get(1);
		iter = curr.getSeatMap().entrySet().iterator();
		currrow = iter.next().getValue();
		//assert seat type 2
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(0).getType().equals(SeatType.AISLE));
		Assert.assertTrue("incorrect aisle/window generation",currrow.get(1).getType().equals(SeatType.WINDOW));
		
	}
}
