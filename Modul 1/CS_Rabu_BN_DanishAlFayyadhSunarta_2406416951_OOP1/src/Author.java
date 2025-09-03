public class Author {
    public String nama;
    public int tahunLahir;

    public Author(String nama, int tahunLahir){
        this.nama = nama;
        this.tahunLahir = tahunLahir;
    }

    public void showDetail(){
        System.out.printf("Nama Author : %s\n", nama);
        System.out.printf("Tahun Lahir : %d\n", tahunLahir);
    }
}
