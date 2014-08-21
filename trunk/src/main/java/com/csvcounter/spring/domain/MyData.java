package com.csvcounter.spring.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="myData")
public class MyData {
	
	@Id 
	@Column(name = "id")
	Integer id;
	
	@Column(name = "data", length = 255)
	private String data;
	
	@Column(name = "record_created_date", nullable = false)
	private Date recordCreatedDate;
	
	public MyData() {
		recordCreatedDate = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Date getRecordCreatedDate() {
		return recordCreatedDate;
	}

	public void setRecordCreatedDate(Date recordCreatedDate) {
		this.recordCreatedDate = recordCreatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((recordCreatedDate == null) ? 0 : recordCreatedDate
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyData other = (MyData) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (recordCreatedDate == null) {
			if (other.recordCreatedDate != null)
				return false;
		} else if (!recordCreatedDate.equals(other.recordCreatedDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MyData [id=" + id + ", data=" + data + ", recordCreatedDate=" + recordCreatedDate + "]";
	}
}
