package pl.edu.pg.eti.ksg.po.lab1;


public class Main {

    public static void main(String[] args) {
    	//brak			HashSet
		//natural		TreeSet
		//alternatywa	TreeSet with condition
		String method = "natural";

		Mage mage1 = new Mage("Albus", 1, 2, method);
		Mage mage2 = new Mage("Ban", 2, 3, method);
		Mage mage3 = new Mage("Cattle", 3, 4, method);
		Mage mage4 = new Mage("Denny", 4, 5, method);
		Mage mage5 = new Mage("Errosion", 5, 6, method);
		Mage mage6 = new Mage("Forgotten", 6, 7, method);
		Mage mage7 = new Mage("Goblin", 7, 8, method);
		Mage mage8 = new Mage("Humple", 8, 9, method);
		Mage mage9 = new Mage("Irracle", 9, 10, method);
		Mage mage10 = new Mage("Jiordan", 774, 11, method);

		mage1.addApprentice(mage2);
		mage1.addApprentice(mage3);
		mage1.addApprentice(mage4);
		mage4.addApprentice(mage5);
		mage5.addApprentice(mage6);
		mage6.addApprentice(mage7);
		mage1.addApprentice(mage8);
		mage1.addApprentice(mage9);
		mage1.addApprentice(mage10);

		mage1.print(1);
		System.out.println("mage1 apprenticeCounter = " + mage1.apprenticeCounter());
	}
}
