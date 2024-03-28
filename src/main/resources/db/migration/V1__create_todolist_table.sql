CREATE TABLE todo (
        id INT PRIMARY KEY IDENTITY,
        titulo NVARCHAR(255) NOT NULL,
        descricao NVARCHAR(MAX),
        data_limite DATE,
        completa BIT DEFAULT 0,
        status NVARCHAR(20) DEFAULT 'Pendente',
        criado_em DATETIME DEFAULT GETDATE(),
        atualizado_em DATETIME DEFAULT GETDATE()
);
