package htwimmoportal;
/**
 * Die Klasse Immobilie ist die Basisklasse aller unserer Immobilienobjekte.
 * Sie ist abstrakt, da aus den Subklassen Objekte erzeugt werden sollen, nicht aber auf Basis dieser Klasse.
 * 
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public abstract class Immobilie
{
    // hier stehen die Instanzvariablen, sie haben Geltung in dem gesamten Objekt
    // (können innerhalb des Objektes mit this.ATTRIBUTNAME angesprochen werden)
    private static int idCounter = 1000;
    private int id;
    private double preis;
    private Kunde kunde; /* hier ein Attribut welches keinen primitiven Datentyp darstellt */
    private boolean istAngebot;
    private double groesse;
    private Adresse adresse; /* Privates Attribut adresse der Immobilie
                              * (vom Typ Adresse. Adresse ist eine Klasse)
                              */

    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Immobilie()
    {      
    }

    /**
     * Konstruktor der Klasse Immobilie mit fuenf Parametern.
     * @param kunde Kunde, der solch eine Immobilie sucht bzw. anbietet
     * @param adresse Adresse der Immobilie
     * @param istAngebot Wahrheitswert, ob es sich bei diesem Eintrag um ein Angebot handelt (dann true)
     * @param preis Preis der Immobilie bzw. Preisvorstellung des Suchenden für eine solche Immobilie
     * @param groesse Groesse der Immobilie.
     */
    public Immobilie(Kunde kunde, Adresse adresse, boolean istAngebot, double preis, double groesse)
    {
        this.preis = preis;
        this.adresse = adresse;
        this.kunde = kunde;
        this.istAngebot = istAngebot;
        this.groesse = groesse;

        this.id = idCounter;
        idCounter++;    
    }
    
    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setPreis(double preis)
    {
        this.preis = preis;
    }
    
    public double getPreis()
    {
        return this.preis;
    }
    
    public void setKunde(Kunde kunde)
    {
        this.kunde = kunde;
    }
    
    public Kunde getKunde()
    {
        return this.kunde;
    }
    
    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }
    
    public Adresse getAdresse()
    {
        return this.adresse;
    }
    
    public boolean getIstAngebot()
    {
        return this.istAngebot;
    }
    
    public void setIstAngebot(boolean istAngebot)
    {
        this.istAngebot = istAngebot;
    }

    /**
     * Methode liefert die Groesse der Immobilie zurück.
     * @return Groesse der Immobilie (in Quadratmeter)
     */
    public double getGroesse()
    {
        return this.groesse;
    }

    /**
     * Methode setzt die Groesse der Immobilie fest.
     * @param groesse Groesse der Immobilie (in Quadratmeter)
     */
    public void setGroesse(double groesse)
    {
        this.groesse = groesse;
    }
}
