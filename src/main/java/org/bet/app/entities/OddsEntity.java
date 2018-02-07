package org.bet.app.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "odds")
public class OddsEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String site;

	@Column
	private Date date;

	@Column
	private String type;

	@Column
	private ArrayList<Integer> odds;

	@Column
	private ArrayList<Integer> result;

	@Column
	private Number ratio;

	@Column
	private Date majDate;

	public OddsEntity() {
		super();
	}

	public OddsEntity(String site, Date date, String type, ArrayList<Integer> odds, ArrayList<Integer> result,
			Number ratio, Date majDate) {
		super();
		this.site = site;
		this.date = date;
		this.type = type;
		this.odds = odds;
		this.result = result;
		this.ratio = ratio;
		this.majDate = majDate;
	}

	public OddsEntity(int id, String site, Date date, String type, ArrayList<Integer> odds, ArrayList<Integer> result,
			Number ratio, Date majDate) {
		super();
		this.id = id;
		this.site = site;
		this.date = date;
		this.type = type;
		this.odds = odds;
		this.result = result;
		this.ratio = ratio;
		this.majDate = majDate;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Integer> getOdds() {
		return odds;
	}

	public void setOdds(ArrayList<Integer> odds) {
		this.odds = odds;
	}

	public ArrayList<Integer> getResult() {
		return result;
	}

	public void setResult(ArrayList<Integer> result) {
		this.result = result;
	}

	public Number getRatio() {
		return ratio;
	}

	public void setRatio(Number ratio) {
		this.ratio = ratio;
	}

	public Date getMajDate() {
		return majDate;
	}

	public void setMajDate(Date majDate) {
		this.majDate = majDate;
	}

	@Override
	public String toString() {
		return "OddsEntity [id=" + id + ", site=" + site + ", date=" + date + ", type=" + type + ", odds=" + odds
				+ ", result=" + result + ", ratio=" + ratio + ", majDate=" + majDate + "]";
	}

}
