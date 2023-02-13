package minesweeper;

public class Zekuromu extends Pokemon{
	public Zekuromu(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"クロスサンダー","ドラゴンクロー","ストーンエッジ","らいげき"};
		String[] attackType = {"通常","通常","通常","通常+まひ"};
		int[] attackDamage = {100,80,100,130};
		
		super.setName("ゼクロム");
		super.setType1("ドラゴン");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(80);
		super.setVitality(140);
	}
}
