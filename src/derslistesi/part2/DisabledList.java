package derslistesi.part2;


/**
 * Disabled derslerden oluşan linked list oluşturucu sınıf.
 * DersListesi sınıfından silinen silinen elemanlar bu listeye kaydolur.
 */
public class DisabledList {
    Ders bas;
    Ders son;



    public DisabledList() {
        bas = null;
        son = null;
    }

    /**
     * Disabled durumda olan dersleri yazdırır.
     */
    public void listeyiYazdir() {
        Ders isaretci = bas;
        while (isaretci != null) {
            System.out.print("ID : " + isaretci.getID() +" , Ders adı : " + isaretci.dersAdi + " ," +
                    " Ders Kodu : " + isaretci.dersKodu + " ," +
                    " Somestr no : " + isaretci.somestrNo);
            System.out.println();
            isaretci = isaretci.next;
        }
    }


    /**
     * DersListesi sınıfının içindeki disable(); methodunun içerisinde çağrılır.
     * DersListesi sınıfında disable edilen ders bu listeye eklenir.
     * @param dersAdi
     * @param dersKodu
     * @param somestrNo
     * @param lastIndeks
     * @param id
     */
    public void basaEkle(String dersAdi , String dersKodu , int somestrNo ,int lastIndeks,int id) {
        Ders ders = new Ders(dersAdi,dersKodu,somestrNo);
        ders.setLastIndex(lastIndeks);
        ders.setID(id);

        if (doluMu()) {
            ders.next = bas;
            bas = ders;
        } else {
            bas = ders;
            son = ders;
        }
    }

    /**
     * verilen ID numarasını liste içerisinde arar.
     * ID bulunuyorsa dersi geri döndürür.
     * @param id
     * @return
     */
    public Ders dersBul(int id ){
        if(doluMu()){
            Ders isaretci;
            isaretci=bas;
            while(isaretci.next!=null){
                if(isaretci.getID() == id ){
                    return isaretci;
                }else{
                    isaretci=isaretci.next;
                }
            }if(isaretci.getID()==id){
                return isaretci;
            }

        }
        return null;
    }


    /**
     * Listenin boş mu dolu mu olduğunu gösterir
     *
     * @return
     */
    public boolean doluMu() {
        return bas != null;
    }

    /**
     * Kendisine verilen parametredeki ders kodunu ders listesinden siler.
     * Önce ders listemizin dolu olup olmadığını kontrol eder.
     * Ders listemiz doluysa ders listemizde tek bir ders mi yoksa birden fazla mı ders olduğunu kontrol eder.
     * Tek ders varsa ders listemizin baş işaretçisini ve son işaretçisini null yapar.
     * Birden fazla ders varsa baştakini silmek için ayrı başta olmayan veriyi silmek için farklı yol izleriz.
     * @param ID
     */
    public void dersSilByDersID(int ID) {
        if(doluMu()) {
            if(bas == son) {
                if (bas.getID()==ID) {
                    bas=null;
                    son=null;
                    System.out.println("calisti");
                }
            }
            else{
                //en az iki eleman var
                if (bas.getID()==ID) {
                    //baştakini sil
                    Ders yeniBas = bas.next;
                    bas.next=null;
                    bas=yeniBas;
                }else {
                    //en az iki eleman var ve sildiğimiz başta değil
                    Ders isaretci1= null;
                    Ders isaretci2 = bas;
                    while (isaretci2!=null && isaretci2.getID() !=ID) {
                        isaretci1=isaretci2;
                        isaretci2 = isaretci2.next;
                    }
                    if(isaretci2!=null){
                        /**
                         * sileceğimiz değer listenin son elemanıysa aşağıdaki blok çalışır
                         */
                        if(isaretci2==son){
                            son=isaretci1;
                            isaretci1.next=null;
                        }
                        /**
                         * Baş ile son arasında bir değer ise aşağıdaki blok çalışır
                         */
                        else{
                            //ortadan silme
                            Ders isaretci3 = isaretci2.next;
                            isaretci2.next=null;
                            isaretci1.next=isaretci3;
                        }

                    }
                }
            }
        }else{
            System.out.println("Liste boş");
        }
    }

}