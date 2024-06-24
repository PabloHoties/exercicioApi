CREATE TABLE contato(
			idContato			SERIAL			PRIMARY KEY,
			nome				VARCHAR(100)	NOT NULL,
			email				VARCHAR(100)	UNIQUE NOT NULL,
			telefone				VARCHAR(15)		NOT NULL);