package minesweeper;

public class Churine extends Pokemon{
	public Churine(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"エナジーボール","マジカルリーフ","しびれごな","ねむりごな"};
		String[] attackType = {"通常","通常","まひ","ねむり"};
		int[] attackDamage = {60,90,0,0};
		
		super.setName("チュリネ");
		super.setType1("くさ");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(15);
		super.setVitality(140);
	}
}
