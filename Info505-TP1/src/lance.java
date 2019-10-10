import main.Tableau;

public class lance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tableau newTab = new Tableau();
		Tableau tab = new Tableau();
		tab.initialisation();
		newTab.initialisation();
		tab.setValeurs(0, 2);
		tab.setValeurs(1, 4);
		tab.setValeurs(2, 5);
		tab.setValeurs(3, 7);
		tab.setValeurs(5, 4);
		tab.rotaDroite(newTab);
		newTab.contenuTab();
	}
}
