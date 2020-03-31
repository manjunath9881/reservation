package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_RESERVE")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Long reservationId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "reserved_by")
	private String reservedBy;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "id")
	private Long id;	
	
	
	@Column(name = "reserved_date")
    private String reservedDdate;
	
	@OneToMany(targetEntity = TableEntity.class, mappedBy = "id", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<TableEntity> tableEntity;


	public Long getReservationId() {
		return reservationId;
	}


	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getReservedBy() {
		return reservedBy;
	}


	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getReservedDdate() {
		return reservedDdate;
	}


	public void setReservedDdate(String reservedDdate) {
		this.reservedDdate = reservedDdate;
	}
	
	  @Override
	    public String toString() {
	        return "ReservationEntity [reservationId=" + reservationId + ", firstName=" + firstName + 
	                ", reservedBy=" + reservedBy + ", email=" + email   + " ,  phone=" + phone + " ,  id=" + id +  " ,  reservedDdate=" + reservedDdate + "]";
	    }


	public Set<TableEntity> getTableEntity() {
		return tableEntity;
	}


	public void setTableEntity(Set<TableEntity> tableEntity) {
		this.tableEntity = tableEntity;
	}

}
