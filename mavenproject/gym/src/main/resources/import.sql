-- CADASTRANDO INFO PESSOAIS ADM --

INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('none', 0.0, 'Nenhum', 'admin_default');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('123456789', 5000.0, 'Rua Principal', 'Administrador 1');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('987654321', 6000.0, 'Rua Secundária', 'Administrador 2');
INSERT INTO admin_model(rg, salario, endereço, nome) VALUES ('654321987', 5500.0, 'Avenida Central', 'Administrador 3');

-- CADASTRANDO ADM NA TABLE LOGIN ONLY ADMIN --
INSERT INTO admin_db(email, senha) VALUES ('admin@gmail.com', 'admin');

-- CADASTRANDO ADM LOGIN (GLOBAL TABLE LOGIN) DEFAULT --
INSERT INTO login_db(matricula, email, senha) VALUES (0, 'admin@gmail.com', 'admin');

INSERT INTO login_db(matricula, email, senha) VALUES ('2024040101', 'joao.silva@example.com', '123456789');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040102', 'maria.oliveira@example.com', '987654321');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040103', 'pedro.santos@example.com', '654321987');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040104', 'ana.oliveira@example.com', '789654123');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040105', 'marcos.silva@example.com', '159357852');
INSERT INTO login_db(matricula, email, senha) VALUES ('2024040106', 'juliana.santos@example.com', '357951846');

-- CADASTRANDO USUARIOS --
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040101', '1995-05-15', 'João Silva', 'Mensal', '123456789', 'Masculino', 'Ativo', 'Casa');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040102', '1987-08-25', 'Maria Oliveira', 'Trimensal', '987654321', 'Feminino', 'Pendente', 'Rua A');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040103', '2000-02-10', 'Pedro Santos', 'Semestral', '654321987', 'Masculino', 'Inativo', 'Av. Principal');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040104', '1992-11-30', 'Ana Oliveira', 'Anual', '789654123', 'Feminino', 'Ativo', 'Rua B');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040105', '1985-07-18', 'Marcos Silva', 'Mensal', '159357852', 'Masculino', 'Pendente', 'Rua C');
INSERT INTO user_model(matricula, data_nascimento, nome_completo, plano_academia, rg, sexo, status_academia, endereço) VALUES ('2024040106', '1998-04-05', 'Juliana Santos', 'Trimensal', '357951846', 'Feminino', 'Inativo', 'Av. Central');

-- CADASTRANDO PLANOS --
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040101, 'joao.silva@example.com', 'João Silva', 'Mensal', '123456789');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040102, 'maria.oliveira@example.com', 'Maria Oliveira', 'Trimensal', '987654321');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040103, 'pedro.santos@example.com', 'Pedro Santos', 'Semestral', '654321987');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040104, 'ana.oliveira@example.com', 'Ana Oliveira', 'Anual', '789654123');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040105, 'marcos.silva@example.com', 'Marcos Silva', 'Mensal', '159357852');
INSERT INTO user_plans(matricula, email, nome, plano_academia, rg) VALUES (2024040106, 'juliana.santos@example.com', 'Juliana Santos', 'Trimensal', '357951846');
