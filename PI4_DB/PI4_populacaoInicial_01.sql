INSERT INTO ListaExercicios(
    grupoMuscular,
    nomeExercicio,
    acaoPrincipal,
    posicao,
    observacao)
VALUES
    ('Pernas', 'Rosca Femural', 'Flexão de joelho', 'Em pé','Em apoio unipodal, mantendo o quadril e o seguimento da coxa estabilizados, ira realizar o movimento de flexão e extensão de joelhos '),
    ('Pernas', 'Bom dia', 'Flexão de quadril', 'Em pé','com os pés  afastados, segurando uma barra sobre os ombros realiza-se uma flexão de quadril mantendo o tronco ereto e joelhos levemente fletidos.'),
    ('Pernas', 'Agachamento Búlgaro', ' Flexão e extensão de joelhos e quadril.', 'Em pé','segurando halteres em ambas as mãos e com um dos pés apoiados sobre um banco realize o movimento de agachamento.'),
	('Pernas', 'Passadas Duplas', ' Flexão e extensão de joelhos e quadril.', 'Em pé','perna de apoio esticada, a outra perna forma um ângulo de 90º no banco do gráviton, onde realiza a extensão do joelho seguida da flexão.em  apoio unipodal a perna em elevação realiza um movimento de flexão de quadril e joelho, buscando o ângulo de 90° ou menor. Em seguida realiza a extensão de joelho da perna ainda em elevação, empurrando verticalmente a resistência contraria gerada pelo banco do gráviton.');
    
select * from ListaExercicios;

INSERT INTO Aluno(
	nome, dataNascimento, sexo, cpf, 
    email, tipoSanguineo, rhSangue, 
    telefone, celular, rua, 
    bairro, cidade)
VALUES
	('João Carlos', '2000/03/25', 'masculino', '03265498724','joao@jotaum.com', 'A', '+', '1932567412', '19852321654', 'Rua das Flores, 321', 'Jardim Novo', 'Joalandia'),
    ('Maria de Souza', '1991/12/12', 'feminino', '02165498752', 'maria@solzinha.com', 'B', '-', '2121256523', '21789456123', 'Rua Litu, 12', 'Jardim Velhor', 'Joalandia'),
    ('Jessi de Oliveira', '2002/07/21', 'nao-buinario', '04532198758', 'jessi@jotaum.com', 'AB', '-', '2121257889', '21852741963', 'Rua Janguá, 25', 'Jardim Esplendor', 'Joanopolis'),
    ('Paula Campos', '2001/12/13', 'feminino', '08945612378', 'paulinha@jotaum.com', 'O', '-', '2134569874', '21854978321', 'Rua Joá, 451', 'Jardim Novo', 'Joalandia'),
    ('Denis Drato', '1999/01/05', 'masculino', '06952456845', 'ddrato@solzinha.com', 'O', '+', '2134569596', '21985654321', 'Rua das Uvas, 69', 'Jardim Novo Sonho', 'Joanopolis');
    
select * from Aluno;

INSERT INTO AvaliacaoFisica(
	idAluno, dataAvaliacao, peso,
    altura, pressaoArt, batimentoRepouso,
    nivelCondicionamento
)
VALUES
	(21,'2020/01/23', 83.0, 1.60, 13.9, 82, 'iniciante'),
    (22,'2020/01/22', 82.0, 1.80, 12.8, 65, 'intermediario'),
    (23,'2020/01/19', 72.0, 1.70, 12.8, 68, 'iniciante'),
    (24,'2020/01/24', 93.0, 1.80, 12.8, 60, 'avançado'),
    (25,'2020/01/25', 55.0, 1.53, 12.8, 58, 'iniciante'),
    (22,'2020/04/22', 82.4, 1.80, 12.8, 65,'intermediario'),
    (24,'2020/04/24', 93.6, 1.80, 12.8, 60, 'avançado');
    
select * from AvaliacaoFisica;
    
    
    
    
    
    