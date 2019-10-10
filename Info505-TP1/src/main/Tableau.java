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
	
	public void setValeurs(int rang, int element){
		this.valeurs.set(rang, element);
	}
	
	public void addValeurs(int element) {
		this.valeurs.add(element);
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
			if (valeurs.get(i)==null){
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
		if (getValeurs() == null) {
			return max;
		}
		else {
			while(getValeurs().get(i)!=null) {
				
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

	
	public void contenuTab() {
		System.out.print(getValeurs().get(0));
	}
}

