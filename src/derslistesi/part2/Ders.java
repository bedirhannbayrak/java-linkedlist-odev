package derslistesi.part2;

/**
 * Ders adı, ders kodu, sömestr numarası ve ders ID'lerinden oluşan bir sınıf yaratıldı
 * Her sınıf üyesine otomatik olarak ID ataması yapılması için static bir sayaç eklendi.
 * ID için get ve set metodları oluşturuldu.
 */
public class Ders {
    String dersAdi;
    String dersKodu;
    int somestrNo;
    private static int count = 0;
    private int ID;
    Ders next;
    private boolean isEnabled;
    private int lastIndex;


    public Ders(String dersAdi, String dersKodu, int somestrNo ) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.somestrNo = somestrNo;
        setID(++count);
        this.next = null;
        this.isEnabled=true;

    }


    public boolean isEnabled() {
        return isEnabled;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }


    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
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
                ", Sömestr no : " + somestrNo ;

    }
}
