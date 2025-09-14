-- Insert data into publishers table
INSERT INTO publishers (name) VALUES ('Gijutsu Hyoronsha');
INSERT INTO publishers (name) VALUES ('Technology Hyoronsha');

-- Insert data into books table
INSERT INTO books (title, author, publisher_id) VALUES ('Common Situations in New Employee Training', 'Taro Yamada', 1);
INSERT INTO books (title, author, publisher_id) VALUES ('DB Engineers You Dont Want to Work With', 'Hanako Sato', 2);
INSERT INTO books (title, author, publisher_id) VALUES ('Real Troubles in the IT Industry', 'Ichiro Suzuki', 1);

-- Insert data into reviews table
INSERT INTO reviews (book_id, review_text) VALUES (1, 'This book was very helpful.');
INSERT INTO reviews (book_id, review_text) VALUES (2, 'I was shocked that such DB engineers exist.');
INSERT INTO reviews (book_id, review_text) VALUES (2, 'I hope they never come to my workplace.');
INSERT INTO reviews (book_id, review_text) VALUES (2, 'There is someone like this at my workplace...');
INSERT INTO reviews (book_id, review_text) VALUES (3, 'A good book to learn about the dark side of the IT industry.');