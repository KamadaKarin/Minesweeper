package minesweeper;

public class Girathina extends Pokemon{
	public Girathina(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"ドラゴンクロー","りゅうせいぐん","はどうだん","おにび"};
		String[] attackType = {"通常","通常","通常","やけど"};
		int[] attackDamage = {80,130,80,0};
		
		super.setName("ギラティナ");
		super.setType1("ドラゴン");
		super.setType2("ゴースト");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(80);
		super.setVitality(140);
	}
}
