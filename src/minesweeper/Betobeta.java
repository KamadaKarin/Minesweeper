package minesweeper;

public class Betobeta extends Pokemon{
	public Betobeta(Gui gui,Timer timer){
		super(gui,timer);
		
		String[] attackName = {"ヘドロ","はたく","どくガス","スモッグ"};
		String[] attackType = {"通常","通常","どく","どく"};
		int[] attackDamage = {65,40,0,0};
		
		super.setName("ベトベター");
		super.setType1("どく");
		super.setAttack(attackName);
		super.setAttackType(attackType);
		super.setAttackDamage(attackDamage);
		super.setPower(25);
		super.setVitality(140);
	}
}
