CREATE SCHEMA sistema_efeito;
USE sistema_efeito;

CREATE TABLE aluno(
	id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    data_nascimento DATE,
    sexo ENUM('masculino', 'feminino', 'nao-binario'),
    cpf VARCHAR(11),
    email VARCHAR(100),
    tipo_sanguineo ENUM('A', 'O', 'AB', 'B'),
    rh_sangue ENUM('positivo','negativo'),
    telefone VARCHAR (10),
    celular VARCHAR(12),
    rua VARCHAR (100),
    bairro VARCHAR (100),
    cidade VARCHAR (100)    
);


CREATE TABLE avaliacao_fisica(
	id_avaliacao INT AUTO_INCREMENT,
    id_aluno INT,
    data_avaliacao DATE,
    pressao_art DOUBLE,
    batimento_repouso DOUBLE,
    nivel_condicionamento ENUM('iniciante', 'intermediario', 'avançado'),
    
    PRIMARY KEY(id_avaliacao, id_aluno),
    FOREIGN KEY(id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE medidas(
	id_medidas INT AUTO_INCREMENT,
    id_aluno INT,
    data_medicao DATE,
	peso DOUBLE,
    altura DOUBLE,
    pescoco DOUBLE,
    peito DOUBLE, 
    braco DOUBLE, 
    antebraco DOUBLE,
    cintura DOUBLE,
    quadril DOUBLE,
    coxa DOUBLE,
    panturrilha DOUBLE,
    
    PRIMARY KEY(id_medidas, id_aluno),
    FOREIGN KEY(id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE plano(
	id_plano INT AUTO_INCREMENT,
    id_aluno INT,
    valor DOUBLE,
    data_inicio DATE,
    data_final DATE,
    
	PRIMARY KEY(id_plano, id_aluno),
    FOREIGN KEY(id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE pagamentos(
	id_pagamento INT AUTO_INCREMENT,
    id_plano INT,
    data_pagamento DATE,
    data_vencimento DATE,
    forma_pagamento ENUM('dinheiro', 'cartao de credito', 'cartao de debito', 'deposito', 'boleto'),
    
    PRIMARY KEY(id_pagamento, id_plano),
    FOREIGN KEY(id_plano) REFERENCES plano(id_plano)
);

CREATE TABLE treino(
	id_treino INT AUTO_INCREMENT,
    id_aluno INT,
    data_inicio DATE,
    
    PRIMARY KEY(id_treino, id_aluno),
    FOREIGN KEY(id_aluno) REFERENCES aluno(id_aluno)
);

CREATE TABLE cadastro_exercicio(
	id_exercicio INT AUTO_INCREMENT PRIMARY KEY,
    nome_exercicio VARCHAR(100),
    grupo_muscular varchar(100),
    acao_principal VARCHAR(300),
    posicao VARCHAR(150),
    observacao VARCHAR(500)
);

CREATE TABLE exercicios_treino(
	id_exercicio INT,
    id_treino INT,
    peso DOUBLE,
    serie INT,
    repeticao INT,
    duracao INT,
    
    PRIMARY KEY(id_exercicio, id_treino),
    FOREIGN KEY(id_treino) REFERENCES treino(id_treino),
    FOREIGN KEY(id_exercicio) REFERENCES cadastro_exercicio(id_exercicio)
);

CREATE TABLE personal(
    id_personal INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(61),
    cpf varchar(11) UNIQUE,
    cref VARCHAR(20),
    nome_usuario VARCHAR(30) UNIQUE,
    senha VARCHAR (30)
);