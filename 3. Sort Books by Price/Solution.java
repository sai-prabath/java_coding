import java.util.*;

class Book{
    private int id;
    private String title;
    private String author;
    private double price;

    public Book(int id, String title, String author, double price){
        this.id=id;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor () {
        return author;
    }
        
    public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return id+" "+title+" "+author+" "+price;
    }
}

public class Solution {
    public static Book[] sortBooksByPrice(Book[] books) {
        Arrays.sort(books, new Comparator<Book>(){
            @Override
            public int compare (Book b1, Book b2) {
                return Double.compare (b1.getPrice(), b2.getPrice());
            }
        });
        return books;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];

        for (int i=0;i<4;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String title=sc.nextLine();
            String author=sc.nextLine();
            double price=sc.nextDouble();
            books[i] = new Book(id, title, author, price);
        }

        Book[] sortedBooks = sortBooksByPrice(books);
        for(Book book : sortedBooks){
            System.out.println(book);
        }
    }
}


/*
 
3. Sort Books by Price

Create class Book with below attributes:

id - int 
title - String 
author - String 
price - double

- Write getters, setters and parameterized constructor.

Create class solution with main method.

Implement static method - sortBooksByPrice in Solution Class.
- This method will take a parameter as array of Book objects.
- It will return array of books which is sorted in ascending order of book price. 
- Assume that no two books will have same price
- This method should be called from main method and display values of returned objects as shared in the sample.

- Before calling this method, use Scanner object to read values for four Book objects referring attributes in the above sequence.
- Next call the method and display the result.

Input:

1
hello
writer1
50
2
cup
writer2
55
3
Planet
writer3
45
4
India
writer
40

Output (each line has values separated by single space):

4 India writer4 40.0
3 Planet writer3 45.0
1 hello writer1 50.0
2 cup writer2 55.0

Note on using scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextint(), nextDouble() etc.
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

 */