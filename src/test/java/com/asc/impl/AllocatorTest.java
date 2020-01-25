package com.asc.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.asc.pojo.Seat;
import com.asc.pojo.Section;



class AllocatorTest {

	
	
	@Test
	void TestAllocationPrefAisleWindowMiddle() {
ArrayList<int[]> sections = new ArrayList<int[]>();
		
		int[] test = {1,3};
		sections.add(test);
		List<Section> output = SeatGenerator.generateSeats(sections);
		Allocator.allocate(output, 3);
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		//assert aisle => 1
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(2).getOccupiedByID()==1);
		//assert window => 2
		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(0).getOccupiedByID()==2);
		//assert middle=> 3
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==3);
	}
	
	@Test
	void TestAllocationOrderLeftRight() {
ArrayList<int[]> sections = new ArrayList<int[]>();
		
		int[] firstSection = {1,3};
		int[] secondSection = {1,3};
		/*assert order
		 * seat generation
		 * window middle aisle | aisle middle window
		 * no. of passengers - 6
		 *     3     5       1  |    2    6  4
		 * */
		sections.add(firstSection);sections.add(secondSection);
		List<Section> output = SeatGenerator.generateSeats(sections);
		Allocator.allocate(output, 6);
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		ArrayList<Seat> currrow = iter.next().getValue();
		
		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(0).getOccupiedByID()==3);
		
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==5);
	
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(2).getOccupiedByID()==1);
	
		
		curr = output.get(1);
		iter = curr.getSeatMap().entrySet().iterator();
		currrow = iter.next().getValue();
		
		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(0).getOccupiedByID()==2);
	
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(2).getOccupiedByID()==4);
		
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==6);
	}
	
	@Test
	void TestAllocationOrderTopDown() {
ArrayList<int[]> sections = new ArrayList<int[]>();
		
		int[] firstSection = {2,3};
		int[] secondSection = {2,3};
		/*assert order
		 * seat generation
		 * window middle aisle | aisle middle window
		 * window middle aisle | aisle middle window
		 * no. of passengers - 12
		 *     5     9       1  |    2    10  6
		 *     7     11      3       4    12  8
		 * */
		sections.add(firstSection);sections.add(secondSection);
		List<Section> output = SeatGenerator.generateSeats(sections);
		Allocator.allocate(output, 12);
		Section curr = output.get(0);
		Iterator<Entry<Integer, ArrayList<Seat>>> iter = curr.getSeatMap().entrySet().iterator();
		//1st section 1st row
		ArrayList<Seat> currrow = iter.next().getValue();

		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(0).getOccupiedByID()==5);
		
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==9);
		
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(2).getOccupiedByID()==1);
		//1st section 2nd row
		currrow = iter.next().getValue();

		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(0).getOccupiedByID()==7);
		
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==11);
		
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(2).getOccupiedByID()==3);
	
		
		curr = output.get(1);
		iter = curr.getSeatMap().entrySet().iterator();
		//2nd section 1st row
		currrow = iter.next().getValue();
		
		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(0).getOccupiedByID()==2);
	
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==10);
		
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(2).getOccupiedByID()==6);
		
		//2nd section 2nd row
		currrow = iter.next().getValue();
		
		Assert.assertTrue("not occupied",currrow.get(0).isOccupied());
		Assert.assertTrue("not occupied aisle",currrow.get(0).getOccupiedByID()==4);
	
		Assert.assertTrue("not occupied",currrow.get(1).isOccupied());
		Assert.assertTrue("not occupied middle",currrow.get(1).getOccupiedByID()==12);
		
		Assert.assertTrue("not occupied",currrow.get(2).isOccupied());
		Assert.assertTrue("not occupied window",currrow.get(2).getOccupiedByID()==8);
		
	}
	
	}
