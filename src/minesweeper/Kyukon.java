package minesweeper;

public class Kyukon extends Pokemon{
	public Kyukon(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"だいもんじ","かえんほうしゃ","しねんのずつき","おにび"};
		String[] attackType = {"通常","通常","通常","やけど"};
		int[] attackDamage = {110,90,80,0};
		
		super.setName("キュウコン");
		super.setType1("ほのお");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(50);
		super.setVitality(140);
	}
}
