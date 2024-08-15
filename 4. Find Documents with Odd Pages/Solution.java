import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Document{
    private int id;
    private String title;
    private String folderName;
    private int pages;

    public Document (int id, String title, String folderName, int pages) {
        this.id=id;
        this.title=title;
        this.folderName=folderName;
        this.pages=pages;
    }

    public int getId() {
    return id;
    }

    public String getTitle () {
    return title;
    }

    public String getFolderName () {
        return folderName;
    }
    
    public int getPages () {
        return pages;
    }
}

public class Solution {
    public static Document [] docsWithOddPages (Document [] docs) {
        List<Document> oddPageDocs = new ArrayList<> ();

        for (Document doc : docs) {
            if (doc.getPages ()>0 && doc.getPages () %2!=0) {
                oddPageDocs.add (doc);
            }
        }
        return oddPageDocs.toArray(new Document [oddPageDocs.size ()]);
    }

    public static void main (String args[] ){
        Scanner sc = new Scanner (System.in);
        Document [] documents = new Document [4];

        for (int i=0;i<4; i++){
            int id=sc.nextInt ();
            sc.nextLine ();
            String title=sc.nextLine ();
            String folderName=sc.nextLine();
            int pages=sc.nextInt () ;
            documents [i]=new Document (id, title, folderName, pages);
        }
        Document [] result = docsWithOddPages (documents) ;
        Arrays. sort (result, Comparator.comparingInt (Document:: getId));
        for (Document doc : result) {
            System.out.println(doc.getId()+" "+doc.getTitle ()+" "+doc.getFolderName ()+" "+doc.getPages ());
        }
        sc.close();
    }

}

/*

4. Find Documents with Odd Pages

Create class Document with below attributes 

id - int 
title - string
folderName - String
pages - int
Write getters, setters and parameterized constructor as required.

Create class Solution with main method

Implement static method - docsWithOddPages in Solution class.
This method will take array of Document objects and return another array with Document oblects which has odd number of pages.
This method should be called from main method and display values of returned oblects as shared in the sample - in ascending order of id attribute.

Before calling this method, use Scanner object to read values for four Document obiects referring attributes in the above sequence.
Next call the method and display the result.

Consider below sample input and output:

Input:

1
question1 
exams
50
2
question2
exams
55
3
question3
exams
45
4
India misc
40

Output: each line has values separated by single space:

2 question2 exams 55
3 question3 exams 45

Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextint(), nextDouble() etc.
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.
Consider below input values:
12
helloWorld

Referring below code:
Scanner sc = new Scanner (System.in);
int x = sc.nextint();
String str = sc.nextLine(); -> here we expect str to have value helloWorld. Instead it may be ""
If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.

 */