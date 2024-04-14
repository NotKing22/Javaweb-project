-- Cadastrando administrador default --

INSERT INTO admin_model(rg, salario, endereço, nome) values ('none', 0.0, 'Nenhum', 'admin_default');
INSERT INTO admin_db(email, senha) values ('admin@gmail.com', 'admin');

-- -=-=[X]=-=- --

-- Cadastrando login default --

INSERT INTO login_db(matricula, email, senha) values (0, 'admin@gmail.com', 'admin');

-- -=-=[X]=-=- --

-- CLIENTES INICIO --

INSERT INTO user_model (matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia)
VALUES ('20240401', '1995-05-15', 'João Silva', 'Mensal', '123456789', 'M', 'Ativo');

INSERT INTO user_model (matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia)
VALUES ('20240402', '1995-05-15','Maria Silva', 'Trimestral', '123456790', 'F', 'Ativo');

INSERT INTO user_model (matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia)
VALUES ('20240403', '1995-05-15','Carlos Silva', 'Semestral', '123456791', 'M', 'Ativo');

INSERT INTO user_model (matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia)
VALUES ('20240404', '1995-05-15', 'Ana Silva', 'Anual', '123456792', 'F', 'Ativo');

-- -=-=[X]=-=- --

-- CADASTRANDO PLANOS --

INSERT INTO user_plans (matricula, email, nome, plano_academia, rg)
VALUES ('20240401', 'joao.silva@example.com', 'João Silva', 'Mensal', '123456789');

INSERT INTO user_plans (matricula, email, nome, plano_academia, rg)
VALUES ('20240402', 'maria.silva@example.com', 'Maria Silva', 'Trimestral', '123456790');

INSERT INTO user_plans (matricula, email, nome, plano_academia, rg)
VALUES ('20240403', 'carlos.silva@example.com', 'Carlos Silva', 'Semestral', '123456791');

INSERT INTO user_plans (matricula, email, nome, plano_academia, rg)
VALUES ('20240404', 'ana.silva@example.com', 'Ana Silva', 'Anual', '123456792');

-- -=-=[X]=-=- --
