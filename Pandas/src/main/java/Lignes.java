import java.util.List;

public class Lignes {
	/**
	 * Indice de la ligne dans notre tableau
	 * */
	int index;
	/**
	 * Colonnes dans le lignes
	 * */
	List<Colonnes> colonnes;
	
	public Lignes(int i,List<Colonnes> c) {
		index = i;
		colonnes = c;
	}
	
	public <E> void addElem(E e,String label) {
		int i = 0;
		boolean trouve = false;
		while(i < colonnes.size() && !trouve) {
			if(colonnes.get(i).sameLabel(label)) {
				trouve = true;
			}
			i++;
		}
		if(trouve) {
			i -= 1;
			colonnes.get(i).addElem(index,e);
		}
	}
	
	public <E> E removeElem(String label) {
		int i = 0;
		boolean trouve = false;
		while(i < colonnes.size() && !trouve) {
			if(colonnes.get(i).sameLabel(label)) {
				trouve = true;
			}
			i++;
		}
		if(trouve) {
			i-= 1;
			return (E) colonnes.get(i).removeElem(index);
		}
		return null;
	}
	
	public <E> E getElem(String label){
		int i = 0;
		boolean trouve = false;
		while(i < colonnes.size() && !trouve) {
			if(colonnes.get(i).sameLabel(label)) {
				trouve = true;
			}
			i++;
		}
		if(trouve) {
			i-= 1;
			return (E) colonnes.get(i).getElem(index);
		}
		return null;
	}
	
}
