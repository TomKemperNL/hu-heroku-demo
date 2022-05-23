package domein;

public class KoffieSoort {
    private String naam;
    private double prijs;
    private String barcode;
    private int sterkte;

    public KoffieSoort(){
        naam = "";
        prijs = 0;
        barcode = "";
        sterkte = 0;
    }

    public KoffieSoort(String naam, double prijs, String barcode, int sterkte) {
        this.naam = naam;
        this.prijs = prijs;
        this.barcode = barcode;
        this.sterkte = sterkte;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getSterkte() {
        return sterkte;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setSterkte(int sterkte) {
        this.sterkte = sterkte;
    }
}
