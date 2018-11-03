package PAL_v3;

import java.io.IOException;

public class main {

	String name;
	int Level, maxHP, maxMP, HP, MP;
	static int money = 0;
	static int x = 0, y = 0;
	static String now;

	static main XiaoYao = new main("李逍遙", 1, 200, 50);
	static main LingEr = new main("趙靈兒", 5, 160, 80);
	static main YueRu = new main("林月如", 8, 180, 60);

	public main() {
	};

	public main(int maxHP, int maxMP) {
		this.maxHP += HP;
		this.maxMP += MP;
		this.Level += 1;
	};

	public main(String name, int Level, int maxHP, int maxMP) {
		this.name = name;
		this.Level = Level;
		this.maxHP = maxHP;
		this.maxMP = maxMP;
		this.HP = this.maxHP;
		this.MP = this.maxMP;
	};

	void LevelUp() {
		this.Level += 1;
		this.maxHP = (int) (this.maxHP * 1.1);
		this.maxMP = (int) (this.maxMP * 1.1);
		this.HP = this.maxHP;
		this.MP = this.maxMP;
		System.out.println(name + "\tLevel=" + this.Level + "\tHP=" + this.maxHP + "\tMP=" + this.maxMP + "\tLevelUp");
	};

	void LevelJump(int Level) {
		this.Level += Level;
		for (int i = 0; i < Level; i++) {
			this.maxHP = (int) (this.maxHP * 1.1);
			this.maxMP = (int) (this.maxMP * 1.1);
		}
		this.HP = this.maxHP;
		this.MP = this.maxMP;
		System.out.println(name + "\tLevel=" + this.Level + "\tHP=" + this.maxHP + "\tMP=" + this.maxMP + "\tLevelUp");
	};

	void satus() {
		System.out.println(this.name + "\tLevel=" + this.Level + "\tHP=" + this.HP + "\tMP=" + this.MP);
	};

	void varmaxHP(int maxHP) {
		this.maxHP += maxHP;
	};

	void varmaxMP(int maxMP) {
		this.maxMP += maxMP;
	};

	void varHP(int HP) {
		this.HP -= HP;
	};

	void varMP(int MP) {
		this.MP -= MP;
	};

	public static void main(String[] args) throws IOException {
//		Scene.Scene1();
//		System.out.println("");
//		Action.Action1();

		XiaoYao.satus();
		XiaoYao.LevelUp();
		XiaoYao.LevelJump(3);
		XiaoYao.varHP(6);
		XiaoYao.satus();
	}
}
