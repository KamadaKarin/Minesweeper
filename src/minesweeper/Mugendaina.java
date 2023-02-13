package minesweeper;

public class Mugendaina extends Pokemon{
	public Mugendaina(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"ダイマックスほう","かえんほうしゃ","シャドーボール","ヘドロばくだん"};
		String[] attackType = {"通常","通常","通常","通常+どく"};
		int[] attackDamage = {100,90,90,80};
		
		super.setName("ムゲンダイナ");
		super.setType1("ドラゴン");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(80);
		super.setVitality(140);
	}
}
