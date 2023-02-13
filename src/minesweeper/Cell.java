package minesweeper;

public class Cell {//1つのマスの情報
	private boolean flagJudge = false;//旗が立っているか判定
	private boolean bombJudge = false;//爆弾があるか判定
	private boolean medicineItemJudge = false;//キズぐすり
	private boolean openItemJudge = false;//マスを開けるアイテム
	private boolean cureItemJudge = false;
	private boolean openJudge = false;//マスが空いているか判定
	private int aroundBombNum = 0;//周りの爆弾数
	
	public boolean getFlag() {
		return this.flagJudge;
	}
	
	public void setFlag(boolean flagJudge) {
		this.flagJudge = flagJudge;
	}
	
	public boolean getBomb() {
		return this.bombJudge;
	}
	
	public void setBomb(boolean bombJudge) {
		this.bombJudge = bombJudge;
	}
	
	public int getBombCount() {
		return this.aroundBombNum;
	}
	
	public void setBombCount() {
		aroundBombNum = aroundBombNum + 1;
	}
	
	public boolean getOpenJudge() {
		return this.openJudge;
	}
	
	public void setOpenJudge(boolean openJudge) {
		this.openJudge = openJudge;
	}
	
	public void resetBomb() {//爆弾と爆弾数をリセット
		bombJudge = false;
		aroundBombNum = 0;
	}
	
	public boolean getMedicineItem() {
		return this.medicineItemJudge;
	}
	
	public void setMedicineItem(boolean medicineItemJudge) {
		this.medicineItemJudge = medicineItemJudge;
	}

	public boolean getOpenItem() {
		return this.openItemJudge;
	}

	public void setOpenItem(boolean openItemJudge) {
		this.openItemJudge = openItemJudge;
	}

	public boolean getCureItem() {
		return cureItemJudge;
	}

	public void setCureItem(boolean cureItemJudge) {
		this.cureItemJudge = cureItemJudge;
	}
}
