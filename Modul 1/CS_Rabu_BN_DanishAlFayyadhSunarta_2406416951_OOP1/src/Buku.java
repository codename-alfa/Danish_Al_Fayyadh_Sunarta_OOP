public class Buku {
    public String judul;
    public int year;
    public BookGenre genre;
    public Author author;

    public Buku(String judul, int year, BookGenre genre, Author author){
        this.judul = judul;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    int getAuthorCurrentAge(){
        return year - author.tahunLahir;
    }

    void showDetail(){
        System.out.printf("Judul: %s\n", judul);
        System.out.println("Genre: " + genre);
        System.out.printf("Tahun Terbit: %d\n", year);
        System.out.println("Nama Authot: " + author.nama);
        System.out.printf("Usia Author Saat Buku Diterbikan: %d\n", getAuthorCurrentAge());
    }
}
