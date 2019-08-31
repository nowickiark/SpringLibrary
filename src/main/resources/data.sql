INSERT INTO BOOK(id,author,title,date_of_return) VALUES (nextval('book_seq'), 'F. Scott Fitzgerald','The Great Gatsby', null);
INSERT INTO BOOK(id,author,title,date_of_return) VALUES(nextval('book_seq'),'Harper Lee','To Kill a Mockingbird', null);
INSERT INTO BOOK(id,author,title,date_of_return) VALUES(nextval('book_seq'),'George Orwell','1984', null);
INSERT INTO BOOK(id,author,title,date_of_return) VALUES(nextval('book_seq'),'J.D. Salinger','The Catcher in the Rye', null);
INSERT INTO BOOK(id,author,title,date_of_return) VALUES(nextval('book_seq'),'J.R.R. Tolkien','The Hobbit', null);

INSERT INTO USER(id,first_name, last_name) VALUES (nextval('user_seq'),'Jan','Kowalski');
INSERT INTO USER(id,first_name, last_name) VALUES (nextval('user_seq'),'Stefan','Burczymucha');


commit;