package com.graphql.service.datafetcher;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.model.Book;
import com.graphql.repo.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AddBookDataMutation implements DataFetcher<Book> {
	private static Logger logger = LoggerFactory.getLogger(AddBookDataMutation.class);

    @Autowired
    BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("isn");
		logger.info(id);
		String title = environment.getArgument("title");
		String publisher = environment.getArgument("publisher");
		String author =  environment.getArgument("authors");
		String publishrDate = environment.getArgument("publisherDate");
		System.out.println(id);
		Book book = new Book();
		
		book.setIsn(id);
		book.setTitle(title);
		book.setPublisher(publisher);
		book.setAuthors(author);
		book.setPublishedDate(publishrDate);

		return bookRepository.save(book);
	}

	
}
