package htwimmoportal;
/**
 * Die Klasse Adresse stellt Adressinformationen bereit. Sie wird von der Klasse Immobilie genutzt.
 * Denkbar wäre auch eine Nutzung in der Klasse Kunde.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public class Adresse
{
    // hier stehen die Instanzvariablen, sie haben Geltung in dem gesamten Objekt
    // (können innerhalb des Objektes mit this.ATTRIBUTNAME angesprochen werden)
    private String strasse;
    private int postleitzahl;

    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Adresse()
    {
    }

    /**
     * Konstruktor der Klasse Adresse mit zwei Parametern.
     * @param strasse Strasse
     * @param postleitzahl Postleitzahl
     */
    public Adresse(String strasse, int postleitzahl)
    {
        this.strasse = strasse;
        this.postleitzahl = postleitzahl;
    }

    /**
     * Methode gibt die Strasse der Adresse zurueck.
     * @return strasse
     */
    public String getStrasse()
    {
        return this.strasse;
    }

    /**
     * Methode setzt die Strasse in der Adresse neu.
     * @param strasse Die Strasse der Adresse.
     */
    public void setStrasse(String strasse)
    {
        this.strasse = strasse;
    }

    /**
     * Methode gibt die Postleitzahl der Adresse zurueck.
     * @return postleitzahl
     */
    public int getPostleitzahl()
    {
        return this.postleitzahl;
    }

    /**
     * Methode setzt die Postleitzahl in der Adresse neu.
     * @param postleitzahl Die Postleitzahl der Adresse.
     */
    public void setPostleitzahl(int postleitzahl)
    {
        this.postleitzahl = postleitzahl;
    }
}
