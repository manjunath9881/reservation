package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TBL_RESERVATION_TABLE")
public class TableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "seats")
	private Integer seats;

	@Column(name = "is_reservable")
	private Boolean isReservable;

	@Column(name = "seat_cordinates")
	private String seatCordinates;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private ReservationEntity reservationEntity;

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getSeatCordinates() {
		return seatCordinates;
	}

	public void setSeatCordinates(String seatCordinates) {
		this.seatCordinates = seatCordinates;
	}

	public Boolean getIsReservable() {
		return isReservable;
	}

	public void setIsReservable(Boolean isReservable) {
		this.isReservable = isReservable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TableEntity [id=" + id + ", seats=" + seats + ", seatCordinates=" + seatCordinates + ", isReservable="
				+ isReservable + "]";
	}

	public ReservationEntity getReservationEntity() {
		return reservationEntity;
	}

	public void setReservationEntity(ReservationEntity reservationEntity) {
		this.reservationEntity = reservationEntity;
	}
}
