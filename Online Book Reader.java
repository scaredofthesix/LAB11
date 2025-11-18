import java.util.*;
class Book{
    String name;
    String author;
    public Book(String name,String author){
        this.name = name;
        this.author = author;
    }
    public void showbook(){
        System.out.println(name + " - " + author);
    }
}

class Library{
    List<Book> lib;
    List<Book> home;
    boolean haspremium = false;
    public Library(List<Book> lib,List<Book> home){
        this.lib = lib;
        this.home = home;
    }
    public void adding(Book x){
        lib.add(x);
    }
    public void choice(int n){
        lib.get(n).showbook();
    }
    public void getlibrary(){
        for(int i = 0;i < lib.size();i++){
            lib.get(i).showbook();
        }
    }
    public void choosebook(int n){
        home.add(lib.get(n));
        lib.remove(n);
        System.out.println("book added");
    }
    public void buypremium(){
        this.haspremium = true;
        System.out.println("Premium active on your account");
    }
    public boolean haspremium(){
        return haspremium;
    }
    public void home(){
        System.out.println("Your boooks:");
        for (Book x:home){
            x.showbook();
        }
    }
}


public class LAB{
    public static void main(String[] arg){
        List<Book> a = new ArrayList<>();
        List<Book> h = new ArrayList<>();
        Library library = new Library(a, h);
        Scanner s = new Scanner(System.in);
        library.adding(new Book("The Shining (1977)","Stephen King"));
        library.adding(new Book("IT","Stephen King"));
        library.adding(new Book("1984"," George Orwell"));
        library.adding(new Book("The Hobbit"," J.R.R.Tolkien"));
        library.adding(new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling"));
        boolean ok = true;
        while(ok){
            System.out.println("1. show library");
            System.out.println("2. buy premium");
            System.out.println("3. take a book");
            System.out.println("4. my books");
            System.out.println("5. exit");
            System.out.print("Choose:");
            int x = s.nextInt();
            switch(x){
                case 1:
                    library.getlibrary();
                    break;
                case 2:
                    library.buypremium();
                    break;
                case 3:
                    if (library.haspremium()){
                        System.out.println("Choose book");
                        int n = s.nextInt();
                        library.choosebook(n - 1);
                        break;
                }
                    else{
                        System.out.println("BUY P R E M I U M");
                    }
                case 4:
                    library.home();
                    break;
                case 5:
                    ok = false;
                    break;
            }
            }
        }
}
