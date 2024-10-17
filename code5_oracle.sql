-- Criação da tabela Usuario
CREATE TABLE Usuario (
    ID_Usuario NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    Email VARCHAR2(100) UNIQUE NOT NULL,
    Senha VARCHAR2(255) NOT NULL,
    Data_Cadastro DATE DEFAULT SYSDATE
);

-- Criação da tabela Email
CREATE TABLE Email (
    ID_Email NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Assunto VARCHAR2(255) NOT NULL,
    Corpo CLOB NOT NULL,
    Data_Envio DATE DEFAULT SYSDATE,
    Status VARCHAR2(20) CHECK (Status IN ('Enviado', 'Recebido', 'Rascunho')),
    ID_Usuario_Envio NUMBER(10) NOT NULL,
    ID_Usuario_Recepcao NUMBER(10),
    FOREIGN KEY (ID_Usuario_Envio) REFERENCES Usuario(ID_Usuario),
    FOREIGN KEY (ID_Usuario_Recepcao) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Contato
CREATE TABLE Contato (
    ID_Contato NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    Email VARCHAR2(100) UNIQUE NOT NULL,
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Pasta
CREATE TABLE Pasta (
    ID_Pasta NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Anexo
CREATE TABLE Anexo (
    ID_Anexo NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(255) NOT NULL,
    Tipo VARCHAR2(50),
    Tamanho NUMBER,
    Dados BLOB,
    ID_Email NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Email) REFERENCES Email(ID_Email)
);

-- Tabela de Relacionamento Email-Pasta (muitos-para-muitos)
CREATE TABLE Email_Pasta (
    ID_Email NUMBER(10) NOT NULL,
    ID_Pasta NUMBER(10) NOT NULL,
    PRIMARY KEY (ID_Email, ID_Pasta),
    FOREIGN KEY (ID_Email) REFERENCES Email(ID_Email),
    FOREIGN KEY (ID_Pasta) REFERENCES Pasta(ID_Pasta)
);

-- Criação da tabela Rascunho
CREATE TABLE Rascunho (
    ID_Rascunho NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Assunto VARCHAR2(255) NOT NULL,
    Corpo CLOB NOT NULL,
    Data_Criacao DATE DEFAULT SYSDATE,
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Regras_Filtragem
CREATE TABLE Regras_Filtragem (
    ID_Regra NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    Condicao VARCHAR2(255) NOT NULL, -- Descrição da condição de filtragem
    Acao VARCHAR2(50) NOT NULL,      -- Ação a ser tomada (por exemplo, mover para pasta, marcar como lido)
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Condicoes
CREATE TABLE Condicoes (
    ID_Condicao NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Tipo_Condicao VARCHAR2(50) NOT NULL, -- Tipo de condição (por exemplo, assunto, remetente)
    Valor VARCHAR2(255) NOT NULL,        -- Valor que deve ser comparado
    ID_Regra NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Regra) REFERENCES Regras_Filtragem(ID_Regra)
);

-- Criação da tabela Acoes
CREATE TABLE Acoes (
    ID_Acao NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Tipo_Acao VARCHAR2(50) NOT NULL,   -- Tipo de ação (por exemplo, mover para pasta, marcar como lido)
    Detalhes VARCHAR2(255),             -- Detalhes adicionais sobre a ação
    ID_Regra NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Regra) REFERENCES Regras_Filtragem(ID_Regra)
);

-- Criação da tabela Configuracao_Usuario
CREATE TABLE Configuracao_Usuario (
    ID_Configuracao NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Usuario NUMBER(10) NOT NULL,
    Tema VARCHAR2(50),           -- Ex: "Escuro", "Claro"
    Cor_Primaria VARCHAR2(20),   -- Ex: "#FFFFFF", "#000000"
    Cor_Secundaria VARCHAR2(20), -- Ex: "#FF5733", "#C70039"
    Layout VARCHAR2(50),         -- Ex: "Padrão", "Compacto"
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Categoria
CREATE TABLE Categoria (
    ID_Categoria NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Rotulo
CREATE TABLE Rotulo (
    ID_Rotulo NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nome VARCHAR2(100) NOT NULL,
    Cor VARCHAR2(20), -- Ex: "#FF5733"
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Preferencia_Usuario
CREATE TABLE Preferencia_Usuario (
    ID_Preferencia NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Chave VARCHAR2(50) NOT NULL,  -- Nome da preferência (por exemplo, "Notificacoes_Email")
    Valor VARCHAR2(255) NOT NULL,  -- Valor da preferência
    ID_Usuario NUMBER(10) NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Criação da tabela Evento
CREATE TABLE Evento (
    ID_Evento NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Titulo VARCHAR2(255) NOT NULL,
    Descricao CLOB,
    Data_Inicio TIMESTAMP NOT NULL,
    Data_Fim TIMESTAMP NOT NULL,
    Localizacao VARCHAR2(255),
    Criado_Em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Atualizado_Em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Relacionamento entre Evento e Usuario (Criador do Evento)
ALTER TABLE Evento
ADD (ID_Usuario_Criador NUMBER(10),
     FOREIGN KEY (ID_Usuario_Criador) REFERENCES Usuario(ID_Usuario));

-- Relacionamento entre Evento e Categoria (um evento pode ter várias categorias)
CREATE TABLE Evento_Categoria (
    ID_Evento NUMBER(10) NOT NULL,
    ID_Categoria NUMBER(10) NOT NULL,
    PRIMARY KEY (ID_Evento, ID_Categoria),
    FOREIGN KEY (ID_Evento) REFERENCES Evento(ID_Evento),
    FOREIGN KEY (ID_Categoria) REFERENCES Categoria(ID_Categoria)
);

-- Relacionamento entre Evento e Rotulo (um evento pode ter vários rótulos)
CREATE TABLE Evento_Rotulo (
    ID_Evento NUMBER(10) NOT NULL,
    ID_Rotulo NUMBER(10) NOT NULL,
    PRIMARY KEY (ID_Evento, ID_Rotulo),
    FOREIGN KEY (ID_Evento) REFERENCES Evento(ID_Evento),
    FOREIGN KEY (ID_Rotulo) REFERENCES Rotulo(ID_Rotulo)
);

-- Relacionamento entre Evento e Anexo (um evento pode ter vários anexos)
CREATE TABLE Evento_Anexo (
    ID_Evento NUMBER(10) NOT NULL,
    ID_Anexo NUMBER(10) NOT NULL,
    PRIMARY KEY (ID_Evento, ID_Anexo),
    FOREIGN KEY (ID_Evento) REFERENCES Evento(ID_Evento),
    FOREIGN KEY (ID_Anexo) REFERENCES Anexo(ID_Anexo)
);

-- Índices para melhorar a performance das consultas
CREATE INDEX idx_usuario_email ON Usuario (Email);
CREATE INDEX idx_email_status ON Email (Status);
CREATE INDEX idx_email_data_envio ON Email (Data_Envio);
CREATE INDEX idx_contato_usuario ON Contato (ID_Usuario);
CREATE INDEX idx_pasta_usuario ON Pasta (ID_Usuario);
CREATE INDEX idx_anexo_email ON Anexo (ID_Email);
CREATE INDEX idx_regras_usuario ON Regras_Filtragem (ID_Usuario);
CREATE INDEX idx_condicoes_regra ON Condicoes (ID_Regra);
CREATE INDEX idx_acoes_regra ON Acoes (ID_Regra);
CREATE INDEX idx_categoria_usuario ON Categoria (ID_Usuario);
CREATE INDEX idx_rotulo_usuario ON Rotulo (ID_Usuario);
CREATE INDEX idx_preferencia_usuario ON Preferencia_Usuario (ID_Usuario);
CREATE INDEX idx_evento_data_inicio ON Evento(Data_Inicio);
CREATE INDEX idx_evento_data_fim ON Evento(Data_Fim);
