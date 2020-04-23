package com.homedev.mvp.model.entity;

import com.homedev.mvp.model.IAgeConverter;
import com.homedev.mvp.model.IName;

public class Author implements IName, IAgeConverter {
    private int id;
    private String name;
    private String lastname;
    private String surname;
    private long birthday;

    private Author() {
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

    public String getLastname() {
        return lastname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthday() {
        return birthday;
    }

    private void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAge() {
        return String.valueOf(birthday);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static class Builder {
        private Author author;

        public Builder() {
            author = new Author();
        }

        public Builder setId(int id) {
            author.setId(id);
            return this;
        }

        public Builder setName(String name) {
            author.setName(name);
            return this;
        }

        public Builder setLastname(String lastname) {
            author.setLastname(lastname);
            return this;
        }

        public Builder setSurname(String surname) {
            author.setSurname(surname);
            return this;
        }

        public Builder setBirthday(long birthday) {
            author.setBirthday(birthday);
            return this;
        }

        public Author create() {
            return author;
        }
    }
}
