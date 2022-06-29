import java.util.ArrayList;

public class Panier {
	public ArrayList<Product> panier;
	public Panier() {
		panier=new ArrayList<Product>();
	}
	public void addToBasket(Product p) {
		panier.add(p);
	}
	public ArrayList<Product>listeProduct(){
		return panier;
	}
	public void removeFromBasket(Product p) {
		panier.remove(p);
	}
	public float paiment() {
		float prixTotal=0;
		if(panier.size()>0) {
			for (int i=0;i<panier.size();i++) {
				prixTotal=prixTotal+panier.get(i).getPrice();
				System.out.println("paiement du prix "+prixTotal+" fait ");
			}
		}
		return prixTotal;
	}
	public void clearCard() {
		panier.clear();
	}

}
