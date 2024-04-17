-- CADASTRANDO INFO PESSOAIS ADM --

INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('none', 0.0, 'Nenhum', 'admin_default');

-- CADASTRANDO ADM NA TABLE LOGIN ONLY ADMIN --

INSERT INTO admin_db(email, senha) VALUES ('admin@gmail.com', 'admin');

-- CADASTRANDO ADM LOGIN (GLOBAL TABLE) DEFAULT --

INSERT INTO login_db(matricula, email, senha) VALUES (0, 'admin@gmail.com', 'admin');

-- CADASTRANDO USUARIOS --

INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia) VALUES ('20240401', '1995-05-15', 'João Silva', 'Mensal', '123456789', 'M', 'Ativo');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia) VALUES ('20240402', '1995-05-15', 'Maria Silva', 'Trimestral', '123456790', 'F', 'Ativo');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia) VALUES ('20240403', '1995-05-15', 'Carlos Silva', 'Semestral', '123456791', 'M', 'Ativo');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia) VALUES ('20240404', '1995-05-15', 'Ana Silva', 'Anual', '123456792', 'F', 'Ativo');

-- CADASTRANDO PLANOS --

INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (20240401, 'joao.silva@example.com', 'João Silva', 'Mensal', '123456789');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (20240402, 'maria.silva@example.com', 'Maria Silva', 'Trimestral', '123456790');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (20240403, 'carlos.silva@example.com', 'Carlos Silva', 'Semestral', '123456791');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (20240404, 'ana.silva@example.com', 'Ana Silva', 'Anual', '123456792');
