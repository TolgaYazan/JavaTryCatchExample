package exceptiontest;

public class ContainsExclamationManager {

    public void checkExclamation(String chekcedExclamaionStatemnt) throws ContainsExclamation{
        if(!chekcedExclamaionStatemnt.contains("!")){
            System.out.println("String değer exclamation yok");
        }else{
            throw new ContainsExclamation(
                    "Verilen değerde exclamation var" + chekcedExclamaionStatemnt);
        }

    }
}
