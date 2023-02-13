package minesweeper;

public class Hikozaru extends Pokemon{
	public Hikozaru(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"かえんぐるま","ひのこ","ひっかく","おにび"};
		String[] attackType = {"通常","通常","通常","やけど"};
		int[] attackDamage = {40,40,60,0};
		
		super.setName("ヒコザル");
		super.setType1("ほのお");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(20);
		super.setVitality(15);
	}
}
