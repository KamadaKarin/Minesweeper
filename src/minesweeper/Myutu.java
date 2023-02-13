package minesweeper;

public class Myutu extends Pokemon{
	public Myutu(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"サイコブレイク","かみなり","ぼうふう","シャドーボール"};
		String[] attackType = {"通常","通常","通常+こんらん","通常"};
		int[] attackDamage = {100,110,110,80};
		
		super.setName("ミュウツー");
		super.setType1("エスパー");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(80);
		super.setVitality(140);
	}
}
