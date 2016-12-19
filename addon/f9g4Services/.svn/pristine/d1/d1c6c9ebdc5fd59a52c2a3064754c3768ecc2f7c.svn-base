package com.f9g4.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

@Entity
public class TrActivityScreenGraph implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_stamp", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	@Id
	Calendar eventTimestamp;

	@Column(name = "hit_count", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer hits;
	
	public Calendar getEventTimestamp() {
		return eventTimestamp;
	}

	public void setEventTimestamp(Calendar eventTimestamp) {
		this.eventTimestamp = eventTimestamp;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}
}
