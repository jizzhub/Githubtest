package htwimmoportal;
/**
 * Die Klasse Haus ist eine Spezialisierung einer Immobilie.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */

public class Haus extends Immobilie
{
    // hier stehen die Instanzvariablen, sie haben Geltung in dem gesamten Objekt
    private Haustyp typ;

    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Haus()
    {
    }

    /**
     * Konstruktor der Klasse Haus mit sechs Parametern.
     * @param kunde Kunde, der solch ein Haus sucht bzw. anbietet
     * @param adresse Adresse des Hauses
     * @param istAngebot Wahrheitswert, ob es sich bei diesem Eintrag um ein Angebot handelt (dann true)
     * @param preis Preis des Hauses bzw. Preisvorstellung des Suchenden für eine solches Haus
     * @param haustyp Bestimmt, um was für ein Haustyp es sich handelt (Nutzung von Enumeration, also einer Aufzählung)
     * @param groesse Groesse des Hauses (Wohnflaeche in Quadratmeter)
     */
    public Haus(Kunde kunde, Adresse adresse, boolean istAngebot, double preis, Haustyp haustyp, double groesse)
    {
        super(kunde, adresse, istAngebot, preis, groesse);
        this.typ = haustyp;
    }   
}
