package com.example.demo.dto;

public class TableEntityDTO {
	private Long tableId;
	private Integer availableSeats;
	private String seatCordinates;

	public TableEntityDTO(Long id, Integer seats,String seatCordinates) {
		this.tableId = id;
		this.availableSeats = seats;
		this.seatCordinates = seatCordinates;
	}

	public Long getId() {
		return tableId;
	}

	public void setId(Long id) {
		this.tableId = id;
	}

	@Override
	public String toString() {
		return "TableEntityDTO [tableId=" + tableId + ", availableSeats=" + availableSeats +  ", seatCordinates=" + seatCordinates +"]";
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
}
