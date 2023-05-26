drop table if exists books_authors cascade;
drop table if exists books_genres cascade;
drop table if exists authors cascade;
drop table if exists books cascade;
drop table if exists genres cascade;

create table books
(
    id          uuid not null,
    title       varchar(255),
    total_pages integer,
    year        date,
    primary key (id)
);

create table authors
(
    id         uuid not null,
    birthday   date,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

create table genres
(
    id   uuid not null,
    name varchar(255),
    primary key (id)
);

create table books_authors
(
    book_id   uuid not null,
    author_id uuid not null
);

create table books_genres
(
    genre_id uuid not null,
    book_id  uuid not null
);

alter table if exists books_authors add constraint FK3qua08pjd1ca1fe2x5cgohuu5 foreign key (author_id) references authors;
alter table if exists books_authors add constraint FK1b933slgixbjdslgwu888m34v foreign key (book_id) references books;
alter table if exists books_genres add constraint FKlv42b6uemg63q27om39jjbt9o foreign key (book_id) references books;
alter table if exists books_genres add constraint FKgkat05y2cec3tcpl6ur250sd0 foreign key (genre_id) references genres;

insert into books values ('123e4567-e89b-12d3-a456-426655440000', 'Преступление и наказание', 777, '2014-12-11');
insert into authors values ('123e4567-e89b-12d3-a456-426655440011', '1860-10-02', 'Федор', 'Достоевский');
insert into genres values ('123e4567-e89b-12d3-a456-426655440022', 'Роман');
insert into books_authors values ('123e4567-e89b-12d3-a456-426655440000', '123e4567-e89b-12d3-a456-426655440011');
insert into books_genres values ('123e4567-e89b-12d3-a456-426655440022', '123e4567-e89b-12d3-a456-426655440000');

