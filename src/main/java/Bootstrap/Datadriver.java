package Bootstrap;

import Repository.AuthorRepository;
import Repository.BookRepository;
import dataModal.Author;
import dataModal.Books;
import org.springframework.context.ApplicationListener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Datadriver implements ApplicationListener<ContextRefreshedEvent> {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public Datadriver(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
          dataInit();
    }

    private void dataInit() {

        Author visal = new Author("Visal", "Kumar");
        Books WrittenByVisal = new Books("ThE dAy I LeFt", "5546", "vktk");
        visal.getBooks().add(WrittenByVisal);
        WrittenByVisal.getAuthors().add(visal);
        authorRepository.save(visal);
        bookRepository.save(WrittenByVisal);


        Author shalini = new Author("shalini", "Kumar");
        Books WrittenByShalini = new Books("Nick & Nicky", "6786", "GijTi Publisher");
        shalini.getBooks().add(WrittenByShalini);
        WrittenByShalini.getAuthors().add(shalini);
        authorRepository.save(shalini);
        bookRepository.save(WrittenByShalini);

    }

}
