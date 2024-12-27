package enset.zakariae.test;

import enset.zakariae.metier.IMetier;
import enset.zakariae.metier.IMetierImpl;
import enset.zakariae.metier.compte;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        System.out.println("Bienvenue dans l'application de gestion de comptes !");
        Scanner scanner = new Scanner(System.in);
        IMetier metier = new IMetierImpl();

        try {

            System.out.println("Veuillez saisir le code du compte :");
            Long code = scanner.nextLong();

            System.out.println("Veuillez saisir le solde initial du compte :");
            double solde = scanner.nextDouble();

            compte c = new compte(code, solde);
            metier.addCompte(c);

            System.out.println("Veuillez saisir le montant à verser :");
            double montant = scanner.nextDouble();
            metier.verser(code, montant);

            System.out.println("Veuillez saisir le montant à retirer :");
            double montantRetrait = scanner.nextDouble();
            metier.retirer(code, montantRetrait);

            System.out.println("Veuillez saisir le code du compte à consulter :");
            Long codeConsulter = scanner.nextLong();
            compte compteConsulte = metier.consulter(codeConsulter);

            if (compteConsulte != null) {
                System.out.println("Détails du compte consulté :");
                System.out.println("Code : " + compteConsulte.getCode());
                System.out.println("Solde : " + compteConsulte.getSolde());
            } else {
                System.out.println("Aucun compte trouvé avec le code saisi.");
            }
        } catch (InputMismatchException e) {
            System.err.println("Erreur : Entrée invalide. Veuillez saisir des valeurs numériques correctes.");
        } catch (Exception e) {
            System.err.println("Une erreur inattendue s'est produite : " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Fin de l'application. Merci de votre visite !");
        }
    }
}
