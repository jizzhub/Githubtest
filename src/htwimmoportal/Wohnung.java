package htwimmoportal;
/**
 * Die Klasse Wohnung ist eine Spezialisierung einer Immobilie.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public class Wohnung extends Immobilie
{
    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Wohnung()
    {
    }

    /**
     * Konstruktor der Klasse Wohnung mit fuenf Parametern
     * @param kunde Kunde, der solch eine Wohnung sucht bzw. anbietet
     * @param adresse Adresse der Wohnung
     * @param istAngebot Wahrheitswert, ob es sich bei diesem Eintrag um ein Angebot handelt (dann true)
     * @param preis Preis der Wohnung bzw. Preisvorstellung des Suchenden für eine solche Wohnung
     * @param groesse Groesse der Wohnung (Wohnflaeche in Quadratmeter)
     */
    public Wohnung(Kunde kunde, Adresse adresse, boolean istAngebot, double preis, double groesse)
    {
        super(kunde, adresse, istAngebot, preis, groesse);
    }
}