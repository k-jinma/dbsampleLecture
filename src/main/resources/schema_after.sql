-- 出版社の情報を格納するテーブル
CREATE TABLE publishers (
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主キーとしてのID。自動で増加する
	name VARCHAR(255) NOT NULL -- 出版社の名前。NULLは許可されない
);

-- 書籍の情報を格納するテーブル
CREATE TABLE books (
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主キーとしてのID。自動で増加する
	title VARCHAR(255) NOT NULL, -- 書籍のタイトル。NULLは許可されない
	author VARCHAR(255) NOT NULL, -- 書籍の著者名。NULLは許可されない
	publisher_id INT, -- 出版社のID。出版社テーブルと関連付ける
	FOREIGN KEY (publisher_id) REFERENCES publishers(id) -- 出版社テーブルへの外部キー制約
);

-- 書籍に対するレビューを格納するテーブル
CREATE TABLE reviews (
	id INT PRIMARY KEY AUTO_INCREMENT, -- 主キーとしてのID。自動で増加する
	book_id INT NOT NULL, -- レビュー対象の書籍のID。NULLは許可されない
	review_text TEXT, -- レビューのテキスト。NULLは許可する
	FOREIGN KEY (book_id) REFERENCES books(id) -- 書籍テーブルへの外部キー制約
);