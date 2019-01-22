package htwimmoportal;

/*
 * Import-Anweisungen, um Bibliotheken einzubinden.
 */
import java.beans.*;                        // fuer die XML-Speicherung
import java.io.*;                           // fuer das Speichern und Laden in / von Dateien
import java.util.*;                         // fuer ArrayLists
import de.htw.saarland.stl.Stdin;           // fuer Eingaben von der Konsole

/**
 * Die Klasse Verwaltung stellt den Hauptteil der Applikation ImmoPortal dar.
 * Hier wird die Programmlogik implementiert, sowie die Benutzer-Menues.
 *
 * @author Prof. Dr. Daniel F. Abawi
 * @version v1 - November 2010
 */
public class Verwaltung implements Serializable
{
    private ArrayList <Immobilie> immobilienListe;
    private ArrayList <Kunde> kundenListe;

    final static int FELDLAENGE = 14;

    /**
     * Constructor for objects of class Verwaltung
     */
    public Verwaltung()
    {
        immobilienListe = new ArrayList <Immobilie>();
        kundenListe = new ArrayList <Kunde>();
    }

    public void initData()
    {
        Kunde k1 = new Kunde("David","Gilmour","0177 8392332");
        Kunde k2 = new Kunde("Roger","Waters","0171 2233593");
        Kunde k3 = new Kunde("Nick","Mason","0160 9876632");
        Kunde k4 = new Kunde("Richard","Wright","0175 2328750");
        kundenListe.add(k1);
        kundenListe.add(k2);
        kundenListe.add(k3);
        kundenListe.add(k4);

        Adresse a1 = new Adresse("Parkstraße 4", 66123);
        Adresse a2 = new Adresse("Rathausplatz 12", 66119);
        Adresse a3 = new Adresse("Schloßallee 73", 66125);
        Adresse a4 = new Adresse("Opernplatz 2", 66122);

        Haus h1 = new Haus(k1, a1, true, 310000, Haustyp.RH, 180);
        Haus h2 = new Haus(k2, a2, false, 290000, Haustyp.EFH, 160);
        Haus h3 = new Haus(k3, a3, true, 275000, Haustyp.REH, 160);
        Haus h4 = new Haus(k4, a4, false, 600000, Haustyp.VIP, 320);

        Wohnung w1 = new Wohnung(k1, a1, true, 140000, 85);
        Wohnung w2 = new Wohnung(k2, a2, false, 124000, 68);
        Wohnung w3 = new Wohnung(k3, a3, true, 180000, 105);
        Wohnung w4 = new Wohnung(k4, a4, false, 89000, 55);

        Grundstueck g1 = new Grundstueck(k1, a1, true, 40000, 310);
        Grundstueck g2 = new Grundstueck(k2, a2, false, 13000, 540);
        Grundstueck g3 = new Grundstueck(k3, a3, true, 195000, 431);
        Grundstueck g4 = new Grundstueck(k4, a4, false, 65000, 812);

        immobilienListe.add(h1);
        immobilienListe.add(h2);
        immobilienListe.add(h3);
        immobilienListe.add(h4);

        immobilienListe.add(w1);
        immobilienListe.add(w2);
        immobilienListe.add(w3);
        immobilienListe.add(w4);

        immobilienListe.add(g1);
        immobilienListe.add(g2);
        immobilienListe.add(g3);
        immobilienListe.add(g4);
    }
    
    private void saveDataToXML() throws IOException
    {
        XMLEncoder o = new XMLEncoder(new FileOutputStream("HTW-ImmoPortal.xml"));
        o.writeObject("HTW-ImmoPortal");
        o.writeObject(this);
        o.close();
    }

    public Object loadDataFromXML() throws IOException
    {
        XMLDecoder o = new XMLDecoder(new FileInputStream("HTW-ImmoPortal.xml"));
        o.readObject();
        Object obj = o.readObject();
        o.close();
        return obj;
    }

