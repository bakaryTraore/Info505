package main;
import constantes.Constantes;
import java.util.ArrayList;

public class Tableau {
	//attributs
	private ArrayList<Integer> valeurs;
	
	//méthodes
	
	public Tableau() {
		this.valeurs = new ArrayList<Integer>();
	}
	
	public void initialisation()
	{
		for (int i = 0; i < Constantes.TABMAX; i++)
		{
			this.valeurs.add(0);
		}
	}
	
	public void setValeurs(int rang, int element){
		this.valeurs.set(rang, element); //si élément au rang (i-1)/2 = 0, renvoyer erreur
	}
	
	public void addValeurs(int element) {
		this.valeurs.add(element); //si premier élément = 0, remplacer le 0 par l'élément
	}
	
	public ArrayList<Integer> getValeurs(){
		return this.valeurs;
	}
	
	public int getTaille() {
		return this.getValeurs().size();
	}
	
	public void ajoutAVL(int element) {
		boolean trouve = false;
		int i = 0;
		while(i<this.getTaille() || trouve) {
			if (valeurs.get(i)==0){
				valeurs.set(i, element);
				trouve = true;
			}
			if (element<valeurs.get(i)) {
				i = 2*i+1;
			}
			else {
				i = 2*i+2;
			}
		}
	}
	
	public int hauteurMax() {
		int i = 0;
		int max = 0;
		if (getValeurs().get(0) == 0) {
			return max;
		}
		else {
			while(i < getValeurs().size()-1) {
				if (getValeurs().get(i) != 0)
					{
					max = i;
					}
				i++;
			}
			return max;
		}
	}
	
	public void afficheArbre() {
		int i = 0;
		int j = 1;
		while(i<getTaille()) {
			if (i==j-1) {
				System.out.print("       ");
				System.out.println(getValeurs().get(i));
				j = j*j;
			}
			else{
				System.out.print("       ");
				System.out.print(getValeurs().get(i));
			}
			i++;
		}
	}

	public Tableau recopierTab(Tableau newTab, int rangTab1, int rangTab2)
	{
		if(getValeurs().get(rangTab1) != 0)
		{
			newTab.setValeurs(rangTab2, this.getValeurs().get(rangTab1));
			this.recopierTab(newTab, (rangTab1*2)+1, (rangTab2*2)+1);
			this.recopierTab(newTab, (rangTab1*2)+2, (rangTab2*2)+2);
		}
		return newTab;
	}
	
	public void rotaDroite(Tableau newTab, int rang)
	{
		newTab.setValeurs(rang, this.getValeurs().get(rang*2+1));
		newTab.setValeurs(rang*2+2, this.getValeurs().get(rang));
		this.recopierTab(newTab, (rang*2+1)*2+1, rang*2+1);
		this.recopierTab(newTab, (rang*2+1)*2+2, (rang*2+2)*2+1);
		this.recopierTab(newTab, rang*2+2, (rang*2+2)*2+2);
		newTab.recopierTab(this, 0, 0);
	}
	
	public void rotaGauche(Tableau newTab, int rang)
	{
		newTab.setValeurs(rang, this.getValeurs().get(rang*2+2));
		newTab.setValeurs(rang*2+1, this.getValeurs().get(rang));
		this.recopierTab(newTab, rang*2+1, (rang*2+1)*2+1);
		this.recopierTab(newTab, (rang*2+2)*2+1, (rang*2+1)*2+2);
		this.recopierTab(newTab, (rang*2+2)*2+2, rang*2+2);
		newTab.recopierTab(this, 0, 0);
	}
	
	public void rotaGD(Tableau newTab, int rang)
	{
		this.rotaGauche(newTab, rang*2+1);
		this.rotaDroite(newTab, rang);
		newTab.recopierTab(this, 0, 0);
	}
		
	public void rotaDG(Tableau newTab, int rang)
	{
		this.rotaDroite(newTab, rang*2+2);
		this.rotaGauche(newTab, rang);
		this.recopierTab(newTab, 0, 0);
	}
	public void contenuTab()
	{
		for (int i = 0; i < this.getTaille(); i++)
		{
		System.out.print(getValeurs().get(i));
		}
	}
}

