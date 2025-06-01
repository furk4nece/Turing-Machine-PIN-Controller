# Turing-Machine-PIN-Controller

## Projenin Amacı
Bu proje, Turing makinesi kavramını kullanarak bir PIN doğrulama sistemi simüle ediyor. Kullanıcıdan alınan PIN, sistemde önceden tanımlı PIN ile karşılaştırılıyor.

## Projenin Çalıştırılması
Program, kullanıcıdan 4 haneli PIN alıyor. Daha sonra Turing makinesi bant formatına uygun olarak #USERPIN#SYSTEMPIN# şeklinde bir karakter dizisi oluşturuyor. Başlangıç durumu START ve ardından COMPARE durumu ile PIN’ler karşılaştırılıyor. Eğer her iki PIN’in tüm karakterleri eşleşirse, karakterler Y ile işaretleniyor. CHECK_END durumu, tüm rakamların başarıyla işaretlenip işaretlenmediğini kontrol ediyor. Eğer her şey doğruysa ACCEPT durumuna geçiliyor ve ‘Şifre doğru’ mesajı veriliyor. Aksi halde REJECT durumuna geçiliyor.

### Örnek Çıktı
![correct](https://github.com/user-attachments/assets/fb1e378c-98d7-42aa-83e1-5fdf0304f829) ![image](https://github.com/user-attachments/assets/bb1319e8-dd7e-43bf-830f-e993fd1f587a)