    private void save()
    {
        try
        {
            saveDataToXML();
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private void load()
    {
        try
        {
            Verwaltung v = (Verwaltung) loadDataFromXML();
            // hier starten wir ein neues Programm (eine neue Instanz der Klasse Verwaltung, der wir auch die Kontrolle übergeben), damit wir an die geladenen Daten kommen
            v.mainMenue();
        }
        catch(java.io.IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private void beenden()
    {
        System.exit(0);
    }

    public ArrayList getImmobilienListe()
    {
        return this.immobilienListe;
    }

    public void setImmobilienListe(ArrayList liste)
    {
        this.immobilienListe = liste;
    }

    public ArrayList getKundenListe()
    {
        return this.kundenListe;
    }

    public void setKundenListe(ArrayList liste)
    {
        this.kundenListe = liste;
    }

    private void mainMenue()
    {
        char eingabe;

        do
        {
            System.out.println("HAUPTMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Immobilienmenue");
            System.out.println("[2] Kundenmenue");
            System.out.println("[3] Verwaltung");
            System.out.println("[x] Programm beenden");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case 'x': System.out.println("Vielen Dank für die Nutzung des HTW-ImmoPortals. Das Programm wird beendet.");
                beenden();
                case '1': immobilienMenue();
                          break;
                case '2': kundenMenue();
                          break;
                case '3': verwaltungsMenue();
                          break;
                default: printEingabeFehler();
            }
        } while (true);
    }

    private void immobilienMenue()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("IMMOBILIENMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Zeige alle Haeuser an [Angebote & Gesuche]");
            System.out.println("[2] Zeige Haeuser an [Angebote]");
            System.out.println("[3] Zeige alle Immobilien an [Angebote & Gesuche]");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': showHausListe(false, false);
                    break;
                case '2': showHausListe(true, true);
                    break;
                case '3': showImmobilienListe();
                    break;
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

    private void verwaltungsMenue()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("VERWALTUNGSMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Lade Daten aus XML-Datei");
            System.out.println("[2] Speichere Daten in XML-Datei");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': load();
                    break;
                case '2': save();
                    break;
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

    private void kundenMenue()
    {
        char eingabe;
        boolean menuewechsel = false;
        do
        {
            System.out.println("KUNDENMENUE");
            System.out.println("------------------------------------------------------------");
            System.out.println("[1] Zeige alle Kunden an");
            System.out.println("[2] Suche Kunden nach Nachname");
            System.out.println("[3] Erstelle neuen Kunden");
            System.out.println("[0] HAUPTMENUE");

            printAuswahlTreffen();
            eingabe = Stdin.readlnChar();

            switch (eingabe)
            {
                case '0': menuewechsel = true;
                    break;
                case '1': showKundenListe();
                    break;
                case '2': sucheKundeNachNachname();
                    break;
                case '3': erstelleNeuenKunden();
                    break;
                default: printEingabeFehler();
            }
        } while (!menuewechsel);
    }

//    private void erstelleNeuenKunden()
//    {
//        Kunde k1 = new Kunde("Daniel F.","Abawi","0171 9876543");
//        Kunde k2 = new Kunde("Oliver","Fourman","0171 1234567");
//        kundenListe.add(k1);
//        kundenListe.add(k2);
//    }

    private void erstelleNeuenKunden()
    {
        String nachname = Stdin.readlnString("Bitte geben Sie den Nachnamen des Kunden ein:");
        String vorname = Stdin.readlnString("Bitte geben Sie den Vornamen des Kunden ein:");

        String telefonnummer;
        do
        {
            telefonnummer = Stdin.readlnString("Bitte geben Sie eine Telefonnummer des Kunden ein (nur Zahlenwerte ohne Leerzeichen sind erlaubt!):");
        } while (!telefonnummer.matches("[0-9]+"));

        Kunde k1 = new Kunde(vorname, nachname, telefonnummer);
        kundenListe.add(k1);
    }

    private void showHausListe(boolean filterAn, boolean nurAngebote)
    {
        String s;

        printZentriert("Immo-ID");
        printZentriert("Kunden-ID");
        printZentriert("Postleitzahl");
        printZentriert("Groesse");
        printZentriert("Preis");
        printZentriert("Suche/Biete");
        printLF();
        printLinieLF(6); // Trennlinie für 6 Felder anzeigen

        Iterator <Immobilie>iter = immobilienListe.iterator();
        while(iter.hasNext())
        {
            Immobilie i  =  iter.next();
            if (i instanceof Haus)
            {
                if (filterAn && nurAngebote && !i.getIstAngebot())
                {
                    continue;
                }

                s = castInt2String(i.getId());
                printZentriert(s);

                s = castInt2String(i.getKunde().getId());
                printZentriert(s);

                s = castInt2String(i.getAdresse().getPostleitzahl());
                printZentriert(s);

                Haus h = (Haus) i;
                s = castDouble2String(h.getGroesse());
                printRechtsbuendig(s);

                s = castDouble2String(i.getPreis());
                printRechtsbuendig(s);

                if (i.getIstAngebot()) printZentriert("BIETE");
                else printZentriert("SUCHE");

                printLF();

            }
        }
        printLF();
    }

    private void showKundenListe()
    {
        String s;

        printZentriert("Kunden-ID");
        printZentriert("Vorname");
        printZentriert("Name");
        printZentriert("Telefon");
        printLF();
        printLinieLF(4); // Trennlinie für 6 Felder anzeigen

        Iterator <Kunde>iter = kundenListe.iterator();
        while(iter.hasNext())
        {
            Kunde i  =  iter.next();

            s = castInt2String(i.getId());
            printZentriert(s);

            printLinksbuendig(i.getVorname());

            printLinksbuendig(i.getName());

            printLinksbuendig(i.getTelefonnummer());

            printLF();
        }
        printLF();
    }

    private void sucheKundeNachNachname()
    {
        String nachname = Stdin.readString("Bitte Nachnamen eingeben, nachdem gesucht werden soll:");

        // wir machen einen Testlauf, ob es überhaupt einen Kunden mit diesem Nachnamen gibt
        boolean treffer = false;
        Iterator <Kunde>iter = kundenListe.iterator();
        while(iter.hasNext())
        {
            Kunde i  =  iter.next();
            if (i.getName().equalsIgnoreCase(nachname)) treffer = true;
        }

        if (!treffer)
        {
            System.out.println("Es gibt keinen Kunden mit dem Nachnamen "+nachname);
        }
        else
        {
            printZentriert("Kunden-ID");
            printZentriert("Vorname");
            printZentriert("Name");
            printZentriert("Telefon");
            printLF();
            printLinieLF(4); // Trennlinie für 6 Felder anzeigen

            Iterator <Kunde>iter2 = kundenListe.iterator();
            while(iter2.hasNext())
            {
                Kunde i  =  iter2.next();
                
                // nur die Kunden ausgeben, die dem Suchkriterium entsprechen
                if (i.getName().equalsIgnoreCase(nachname))
                {
                    String s = castInt2String(i.getId());
                    printZentriert(s);

                    printLinksbuendig(i.getVorname());

                    printLinksbuendig(i.getName());

                    printLinksbuendig(i.getTelefonnummer());

                    printLF();
                }
            }
            printLF();
        }
    }

    private void showImmobilienListe()
    {
        String s;

        printZentriert("Immo-ID");
        printZentriert("Kunden-ID");
        printZentriert("Postleitzahl");
        printZentriert("Typ");
        printZentriert("Preis");
        printZentriert("Suche/Biete");
        printLF();
        printLinieLF(6); // Trennlinie für 6 Felder anzeigen

        Iterator <Immobilie>iter = immobilienListe.iterator();
        while(iter.hasNext())
        {
            Immobilie i  =  iter.next();

            s = castInt2String(i.getId());
            printZentriert(s);

            s = castInt2String(i.getKunde().getId());
            printZentriert(s);

            s = castInt2String(i.getAdresse().getPostleitzahl());
            printZentriert(s);

            if (i instanceof Grundstueck) printZentriert("Grundstueck"); 
            if (i instanceof Wohnung) printZentriert("Wohnung"); 
            if (i instanceof Haus) printZentriert("Haus");

            s = castDouble2String(i.getPreis());
            printRechtsbuendig(s);

            if (i.getIstAngebot()) printZentriert("BIETE");
            else printZentriert("SUCHE");

            printLF();            
        }
        printLF();
    }

    private String castInt2String(int meinInt)
    {
        return Integer.toString(meinInt);
        // die obige Zeile ist von der Funktion identisch zu
        // Integer i = new Integer(meinInt);
        // return i.toString();
    }

    private String castDouble2String(double meinDouble)
    {
        // hier nutzen wir die Format-Anweisung der Klasse String um die Nachkommastellen zu bestimmen etc.
        return String.format("%,8.2f", meinDouble);
    }

    private void printLF()
    {
        System.out.println();
    }

    private void printZentriert(String s)
    {
        System.out.print(baueZentriertenString(s, FELDLAENGE));
    }

    private void printLinksbuendig(String s)
    {
        System.out.print(baueLinksbuendigenString(s, FELDLAENGE));
    }

    private void printRechtsbuendig(String s)
    {
        System.out.print(baueRechtsbuendigenString(s, FELDLAENGE));
    }

    private void printLinieLF(int anzahlFelder)
    {
        /* Besonderheit: hier Nutzung des StringBuilders statt direkt mit String zu arbeiten.
         * Ist sparsamer im Umgang mit Speicher.
         */
        StringBuilder s = new StringBuilder();
        int laenge = anzahlFelder*(FELDLAENGE+3);
        for (int i=1;i<=laenge;i++)
        {
            s=s.append("-");
        }
        System.out.println(s);
    }

    private String baueZentriertenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenzLinks = (laenge - s.length())/2;
            for (int i=1;i<=differenzLinks;i++) s=" "+s+" ";
            if (s.length()<laenge) s=s+" ";
        }

        return s+" | ";
    }

    private String baueRechtsbuendigenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenzLinks = (laenge - s.length());
            for (int i=1;i<=differenzLinks;i++) s=" "+s;
        }

        return s+" | ";
    }

    private String baueLinksbuendigenString(String s, int laenge)
    {
        // wir entfernen Leerzeichen am Anfang und Ende des Strings
        s.trim();
        // falls der String zu lang ist, kuerzen wir ihn
        if (s.length() > laenge)
        {
            s.substring(0, laenge);
        }
        else
        {
            int differenz = (laenge - s.length());
            for (int i=1;i<=differenz;i++) s=s+" ";
        }

        return s+" | ";
    }

    private void printEingabeFehler()
    {
        System.out.print("Ihre Eingabe wurde nicht erkannt.\n");
    }

    private void printAuswahlTreffen()
    {
        System.out.print("Bitte treffen Sie eine Auswahl ...\n");
    }

    private void printProgrammInfo()
    {
        System.out.println("************************************************************");
        System.out.println("* HTW-ImmoPortal v1.0 written by Prof. Dr. Daniel F. Abawi *");
        System.out.println("*                                Oliver Fourman (M.Sc.)    *");
        System.out.println("************************************************************");
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Verwaltung v = new Verwaltung();

        v.initData();
        v.printProgrammInfo();
        v.mainMenue();        
    }
}