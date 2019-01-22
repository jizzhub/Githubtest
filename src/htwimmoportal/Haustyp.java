package htwimmoportal;
/**
 * Die Klasse Haustyp ist vom Typ Enumeration.
 * Genutzt wird diese Klasse von der Klasse Haus. Damit definiert sie gueltige Haustypen.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public enum Haustyp
{
    /**
     * Hier die Aufzaehlung von gueltigen Haustypen, die unsere Anwendung kennen soll.
     * Es gibt bei uns eine Kurzbezeichnung, eine Bezeichnung in Normalform sowie ein Zahlcode,
     * der bisher keine weitere Verwendung finden.
     */
    RH("Reihenhaus", 1),
    REH("Reihenendhaus", 2),
    DHH("Doppelhaushälfte", 3),
    EFH("Einfamilienhaus", 5),
    VIP("Villa", 20);

    /**
     * Die Instanzvariablen sind hier definiert. Bei Enumerations also hinter der Aufzaehlung der eigentlichen Typen.
     */
    private String typ;
    private int bewertungszahl;

    /**
     * Konstruktor: Man beachte das fehlende public. Dies ist eine Eigenart von Enumeration-Klassen.
     * @param bezeichner Ausgeschriebene Bezeichnung des Typs
     * @param bewertungszahl Fuer interne Berechnung (nicht genutzt)
     */
    Haustyp(String bezeichner, int bewertungszahl)
    {
        this.typ = bezeichner;
        this.bewertungszahl = bewertungszahl;
    }

    /**
     * Methode gibt die Bewertungszahl des Haustyps zurueck.
     * @return bewertungszahl
     */
    public int getBewertung()
    {
        return this.bewertungszahl;
    }

    /**
     * Methode gibt die Typbezeichnung des Hauses zurueck.
     * @return typ
     */
    public String getTypbezeichnung()
    {
        return this.typ;
    }
}