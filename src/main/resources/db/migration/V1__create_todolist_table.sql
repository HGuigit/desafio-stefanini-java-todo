CREATE TABLE todo (
        id INT PRIMARY KEY IDENTITY,
        titulo NVARCHAR(255) NOT NULL,
        descricao NVARCHAR(MAX),
        criado_em DATETIME DEFAULT GETDATE() NOT NULL ,
        atualizado_em DATETIME DEFAULT GETDATE() NOT NULL,
        status NVARCHAR(40) NOT NULL,
);
