package htwimmoportal;
/**
 * Die Klasse Grundstueck ist eine Spezialisierung einer Immobilie.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public class Grundstueck extends Immobilie
{
    // hier stehen die Instanzvariablen, sie haben Geltung in dem gesamten Objekt
    // (können innerhalb des Objektes mit this.ATTRIBUTNAME angesprochen werden)
    

    /**
     * Standardkonstruktor (eigentlich nur notwendig für die XML-Speicherung)
     */
    public Grundstueck()
    {
    }

    /**
     * Konstruktor der Klasse Grundstueck mit fuenf Parametern.
     * @param kunde Kunde, der solch ein Grundstueck sucht bzw. anbietet
     * @param adresse Adresse des Grundstuecks
     * @param istAngebot Wahrheitswert, ob es sich bei diesem Eintrag um ein Angebot handelt (dann true)
     * @param preis Preis des Grundstuecks bzw. Preisvorstellung des Suchenden für ein solches Grundstueck
     * @param groesse Groesse des Grundstuecks (in Quadratmeter)
     */
    public Grundstueck(Kunde kunde, Adresse adresse, boolean istAngebot, double preis, double groesse)
    {
        super(kunde, adresse, istAngebot, preis, groesse);
    }
}
