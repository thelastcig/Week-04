import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
@interface Author {
    String name();
}


@Author(name = "Sonu Sharma")
class Book {
    
}


public class AnnotationProcessor {
    public static void main(String[] args) {
        
        Class<Book> bookClass = Book.class;
        
       
        if (bookClass.isAnnotationPresent(Author.class)) {
            
            Author authorAnnotation = bookClass.getAnnotation(Author.class);
            
            System.out.println("Author Name: " + authorAnnotation.name());
        } else {
            System.out.println("No @Author annotation found.");
        }
    }
}
