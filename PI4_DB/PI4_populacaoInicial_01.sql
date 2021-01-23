USE sistema_efeito;
INSERT INTO cadastro_exercicio(
    nome_exercicio,
    grupo_muscular,
    acao_principal,
    posicao,
    observacao)
VALUES
    ('Pernas', 'Rosca Femural', 'Flexão de joelho', 'Em pé','Em apoio unipodal, mantendo o quadril e o seguimento da coxa estabilizados, ira realizar o movimento de flexão e extensão de joelhos '),
    ('Pernas', 'Bom dia', 'Flexão de quadril', 'Em pé','com os pés  afastados, segurando uma barra sobre os ombros realiza-se uma flexão de quadril mantendo o tronco ereto e joelhos levemente fletidos.'),
    ('Pernas', 'Agachamento Búlgaro', 'Flexão e extensão de joelhos e quadril.', 'Em pé','segurando halteres em ambas as mãos e com um dos pés apoiados sobre um banco realize o movimento de agachamento.'),
	('Pernas', 'Passadas Duplas', 'Flexão e extensão de joelhos e quadril.', 'Em pé','com um dos pés a frente, busca-se uma amplitude que seja possível realizar a flexão de joelhos em 90º ou menos.Com os pés separado em uma posição anteroposterior realize um agachamento, quando o movimento estiver na fase de extensão de joelhos, ao chegar na metade do percurso, ou jesa ainda com os joelhos levemente fletidos, realize novamente outro agahamento, assim fazendo um agachameto com uma aplitude menor do que no primeiro.'),
    ('Pernas', 'Glúteo Cross', 'Extensão de quadril.', 'Em pé','Em apoio unipoldal realize uma flexão de quadril com a perna em suspensão presa ao cabo do cross over. O cabo deve preferencialmente ser conectado a perna na altura do tornozelo '),
    ('Pernas', 'Glúteo Graviton', 'Flexão e extensão de quadril e joelho.', 'Em pé','perna de apoio esticada, a outra perna forma um ângulo de 90º no banco do gráviton, onde realiza a extensão do joelho seguida da flexão.em  apoio unipodal a perna em elevação realiza um movimento de flexão de quadril e joelho, buscando o ângulo de 90° ou menor. Em seguida realiza a extensão de joelho da perna ainda em elevação, empurrando verticalmente a resistência contraria gerada pelo banco do gráviton.'),
    ('Pernas', 'Abdução Quadril Cross (cruzado)', 'Flexão e extensão de quadril e joelho.', 'Em pé com a lateral do corpo posicionada para o aparelho.','Mantenha o peso do corpo na perna de apoio com a articulação do joelho destravada. Eleve a perna, abduzindo o quadril numa amplitude possível.');
    
select * from cadastro_exercicio;

INSERT INTO aluno(
	nome, data_nascimento, sexo, cpf, 
    email, tipo_sanguineo, rh_sangue, 
    telefone, celular, rua, 
    bairro, cidade)
VALUES
	('João Carlos', '2000/03/25', 'masculino', '03265498724','joao@jotaum.com', 'A', 'positivo', '1932567412', '19852321654', 'Rua das Flores, 321', 'Jardim Novo', 'Joalandia'),
    ('Maria de Souza', '1991/12/12', 'feminino', '02165498752', 'maria@solzinha.com', 'B', 'negativo', '2121256523', '21789456123', 'Rua Litu, 12', 'Jardim Velhor', 'Joalandia'),
    ('Jessi de Oliveira', '2002/07/21', 'nao-binario', '04532198758', 'jessi@jotaum.com', 'AB', 'positivo', '2121257889', '21852741963', 'Rua Janguá, 25', 'Jardim Esplendor', 'Joanopolis'),
    ('Paula Campos', '2001/12/13', 'feminino', '08945612378', 'paulinha@jotaum.com', 'O', 'negativo', '2134569874', '21854978321', 'Rua Joá, 451', 'Jardim Novo', 'Joalandia'),
    ('Denis Drato', '1999/01/05', 'masculino', '06952456845', 'ddrato@solzinha.com', 'O', 'positivo', '2134569596', '21985654321', 'Rua das Uvas, 69', 'Jardim Novo Sonho', 'Joanopolis');
    
select * from aluno;

INSERT INTO avaliacao_fisica(
	id_aluno, data_avaliacao, 
    pressao_art, batimento_repouso,
    nivel_condicionamento
)
VALUES
	(1,'2020/01/23', 13.9, 82, 'iniciante'),
    (2,'2020/01/22', 12.8, 65, 'intermediario'),
    (3,'2020/01/19', 12.8, 68, 'iniciante'),
    (4,'2020/01/24', 12.8, 60, 'avançado'),
    (5,'2020/01/25', 12.8, 58, 'iniciante');
    
select * from avaliacao_fisica;
    
INSERT INTO personal (
	nome, cpf, nome_usuario, senha
)
VALUES
("Deive Audieres Leal", 06146045675, "deive", "123456"
);
select * from personal;

select * from medidas;  

select * from cadastro_exercicio;
    
    