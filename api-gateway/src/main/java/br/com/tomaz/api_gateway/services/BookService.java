package br.com.tomaz.api_gateway.services;


import br.com.tomaz.api_gateway.controllers.BookController;
import br.com.tomaz.api_gateway.data.vo.v1.BookVO;
import br.com.tomaz.api_gateway.exceptions.ResourceNotFoundException;
import br.com.tomaz.api_gateway.mapper.ModelMapper;
import br.com.tomaz.api_gateway.model.Book;
import br.com.tomaz.api_gateway.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    private Logger logger = Logger.getLogger(BookService.class.getName());

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public List<BookVO> findAll() {
        logger.info("Finding all books");

        var books = ModelMapper.parseListObjects(repository.findAll(), BookVO.class);

        books.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return books;
    }

    public BookVO findById(Long id) {
        logger.info("Finding one book ");

        var entity = repository.findById(id);

        var vo = ModelMapper.parseObject(entity, BookVO.class);

        vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return vo;
    }

    public BookVO create(BookVO bookVO) {
        logger.info("Creating a book ");

        var entity = ModelMapper.parseObject(bookVO, Book.class);

        var vo = ModelMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public BookVO update(BookVO bookVO) {
        logger.info("Updating a book ");

        Book entity = repository.findById(bookVO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setAutor(bookVO.getAutor());
        entity.setLaunchDate(bookVO.getLaunchDate());
        entity.setPrice(bookVO.getPrice());
        entity.setTitle(bookVO.getTitle());

        var vo = ModelMapper.parseObject(repository.save(entity), BookVO.class);
        vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(long id) {
        logger.info("Deleting one book ");

        Book entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

}
