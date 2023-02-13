package minesweeper;

public class Item {
	private boolean medicineItemJudge = false;
	private boolean openItemJudge = false;
	private boolean cureItemJudge = false;
	
	public boolean getMedicineItemJudge() {
		return this.medicineItemJudge;
	}
	
	public void setMedicineItemJudge(boolean medicineItemJudge) {
		this.medicineItemJudge = medicineItemJudge;
	}
	
	public boolean getOpenItemJudge() {
		return this.openItemJudge;
	}
	
	public void setOpenItemJudge(boolean openItemJudge) {
		this.openItemJudge = openItemJudge;
	}

	public boolean getCureItemJudge() {
		return cureItemJudge;
	}

	public void setCureItemJudge(boolean cureItemJudge) {
		this.cureItemJudge = cureItemJudge;
	}
}
