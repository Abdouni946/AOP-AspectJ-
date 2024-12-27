package enset.zakariae.metier;

public interface IMetier {
    public void addCompte(compte c);
    public void verser(Long code, double montant);
    public void retirer(Long code, double montant);
    public compte consulter(Long code);
}
