package com.homedev.mvp.model.entity;

import com.homedev.mvp.model.IAuthorsConverter;
import com.homedev.mvp.model.IName;

import java.util.ArrayList;
import java.util.List;

public class Book implements IName, IAuthorsConverter {
    private int id;
    private String name;
    private int year;
    private List<Author> authors = new ArrayList();
    private int pages;
    private String edition;
    private String description;

    private Book() {
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getPages() {
        return pages;
    }

    private void setPages(int pages) {
        this.pages = pages;
    }

    public String getEdition() {
        return edition;
    }

    private void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthorsText() {
        final StringBuilder strBuilder = new StringBuilder();

        for (Author it : authors) {
            if (strBuilder.length() > 0) {
                strBuilder.append(", ");
            }
            boolean hasPrev = false;

            if (it.getLastname() != null) {
                strBuilder.append(it.getLastname());
                hasPrev = true;
            }
            if (it.getName() != null) {
                if (hasPrev) {
                    strBuilder.append(" ");
                }
                strBuilder.append(it.getName());
                hasPrev = true;
            }
            if (it.getSurname() != null) {
                if (hasPrev) {
                    strBuilder.append(" ");
                }
                strBuilder.append(it.getSurname());
            }
        }
        return strBuilder.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", authors='" + getAuthorsText() + "'" +
                ", pages=" + pages +
                ", edition='" + edition + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {
        private Book book;

        public Builder() {
            book = new Book();
        }

        public Builder setId(int id) {
            book.setId(id);
            return this;
        }

        public Builder setName(String name) {
            book.setName(name);
            return this;
        }

        public Builder setYear(int year) {
            book.setYear(year);
            return this;
        }

        public Builder addAuthor(Author author) {
            book.authors.add(author);
            return this;
        }

        public Builder setPages(int pages) {
            book.setPages(pages);
            return this;
        }

        public Builder setEdition(String edition) {
            book.setEdition(edition);
            return this;
        }

        public Builder setDescription(String description) {
            book.setDescription(description);
            return this;
        }

        public Book create() {
            return book;
        }
    }
}
