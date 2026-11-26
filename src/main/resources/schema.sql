CREATE TABLE IF NOT EXISTS semente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco_por_kg DECIMAL(10,2) NOT NULL,
    estoque_kg DOUBLE NOT NULL
);

CREATE TABLE IF NOT EXISTS agricultor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL,
    endereco_entrega VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    agricultor_id BIGINT NOT NULL,
    semente_id BIGINT NOT NULL,
    quantidade_kg DOUBLE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (agricultor_id) REFERENCES agricultor(id),
    FOREIGN KEY (semente_id) REFERENCES semente(id)
);