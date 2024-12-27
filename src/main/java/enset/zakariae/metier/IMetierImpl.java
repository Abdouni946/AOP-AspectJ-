package enset.zakariae.metier;

import java.util.HashMap;
import java.util.Map;

public class IMetierImpl implements IMetier {

    private Map<Long,compte> comptesMap = new HashMap<>();
    @Override
    public void addCompte(compte c) {
        comptesMap.put(c.getCode(),c);

    }

    @Override
    public void verser(Long code, double montant) {
        compte c = comptesMap.get(code);
        c.setSolde(c.getSolde()+montant);

    }

    @Override
    public void retirer(Long code, double montant) {
        compte c = comptesMap.get(code);
        c.setSolde(c.getSolde()-montant);
    }

    @Override
    public compte consulter(Long code) {
        return comptesMap.get(code);
    }
}
