package derslistesi.part2;


public class DersListesi {
    Ders bas;
    Ders son;

    DisabledList disabledList = new DisabledList();

    /**
     * Tüm derslerin listesini yazdırır.
     */
    public DersListesi() {
        bas = null;
        son = null;
    }


    /**
     * Ders listesine yeni ders ekler
     *
     * @param dersAdi
     * @param dersKodu
     * @param somestrNo
     */
    public void basaEkle(String dersAdi, String dersKodu, int somestrNo) {
        Ders yeniDers = new Ders(dersAdi, dersKodu, somestrNo);
        if (doluMu()) {
            // liste dolu
            yeniDers.next = bas;
            bas = yeniDers;

        } else {
            // liste boş
            bas = yeniDers;
            son = yeniDers;
        }
    }

    /**
     * Dersi disable ederken id ve indeks numaralarını da DisabledList listesine göndermiştik
     * tekrar enable ederken kaçıncı indekste kaldıysa o indekse yerleştiriyoruz.
     * id'sini de aynı id yapıyoruz
     *
     * @param dersAdi
     * @param dersKodu
     * @param somestrNo
     * @param index
     * @param id
     */
    public void indekseEkle(String dersAdi, String dersKodu, int somestrNo, int index,int ... id) {

        Ders yeniDers = new Ders(dersAdi,dersKodu,somestrNo);
        try{
            yeniDers.setID(id[0]);
        } catch (Exception e){

        }



        if(doluMu()) {
            if (index<=0) {
                // başa eklemekle aynı
                yeniDers.next = bas;
                bas = yeniDers;
            } else {
                //orta bir yere ekliyoruz
                Ders isaretci1 = null;
                Ders isaretci2 = bas;
                int mevcutIndeks = 0 ;
                while(isaretci2!=null && (mevcutIndeks < index)){
                    isaretci1=isaretci2;
                    isaretci2=isaretci2.next;

                    mevcutIndeks++;
                }
                if(isaretci2==null ){
                    //son elemana eklemeyle aynı
                    son.next=yeniDers;
                    son=yeniDers;
                } else {
                    yeniDers.next=isaretci2;
                    isaretci1.next=yeniDers;
                }
            }
        } else {
            bas = yeniDers;
            son = yeniDers;
        }

    }

    /**
     * Listenin sonuna eleman ekler
     * @param dersAdi
     * @param dersKodu
     * @param somestrNo
     */
    public void sonaEkle(String dersAdi, String dersKodu,int somestrNo) {
        Ders yeniDers = new Ders(dersAdi,dersKodu,somestrNo);
        if(doluMu()) {
            son.next = yeniDers;
            son = yeniDers;
        } else {
            // liste boş
            bas = yeniDers;
            son = yeniDers;
        }
    }


