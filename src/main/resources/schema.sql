-- Creacion de db y tablas
CREATE DATABASE IF NOT EXISTS almacen_db;
USE almacen_db;

CREATE TABLE categorias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

CREATE TABLE proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    documento VARCHAR(20) NOT NULL UNIQUE, -- RUC, NIT o DNI
    nombre_empresa VARCHAR(150) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    nombre VARCHAR(150) NOT NULL,
    precio DOUBLE NOT NULL,
    stock_actual INT NOT NULL DEFAULT 0,
    categoria_id BIGINT,
    proveedor_id BIGINT,
    CONSTRAINT fk_producto_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE SET NULL,
    CONSTRAINT fk_producto_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(id) ON DELETE SET NULL
);

CREATE TABLE movimientos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(10) NOT NULL, -- 'ENTRADA' o 'SALIDA'
    cantidad INT NOT NULL,
    fecha_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
    motivo VARCHAR(255),
    producto_id BIGINT NOT NULL,
    CONSTRAINT fk_movimiento_producto FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);

-- Insersion de datos de prueba
INSERT INTO categorias (nombre, descripcion) VALUES 
('Lácteos', 'Productos derivados de la leche'),
('Bebidas', 'Jugos, gaseosas y refrescos');


INSERT INTO proveedores (documento, nombre_empresa, telefono, email) VALUES 
('20123456789', 'Distribuidora Central S.A.', '987654321', 'contacto@distcentral.com');


INSERT INTO productos (codigo, nombre, precio, stock_actual, categoria_id, proveedor_id) VALUES 
('PROD-001', 'Leche Entera 1L', 3.50, 50, 1, 1);