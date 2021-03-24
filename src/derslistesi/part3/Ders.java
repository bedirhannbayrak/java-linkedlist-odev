package derslistesi.part3;


public class Ders {
    String dersAdi;
    String dersKodu;
    int somestrNo;
    /**
     * tüm derslere otomatik olarak id atanması için static count değişkenti oluşturuldu
     */
    private static int count = 0;
    private int ID;
    Ders next;
    Ders nextSomestr;

    /**
     *
     * @param dersAdi
     * @param dersKodu
     * @param somestrNo
     */
    public Ders(String dersAdi, String dersKodu, int somestrNo ) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.somestrNo = somestrNo;
        setID(++count);
        this.next = null;
        this.nextSomestr=null;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Ders ID : '" + getID() + '\'' +
                " , Ders adı :'" + dersAdi + '\'' +
                ", Ders kodu: '" + dersKodu + '\'' +
                ", Sömestr no : " + somestrNo /* +
                ", nextSomestrDers : " + nextSomestr*/;

    }
}
