package fr.orsys.kingsley.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
	
	//Déclarez les variables nécessaires
	
	private static List<Integer> grille = new ArrayList<>();
	private static List<Integer> tirage = new ArrayList<>();
	private static List<Integer> bonChoix = new ArrayList<>();
	private static final int SIZE_LIST = 5;
	private static Random random = new Random();
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Bienvenue sur loto, Saisir 5 nombres distinct: ");
		
		while (true) {
			boolean hasNextInt = scanner.hasNextInt();

			if (hasNextInt) {
				int entree = scanner.nextInt();
				if (grille.size() < SIZE_LIST ) {
					if ((entree >= 1) && (entree <= 49)) {
						if (grille.contains(entree)) {
							System.out.println("Le nombre existe déja");
							continue;
						} else {
							grille.add(entree);
						}
					} else {
						System.out.println("Nombre hors de range");
						continue;
					}

				} else {
					System.out.println("Vous avez entréz des nombres réquirt");
					break;
				}

			} else {
				System.out.println("Vous avez entrez un nombre invalide");
			}

			scanner.nextLine(); // regle la probléme d'entréé

		}

		scanner.close();
		Collections.sort(grille); // Trier tirage
		for (Integer showOutput: grille) {
			System.out.print(showOutput + " ");
		}
		
		// Générer 5 nombres aléatoires distincts
		randomNombre(); //Execute la méthode random
		Collections.sort(tirage); // Trier tirage
		
		System.out.println();
		
		System.out.println("Nombre random");
		for (Integer showOutput: tirage) {
			System.out.print(showOutput + " ");
		}
		
		// Afficher bon choix
		System.out.println();
		AfficherBonsChoixParUtilisateur();
		System.out.println("Vous avez obtenu " + bonChoix.size() + " bon choix");
		System.out.println(bonChoix);
	}
	
	private static List<Integer> randomNombre() {
		while (true) {
			int nombreInt = random.nextInt(48) + 1;

			if (tirage.size() < SIZE_LIST ) {
				if (tirage.contains(nombreInt)) {
					continue;
				} else {
					tirage.add(nombreInt);
				}
			} else {
				break;
			}

		}
		
		return tirage;

	}
	
	private static List<Integer> AfficherBonsChoixParUtilisateur() {
		for (Integer grill: grille) {
			for (Integer tir: tirage) {
				if ( grill.equals(tir)) {
					bonChoix.add(grill);
				}
			}
		}
		
		return bonChoix;
	}
}
