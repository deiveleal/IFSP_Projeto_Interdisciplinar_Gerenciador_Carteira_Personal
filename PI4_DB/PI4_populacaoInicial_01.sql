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