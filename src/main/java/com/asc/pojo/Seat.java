package com.asc.pojo;

public class Seat {
	
	private String seatNum;
	private int rowNum;
	private int columnNum;
	private SeatType type;
	private boolean isOccupied;
	private int occupiedByID;
	
	public String getSeatNum() {
		return seatNum;
	}
	public Seat setSeatNum(String seatNum) {
		this.seatNum = seatNum;
		return this;
	}
	public int getRowNum() {
		return rowNum;
	}
	public Seat setRowNum(int rowNum) {
		this.rowNum = rowNum;
		return this;
	}
	public int getColumnNum() {
		return columnNum;
	}
	public Seat setColumnNum(int columnNum) {
		this.columnNum = columnNum;
		return this;
	}
	public SeatType getType() {
		return type;
	}
	public void setType(SeatType type) {
		this.type = type;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public int getOccupiedByID() {
		return occupiedByID;
	}
	public void setOccupiedByID(int occupiedByID) {
		this.occupiedByID = occupiedByID;
	}
	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + ", rowNum=" + rowNum + ", columnNum=" + columnNum + ", type=" + type
				+ ", isOccupied=" + isOccupied + ", occupiedByID="
				+ occupiedByID + "]";
	}
	
	
  
}
