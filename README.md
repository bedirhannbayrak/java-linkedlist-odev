
# BLM 2002 ÖDEV

**Part 1:** Marmara Üniversitesi Bilgisayar Mühendisliği Derslerini içeren bir Linked List yapısı oluşturunuz. Liste ders isimlerini, ders kodlarını, sömestr bilgilerini ve gerekli diğer değişkenleri içermelidir. Bu liste yapısını oluşturduktan sonra aşağıdaki 3 metodu yazınız.
1. getByCode(string code): Ders kodu verilen tüm dersleri döndürür.
2. listSemesterCourses(int semester): Verilen sömestrdaki tüm dersleri döndürür.
3.  getByRange(in start_index, int last_index): Verilen indexler arasındaki tüm dersleri döndürür.

Ayrıca aşağıdaki metotların bulunması zorunludur.
1. Add(): Listeye liste ögesi ekler.
2. Remove(): Listeden belirtilen liste ögesi silinir.
3. Next(): Sonraki liste ögesini gösterir.
4. NextInSemester(): Aynı sömestrdaki bir sonraki liste ögesini gösterir.
5. Size(): Liste boyutunu döndürür.

**Part 2:** Yukarıda oluşturduğunuz Linked List yapısına erişim için aşağıdaki metotları yazınız.
1. Disable(): Herhangi bir liste ögesini devre dışı bırakır. Devre dışı bırakılan liste ögesi get, set, size, remove gibi yöntemlere erişememelidir.
2. Enable(): Devre dışı bırakılmış herhangi bir liste ögesini etkinleştirir.
3. showDisabled(): Devre dışı bırakılan tüm liste ögelerini gösterir. Not: Devre dışı bırakılan liste ögesi etkinleştirildiğinde ögenin yine aynı konumda bulunması gerekmektedir.

**Part 3:** Yeni bir ders listesi oluşturunuz. Bu listede liste ögeleri arasındaki linklerin yanı sıra aynı sömestra ait dersler birbirine circular şeklinde bağlanmalıdır. Örnek listeyi aşağıdaki şekilde inceleyebilirsiniz.

<hr>

### KISITLAR:
- Projede sadece bir ana sınıf olmalıdır. - Ek kütüphane kullanılamaz. - Ödevlerde Geç gönderim kabul edilmeyecektir.
- 2 gün gecikme ile geç gönderimler 60 üzerinden değerlendirilecektir. - Gönderim dosya ismi= ogrencino.zip şeklinde olmalıdır. Bu dosya içinde ödev raporu olmalıdır.
- Ödev 3 kısımdan oluşmaktadır. Rapor, Uygulama(Kod) ve javadoc - Rapor kısmında proje raporu olmalıdır. Kod, UML diyagramı ve genel açıklamalar. Rapor %30 puan etkisindedir.
-  Uygulama kısmında kod çalışır ve compile edilebilir olmalıdır. Compile edilemeyen kodlardan 30 puan kırılacaktır. Test ve kaynak kodu birlikte gönderilmelidir. Sınıflar, yöntemler ve değişken adları anlamlı olmalıdır. fonksiyon ve sınıflarınız basit, genel, yeniden kullanılabilir olmalıdır.
-  Kod %70 değerindedir. - Javadoc Bölümü: sınıflar, yöntemler, değişkenler vb. İçin tüm javadoc açıklamaları eklenmelidir.tüm açıklamalar anlamlı ve anlaşılır olmalıdır. standart java kod adı kurallarını kullanılmalıdır. Bu kısım ekstra 20 puan değerindedir.

