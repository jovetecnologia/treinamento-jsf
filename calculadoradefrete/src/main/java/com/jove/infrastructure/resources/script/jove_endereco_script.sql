DROP DATABASE IF EXISTS jove_endereco;

CREATE DATABASE jove_endereco;

USE jove_endereco;

CREATE TABLE tend_uf (
 uf VARCHAR(2) NOT NULL,
 estado VARCHAR(20) NOT NULL,
 codigo_ibge INT(10) NOT NULL
);

ALTER TABLE tend_uf ADD CONSTRAINT PK_tend_uf PRIMARY KEY (uf);


CREATE TABLE tend_regiao (
 id_regiao INT NOT NULL,
 regiao VARCHAR(50) NOT NULL,
 uf VARCHAR(2) NOT NULL
);

ALTER TABLE tend_regiao ADD CONSTRAINT PK_tend_regiao PRIMARY KEY (id_regiao);
ALTER TABLE tend_regiao MODIFY COLUMN id_regiao INT AUTO_INCREMENT;


CREATE TABLE tend_aliquota_icms (
 uf_origem VARCHAR(2) NOT NULL,
 uf_destino VARCHAR(2) NOT NULL,
 aliquota_icms DOUBLE NOT NULL
);

ALTER TABLE tend_aliquota_icms ADD CONSTRAINT PK_tend_aliquota_icms PRIMARY KEY (uf_origem,uf_destino);


CREATE TABLE tend_cidade (
 id_cidade INT(10) NOT NULL,
 cidade VARCHAR(100) NOT NULL,
 codigo_ibge INT(10) NOT NULL,
 id_regiao INT NOT NULL,
 somente_nfs BIT(0) NOT NULL,
 aliquota_iss DOUBLE NOT NULL,
 uf VARCHAR(2)
);

ALTER TABLE tend_cidade ADD CONSTRAINT PK_tend_cidade PRIMARY KEY (id_cidade);


CREATE TABLE tend_bairro (
 id_bairro INT(10) NOT NULL,
 bairro VARCHAR(50) NOT NULL,
 id_cidade INT(10) NOT NULL
);

ALTER TABLE tend_bairro ADD CONSTRAINT PK_tend_bairro PRIMARY KEY (id_bairro);


CREATE TABLE tend_endereco (
 cep VARCHAR(10) NOT NULL,
 endereco VARCHAR(200) NOT NULL,
 id_cidade INT(10) NOT NULL,
 id_bairro INT(10) NOT NULL
);

ALTER TABLE tend_endereco ADD CONSTRAINT PK_tend_endereco PRIMARY KEY (cep);


ALTER TABLE tend_regiao ADD CONSTRAINT FK_tend_regiao_0 FOREIGN KEY (uf) REFERENCES tend_uf (uf);


ALTER TABLE tend_aliquota_icms ADD CONSTRAINT FK_tend_aliquota_icms_0 FOREIGN KEY (uf_origem) REFERENCES tend_uf (uf);
ALTER TABLE tend_aliquota_icms ADD CONSTRAINT FK_tend_aliquota_icms_1 FOREIGN KEY (uf_destino) REFERENCES tend_uf (uf);


ALTER TABLE tend_cidade ADD CONSTRAINT FK_tend_cidade_0 FOREIGN KEY (id_regiao) REFERENCES tend_regiao (id_regiao);
ALTER TABLE tend_cidade ADD CONSTRAINT FK_tend_cidade_1 FOREIGN KEY (uf) REFERENCES tend_uf (uf);


ALTER TABLE tend_bairro ADD CONSTRAINT FK_tend_bairro_0 FOREIGN KEY (id_cidade) REFERENCES tend_cidade (id_cidade);


ALTER TABLE tend_endereco ADD CONSTRAINT FK_tend_endereco_0 FOREIGN KEY (id_cidade) REFERENCES tend_cidade (id_cidade);
ALTER TABLE tend_endereco ADD CONSTRAINT FK_tend_endereco_1 FOREIGN KEY (id_bairro) REFERENCES tend_bairro (id_bairro);
