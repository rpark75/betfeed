package org.bet.app.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stats")
public class StatsEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String site;

	@Column
	private String url;

	@Column
	private Date date;

	@Column
	private String oddType;

	@Column
	private Number ratio;

	public StatsEntity() {
		super();
	}

	public StatsEntity(String site, String url, Date date, String oddType, Number ratio) {
		super();
		this.site = site;
		this.url = url;
		this.date = date;
		this.oddType = oddType;
		this.ratio = ratio;
	}

	public StatsEntity(int id, String site, String url, Date date, String oddType, Number ratio) {
		super();
		this.id = id;
		this.site = site;
		this.url = url;
		this.date = date;
		this.oddType = oddType;
		this.ratio = ratio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOddType() {
		return oddType;
	}

	public void setOddType(String oddType) {
		this.oddType = oddType;
	}

	public Number getRatio() {
		return ratio;
	}

	public void setRatio(Number ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "StatsEntity [id=" + id + ", site=" + site + ", url=" + url + ", date=" + date + ", oddType=" + oddType
				+ ", ratio=" + ratio + "]";
	}

}
