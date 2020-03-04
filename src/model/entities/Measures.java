package model.entities;

public class Measures {

	private Integer infoId;
	private String dateReg;
	private Double weight;
	private Double bodyFat;
	private Double bicepsRight;
	private Double bicepsLeft;
	private Double shoulders;
	private Double chest;
	private Double waist;
	private Double thighRight;
	private Double thighLeft;
	private Double calfRight;
	private Double calfLeft;
	private User user;
	
	public Measures() {
	}

	public Measures(Integer infoId, String dateReg, Double weight, Double bodyFat, Double bicepsRight, Double bicepsLeft,
			Double shoulders, Double chest, Double waist, Double thighRight, Double thighLeft, Double calfRight,
			Double calfLeft, User user) {
		super();
		this.infoId = infoId;
		this.dateReg = dateReg;
		this.weight = weight;
		this.bodyFat = bodyFat;
		this.bicepsRight = bicepsRight;
		this.bicepsLeft = bicepsLeft;
		this.shoulders = shoulders;
		this.chest = chest;
		this.waist = waist;
		this.thighRight = thighRight;
		this.thighLeft = thighLeft;
		this.calfRight = calfRight;
		this.calfLeft = calfLeft;
		this.user = user;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getDateReg() {
		return dateReg;
	}

	public void setDateReg(String dateReg) {
		this.dateReg = dateReg;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(Double bodyFat) {
		this.bodyFat = bodyFat;
	}

	public Double getBicepsRight() {
		return bicepsRight;
	}

	public void setBicepsRight(Double bicepsRight) {
		this.bicepsRight = bicepsRight;
	}

	public Double getBicepsLeft() {
		return bicepsLeft;
	}

	public void setBicepsLeft(Double bicepsLeft) {
		this.bicepsLeft = bicepsLeft;
	}

	public Double getShoulders() {
		return shoulders;
	}

	public void setShoulders(Double shoulders) {
		this.shoulders = shoulders;
	}

	public Double getChest() {
		return chest;
	}

	public void setChest(Double chest) {
		this.chest = chest;
	}

	public Double getWaist() {
		return waist;
	}

	public void setWaist(Double waist) {
		this.waist = waist;
	}

	public Double getThighRight() {
		return thighRight;
	}

	public void setThighRight(Double thighRight) {
		this.thighRight = thighRight;
	}

	public Double getThighLeft() {
		return thighLeft;
	}

	public void setThighLeft(Double thighLeft) {
		this.thighLeft = thighLeft;
	}

	public Double getCalfRight() {
		return calfRight;
	}

	public void setCalfRight(Double calfRight) {
		this.calfRight = calfRight;
	}

	public Double getCalfLeft() {
		return calfLeft;
	}

	public void setCalfLeft(Double calfLeft) {
		this.calfLeft = calfLeft;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infoId == null) ? 0 : infoId.hashCode());
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
		Measures other = (Measures) obj;
		if (infoId == null) {
			if (other.infoId != null)
				return false;
		} else if (!infoId.equals(other.infoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Measures [infoId=" + infoId + ", dateReg=" + dateReg + ", weight=" + weight + ", bodyFat=" + bodyFat
				+ ", bicepsRight=" + bicepsRight + ", bicepsLeft=" + bicepsLeft + ", shoulders=" + shoulders
				+ ", chest=" + chest + ", waist=" + waist + ", thighRight=" + thighRight + ", thighLeft=" + thighLeft
				+ ", calfRight=" + calfRight + ", calfLeft=" + calfLeft + ", user=" + user + "]";
	}
}
