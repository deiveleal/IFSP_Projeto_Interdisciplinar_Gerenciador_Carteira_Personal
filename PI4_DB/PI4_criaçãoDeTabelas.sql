CREATE SCHEMA sistemaEfeito;
USE sistemaEfeito;

CREATE TABLE Aluno(
	idAluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    dataNascimento DATE,
    sexo ENUM('masculino', 'feminino', 'nao-buinario'),
    cpf VARCHAR(11),
    email VARCHAR(100),
    tipoSanguineo ENUM('A', 'O', 'AB', 'B'),
    rhSangue ENUM('+','-'),
    telefone VARCHAR (10),
    celular VARCHAR(12),
    rua VARCHAR (100),
    bairro VARCHAR (100),
    cidade VARCHAR (100)    
);


CREATE TABLE AvaliacaoFisica(
	idAvaliacao INT AUTO_INCREMENT,
    idAluno INT,
    dataAvaliacao DATE,
    peso DOUBLE,
    altura DOUBLE,
    pressaoArt DOUBLE,
    batimentoRepouso DOUBLE,
    nivelCondicionamento ENUM('iniciante', 'intermediario', 'avançado'),
    
    PRIMARY KEY(idAvaliacao, idAluno),
    FOREIGN KEY(idAluno) REFERENCES Aluno(idAluno)
);

CREATE TABLE Medidas(
	idMedidas INT AUTO_INCREMENT,
    idAluno INT,
    dataAvaliacao DATE,
    pescoco DOUBLE,
    peito DOUBLE, 
    braco DOUBLE, 
    antebraco DOUBLE,
    cintura DOUBLE,
    quadril DOUBLE,
    coxa DOUBLE,
    panturrilha DOUBLE,
    
    PRIMARY KEY(idMedidas, idAluno),
    FOREIGN KEY(idAluno) REFERENCES Aluno(idAluno)
);

CREATE TABLE Plano(
	idPlano INT AUTO_INCREMENT,
    idAluno INT,
    valor DOUBLE,
    dataInicio DATE,
    dataFinal DATE,
    
	PRIMARY KEY(idPlano, idAluno),
    FOREIGN KEY(idAluno) REFERENCES Aluno(idAluno)
);

CREATE TABLE Pagamentos(
	idPagamento INT AUTO_INCREMENT,
    idPlano INT,
    dataPagamento DATE,
    dataVencimento DATE,
    formaPagamento ENUM('dinheiro', 'cartao de credito', 'cartao de debito', 'deposito', 'boleto'),
    
    PRIMARY KEY(idPagamento, idPlano),
    FOREIGN KEY(idPlano) REFERENCES Plano(idPlano)
);

CREATE TABLE Treino(
	idTreino INT AUTO_INCREMENT,
    idAluno INT,
    dataInicio DATE,
    
    PRIMARY KEY(idTreino, idAluno),
    FOREIGN KEY(idAluno) REFERENCES Aluno(idAluno)
);

CREATE TABLE ListaExercicios(
	idExercicio INT AUTO_INCREMENT PRIMARY KEY,
    grupoMuscular varchar(100),
    nomeExercicio VARCHAR(100),
    acaoPrincipal VARCHAR(300),
    posicao VARCHAR(150),
    observacao VARCHAR(500)
);

CREATE TABLE ExerciciosTreino(
	idExercicio INT,
    idTreino INT,
    peso DOUBLE,
    serie INT,
    repeticao INT,
    
    PRIMARY KEY(idExercicio, idTreino),
    FOREIGN KEY(idTreino) REFERENCES Treino(idTreino),
    FOREIGN KEY(idExercicio) REFERENCES ListaExercicios(idExercicio)
);