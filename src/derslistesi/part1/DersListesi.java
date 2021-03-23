package derslistesi.part1;


public class DersListesi {
    Ders bas;
    Ders son;


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
     * @param dersKodu
     */
    public void next(String dersKodu) {
        if(doluMu()) {
            if(bas == son) {
                if (bas.dersKodu.equals(dersKodu)) {

                    System.out.println(bas.next);
                }
            }
            else{
                Ders isaretci = bas;
                if (bas == null) {
                    System.out.println("Liste  boş");
                } else {

                    while (true) {
                        //Compares node to be found with each node present in the list
                        if (isaretci.dersKodu.equals(dersKodu)) {
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
    public void listeBoyutu() {
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
    public void somestrAra(int no) {
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
                    //Compares node to be found with each node present in the list
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
     * Ders kodu girilen dersin
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

}