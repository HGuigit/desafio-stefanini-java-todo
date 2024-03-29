CREATE TABLE todoStatus (
    id INT PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
)

CREATE TABLE todo (
        id INT PRIMARY KEY IDENTITY,
        titulo NVARCHAR(255) NOT NULL,
        descricao NVARCHAR(MAX),
        criado_em DATETIME DEFAULT GETDATE(),
        atualizado_em DATETIME DEFAULT GETDATE(),
        status_id INT,
        FOREIGN KEY (status_id) REFERENCES todoStatus(id)
);
