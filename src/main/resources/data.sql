DROP TABLE IF EXISTS dados;

CREATE TABLE dados (
  id INT AUTO_INCREMENT PRIMARY KEY,
  numero_aleatorio BIGINT NOT NULL,
  descricao VARCHAR(250) NOT NULL,
  creation_date TIMESTAMP NOT NULL,
  modification_date TIMESTAMP NOT NULL
);

INSERT INTO dados (numero_aleatorio, descricao, creation_date, modification_date) VALUES
(1, 'Descricao Teste 1', '2020-08-02 11:11:11', '2020-08-02 11:11:11'),
(11111, 'Descricao Teste 2', '2020-08-02 11:11:11', '2020-08-02 11:11:11'),
(1111111111, 'Descricao Teste 3', '2020-08-02 11:11:11', '2020-08-02 11:11:11');