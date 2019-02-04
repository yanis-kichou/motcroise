package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * 
	 * @param mot
	 *            à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * 
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}

	/**
	 * Accès au i-eme mot du dictionnaire.
	 * 
	 * @param i
	 *            l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * 
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy() {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de
	 * filtrer pour ne pas perdre d'information.
	 * 
	 * @param len
	 *            la longueur voulue
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	/**
	 * retire les mots qui n'ont pas au i_eme caractere le charactere c
	 * 
	 * @param c
	 *            le caractere de filtrage voulu
	 * @param i
	 *            l'indice du caractere a comparer avec c
	 * @return le nombre de mot retirer du dictionnaire
	 */
	public int filtreParLettre(char c, int i) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (mot.charAt(i) == c)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	/**
	 * retire les mots dans la i_eme caractere des mots du dictionnaire qui ne sont
	 * pas dans l'ensemble lp
	 * 
	 * @param i
	 *            indice du caractere a verifier
	 * @param lp
	 *            ensemble des lettres possible pour les mots du dictionnaire a
	 *            l'indice i
	 * @return le nombre de mots filtrer
	 */
	public int filtreParLettre(int i, EnsembleLettre lp) {
		List<String> cible = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (lp.contains(mot.charAt(i)))
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	/**
	 * REtour l'esemble des lettres figurant dans le i_eme caractere des mots du
	 * dictionnaire
	 * 
	 * @param i
	 *            l'indice du caractere
	 * @return un ensebleLettre avec toutes les lettres figurant dans la i_eme place
	 *         des mots du dictionnaire
	 */
	public EnsembleLettre getLettres(int i) {
		EnsembleLettre cible = new EnsembleLettre();
		for (String s : this.mots) {
			if(!cible.contains(s.charAt(i)))
				cible.add(s.charAt(i));
		}
		return cible;
	}

	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}

	/**
	 * fonction qui charge un dictionnaire a trevers un chemain passer ne paramettre
	 * 
	 * @param path
	 *            le chemin absulo du fichier ou figure le dictionnaire a charger
	 * @return une nouvelle instance de Dictionnaire
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire d = new Dictionnaire();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			for (String line = br.readLine(); line != null; line = br.readLine()) {
				d.add(line);
			}
		} catch (IOException e) {
			// Problème d’accès au fichier.
			e.printStackTrace();

		}
		return d;
	}
}
