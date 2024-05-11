-- CADASTRANDO INFO PESSOAIS ADM --
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('none', 0.0, 'Nenhum', 'admin_default');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('123.456-789-10', 5000.0, 'Rua Principal', 'Administrador 1');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('987.654-321-10', 6000.0, 'Rua Secundária', 'Administrador 2');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('654.321-987-10', 5500.0, 'Avenida Central', 'Administrador 3');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('443.321-987-10', 5500.0, 'Avenida Baixa', 'Administrador 4');

-- CADASTRANDO ADM NA TABLE LOGIN ONLY ADMIN --
INSERT INTO admin_db(email, senha) VALUES ('admin@gmail.com', 'admin');
INSERT INTO admin_db(email, senha) VALUES ('adm1@gmail.com', 'admin');
INSERT INTO admin_db(email, senha) VALUES ('adm2@gmail.com', 'admin');
INSERT INTO admin_db(email, senha) VALUES ('adm3@gmail.com', 'admin');
INSERT INTO admin_db(email, senha) VALUES ('adm4@gmail.com', 'admin');

-- CADASTRANDO LOGINS DEFAULT --
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040101', 'joao.silva@example.com', 'senha1');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040102', 'maria.oliveira@example.com', 'senha1');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040103', 'pedro.santos@example.com', 'senha1');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040104', 'ana.oliveira@example.com', 'senha1');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040105', 'marcos.silva@example.com', 'senha1');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040106', 'juliana.santos@example.com', 'senha1');

-- CADASTRANDO DADOS USUARIOS --
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040101', '1995-05-15', 'João Silva', 'Mensal', '123.456.789-10', 'Masculino', 'Ativo', 'Casa');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040102', '1987-08-25', 'Maria Oliveira', 'Trimestral', '987.654.321-10', 'Feminino', 'Pendente', 'Rua A');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040103', '2000-02-10', 'Pedro Santos', 'Semestral', '654.321.987-10', 'Masculino', 'Inativo', 'Av. Principal');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040104', '1992-11-30', 'Ana Oliveira', 'Anual', '789.654.123-10', 'Feminino', 'Ativo', 'Rua B');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040105', '1985-07-18', 'Marcos Silva', 'Mensal', '159.357.852-10', 'Masculino', 'Pendente', 'Rua C');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040106', '1998-04-05', 'Juliana Santos', 'Trimestral', '357.951.846-10', 'Feminino', 'Inativo', 'Av. Central');

-- CADASTRANDO PLANOS USUARIOS --
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040101, 'joao.silva@example.com', 'João Silva', 'Mensal', '123.456.789-10');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040102, 'maria.oliveira@example.com', 'Maria Oliveira', 'Trimestral', '987.654.321-10');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040103, 'pedro.santos@example.com', 'Pedro Santos', 'Semestral', '654.321.987-10');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040104, 'ana.oliveira@example.com', 'Ana Oliveira', 'Anual', '789.654.123-10');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040105, 'marcos.silva@example.com', 'Marcos Silva', 'Mensal', '159.357.852-10');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040106, 'juliana.santos@example.com', 'Juliana Santos', 'Trimestral', '357.951.846-10');
