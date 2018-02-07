package org.bet.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "football")
public class FootballMatchEntity {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String league;

	@Column
	private String match;

	@Column
	private int sort1;

	@Column
	private int sortX;

	@Column
	private int sort2;

	@Column
	private boolean sortSuccess;

	@Column
	private boolean tipSuccess;

	@Column
	private double odd1;

	@Column
	private double oddX;

	@Column
	private double odd2;

	@Column
	private int over50odd;

	@Column
	private int under50odd;

	@Column
	private boolean goalsOdd;

	@Column
	private String site;

	public FootballMatchEntity() {
		super();
	}

	public FootballMatchEntity(String league, String match, int sort1, int sortX, int sort2, boolean sortSuccess,
			boolean tipSuccess, double odd1, double oddX, double odd2, int over50odd, int under50odd, boolean goalsOdd,
			String site) {
		super();
		this.league = league;
		this.match = match;
		this.sort1 = sort1;
		this.sortX = sortX;
		this.sort2 = sort2;
		this.sortSuccess = sortSuccess;
		this.tipSuccess = tipSuccess;
		this.odd1 = odd1;
		this.oddX = oddX;
		this.odd2 = odd2;
		this.over50odd = over50odd;
		this.under50odd = under50odd;
		this.goalsOdd = goalsOdd;
		this.site = site;
	}

	public FootballMatchEntity(int id, String league, String match, int sort1, int sortX, int sort2,
			boolean sortSuccess, boolean tipSuccess, double odd1, double oddX, double odd2, int over50odd,
			int under50odd, boolean goalsOdd, String site) {
		super();
		this.id = id;
		this.league = league;
		this.match = match;
		this.sort1 = sort1;
		this.sortX = sortX;
		this.sort2 = sort2;
		this.sortSuccess = sortSuccess;
		this.tipSuccess = tipSuccess;
		this.odd1 = odd1;
		this.oddX = oddX;
		this.odd2 = odd2;
		this.over50odd = over50odd;
		this.under50odd = under50odd;
		this.goalsOdd = goalsOdd;
		this.site = site;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public int getSort1() {
		return sort1;
	}

	public void setSort1(int sort1) {
		this.sort1 = sort1;
	}

	public int getSortX() {
		return sortX;
	}

	public void setSortX(int sortX) {
		this.sortX = sortX;
	}

	public int getSort2() {
		return sort2;
	}

	public void setSort2(int sort2) {
		this.sort2 = sort2;
	}

	public boolean isSortSuccess() {
		return sortSuccess;
	}

	public void setSortSuccess(boolean sortSuccess) {
		this.sortSuccess = sortSuccess;
	}

	public boolean isTipSuccess() {
		return tipSuccess;
	}

	public void setTipSuccess(boolean tipSuccess) {
		this.tipSuccess = tipSuccess;
	}

	public double getOdd1() {
		return odd1;
	}

	public void setOdd1(double odd1) {
		this.odd1 = odd1;
	}

	public double getOddX() {
		return oddX;
	}

	public void setOddX(double oddX) {
		this.oddX = oddX;
	}

	public double getOdd2() {
		return odd2;
	}

	public void setOdd2(double odd2) {
		this.odd2 = odd2;
	}

	public int getOver50odd() {
		return over50odd;
	}

	public void setOver50odd(int over50odd) {
		this.over50odd = over50odd;
	}

	public int getUnder50odd() {
		return under50odd;
	}

	public void setUnder50odd(int under50odd) {
		this.under50odd = under50odd;
	}

	public boolean isGoalsOdd() {
		return goalsOdd;
	}

	public void setGoalsOdd(boolean goalsOdd) {
		this.goalsOdd = goalsOdd;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "FootballMatchEntity [id=" + id + ", league=" + league + ", match=" + match + ", sort1=" + sort1
				+ ", sortX=" + sortX + ", sort2=" + sort2 + ", sortSuccess=" + sortSuccess + ", tipSuccess="
				+ tipSuccess + ", odd1=" + odd1 + ", oddX=" + oddX + ", odd2=" + odd2 + ", over50odd=" + over50odd
				+ ", under50odd=" + under50odd + ", goalsOdd=" + goalsOdd + ", site=" + site + "]";
	}

}