    /**
     * Kendisine verilen parametredeki ders kodunu ders listesinden siler.
     * Önce ders listemizin dolu olup olmadığını kontrol eder.
     * Ders listemiz doluysa ders listemizde tek bir ders mi yoksa birden fazla mı ders olduğunu kontrol eder.
     * Tek ders varsa ders listemizin baş işaretçisini ve son işaretçisini null yapar.
     * Birden fazla ders varsa baştakini silmek için ayrı başta olmayan veriyi silmek için farklı yol izleriz.
     * @param dersKodu
     */
    public void dersSilByDersKodu(String dersKodu) {
        if(doluMu()) {
            if(bas == son) {
                if (bas.dersKodu.equals(dersKodu)) {
                    bas=null;
                    son=null;
                    System.out.println("calisti");
                }
            }
                else{
                    //en az iki eleman var
                if (bas.dersKodu.equals(dersKodu)) {
                    //baştakini sil
                    Ders yeniBas = bas.next;
                    bas.next=null;
                    bas=yeniBas;
                }else {
                    //en az iki eleman var ve sildiğimiz başta değil
                    Ders isaretci1= null;
                    Ders isaretci2 = bas;
                    while (isaretci2!=null && !isaretci2.dersKodu.equals(dersKodu)){
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


    /**
     * kendisine parametre olarak verilen ders koduna ait derse bağlı bir sonraki dersin bilgilerini gösterir.
     * @param ID
     */
    public void next(int ID) {
        if(doluMu()) {
            if(bas == son) {
                if (bas.getID()==ID) {

                    System.out.println(bas.next);
                }
            }
            else{
                Ders isaretci = bas;
                if (bas == null) {
                    System.out.println("Liste  boş");
                } else {

                    while (true) {
                        if (isaretci.getID()==ID) {
                            if (isaretci.next != null){
                                System.out.println();
                                System.out.println("next :");
                                System.out.println(isaretci.next);
                            }else {
                                System.out.println("Listenin son dersidir. Bir sonraki ders yok");
                            }
                        }
                        if (isaretci.next != null) {
                            isaretci = isaretci.next;
                        } else {
                            break;
                        }

                    }

                }
            }
        }else{
            System.out.println("Liste boş");
        }
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
     * Tüm ders listesini yazdırır.
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
     * Ders listesinin boyutunu yazdırır.
     */
    public void size() {
        Ders isaretci = bas;
        int count = 0;
        while (isaretci != null) {

            isaretci = isaretci.next;
            count++;
        }
        System.out.println();
        System.out.println("Toplam ders sayısı : " + count);
    }


    /**
     * Girilen somestr numarasındaki tüm dersleri yazdırır.
     * @param no
     */
    public void listSemesterCourses(int no) {
        if(no<=0 || no >8) {
            System.out.println("Böyle bir sömestr numarası yoktur");
        }else {
            Ders isaretci = bas;
            //Liste boş mu kontrolü
            if (bas == null) {
                System.out.println("Liste  boş");
            } else {
                System.out.println();
                System.out.println(no+". sömestr dönemindeki ders listesi:");
                while (true) {
                    if (isaretci.somestrNo == no) {
                        System.out.println(isaretci.dersAdi);
                    }
                    if (isaretci.next != null) {
                        isaretci = isaretci.next;
                    } else {
                        break;
                    }

                }

            }
        }

    }


    /**
     * Kendisine parametre olarak verilen ders koduna sahip tüm derslerin listesini verir.
     * @param dersKodu
     */
    public void getByCode(String dersKodu) {
            Ders isaretci = bas;
            //Liste boş mu kontrolü
            if (bas == null) {
                System.out.println("Liste  boş");
            } else {
                System.out.println();
                System.out.println(dersKodu+" kodlu dersler listesi:");
                int counter = 0;
                while (true) {
                    if (isaretci.dersKodu.equals(dersKodu)) {
                        System.out.println(isaretci.dersAdi);
                        counter++;
                    }
                    if (isaretci.next != null) {
                        isaretci = isaretci.next;
                    } else {
                        if (counter==0) {
                            System.out.println("Bu koda ait bir ders bulunamadı");
                        }
                        break;
                    }

                }

            }


    }


    /**
     * Ders kodu girilen dersten bir sonraki dersi ekrana yazdırır
     * @param dersKodu
     */
    public void nextInSemester(String dersKodu) {
        if(doluMu()) {
            if(bas == son) {
                if (bas.dersKodu.equals(dersKodu)) {

                    System.out.println("listede tek bir ders var");
                }
            }
            else{
                Ders isaretci = bas;
                if (bas == null) {
                    System.out.println("Liste  boş");
                } else {
                    int somestrNo = 0;

                    while (true) {
                        if (isaretci.dersKodu.equals(dersKodu)) {
                            somestrNo = isaretci.somestrNo;
                            {
                                while(isaretci.next!= null){
                                    if (isaretci.next.somestrNo ==somestrNo){
                                        System.out.println(isaretci.next);
                                        break;
                                    }
                                    isaretci=isaretci.next;
                                }
                            }
                            break;
                        }
                        if (isaretci.next != null) {
                            isaretci = isaretci.next;
                        } else {
                            break;
                        }
                    }
                }
            }
        }else{
            System.out.println("Liste boş");
        }
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


    /**
     * girilen iki indeks değeri arasındaki tüm liste ögelerini yazdırır.
     * Girilen indeks aralığı listenin dışındaysa fonksiyon durdurulur.
     * @param indeks1
     * @param indeks2
     */
    public void getByRange(int indeks1, int indeks2) {
        if(indeks1>=indeks2 || indeks1<0) {
            System.out.println("ilk girilen değer ikinciden küçük olmalıdır ve sayılar negatif olmamalıdır.");
        }else {
            Ders isaretci = bas;
            int mevcutIndeks = 0;
            //Liste boş mu kontrolü
            if (bas == null) {
                System.out.println("Liste  boş");
            } else {
                System.out.println();
                System.out.println(indeks1 + ". index ile " + indeks2 + ". indeks arasındaki ders listesi:");
                while (isaretci.next!=null && mevcutIndeks < indeks1 ) {
                    isaretci = isaretci.next;
                    mevcutIndeks++;
                }
                /**
                 * Tüm liste gezilir ve girilen indekse ulaşılamazsa gerekli bilgi verilip fonksiyon durdurulur.
                 */
                if (mevcutIndeks<indeks1) {
                    System.out.println("Girilen indeks değerleri arasında bir ders bulunamadı.");
                    return;
                }

                while (isaretci.next!=null && mevcutIndeks < indeks2 ) {
                    System.out.println(isaretci);
                    isaretci=isaretci.next;
                    mevcutIndeks++;
                }

                /**
                 * isaretci.next null olduğunda while döngüsünün içine girmediği için listenin son elemanını
                 * yazdırmıyordu. aşağıdaki kod ile listenin son elemanı yazdırılıyor.
                 */
                if(isaretci.next==null && mevcutIndeks != indeks2) {
                    System.out.println(isaretci);
                }

            }
        }

    }

    /**
     * ID'si verilen dersi disable durumuna getirir.
     * Tekrar enable edeceğimizde aynı indekse koyabilmemiz için bulunduğu indeksi de kaydeder.
     * Tekrar aynı id ile kaydedebilmemiz için id'sini de kaydeder.
     * Tüm verilerle birlikte DisabledList sınıfına yeni nesne olarak gönderilir
     * Mevcut listeden silinir.
     * @param id
     */
    public void disable(int id) {
        if (doluMu()){
            int mevcutIndeks=0;
            Ders isaretci= bas;
            while(isaretci.next!=null){
                if(isaretci.getID()==id){
                    isaretci.setLastIndex(mevcutIndeks);
                    disabledList.basaEkle(isaretci.dersAdi,isaretci.dersKodu,isaretci.somestrNo,mevcutIndeks,isaretci.getID());
                    dersSilByDersID(id);
                    isaretci=isaretci.next;
                    break;
                }else{
                    isaretci=isaretci.next;
                    mevcutIndeks++;
                }
            }
        }else{
            System.out.println("Liste boş");
        }
    }

    /**
     * Disable ederken kaydettiğimiz id numarasını dersBul() metoduna parametre olarak gönderir.
     * dersBul() metodu geriye aradığımız dersi döndürür.
     * Dönen dersi indekseEkle() metoduyla eski indeksine kaydeder.
     * Enable eder
     * @param id
     */
    public void enable(int id ){
        if(disabledList.dersBul(id)!=null){
            Ders ders = disabledList.dersBul(id);
            indekseEkle(ders.dersAdi,ders.dersKodu,ders.somestrNo,ders.getLastIndex(),ders.getID());
            disabledList.dersSilByDersID(id);
        };
    }

    /**
     * DisabletList sınıfına kaydettiğimiz disabled durumunda olan dersleri listeler.
     */
    public void showDisabled(){
        System.out.println("Etkisizleştirilen dersler listesi : ");
        disabledList.listeyiYazdir();
    }

}