

-- Insertar categorías y productos (5 categorías, 5 productos cada una)

-- ☕ Categoría: Cafés
INSERT INTO product (nombre, descripcion, precio, categoria, stock) VALUES
('Espresso', 'Café fuerte y concentrado', 250.00, 'Cafés', 100),
('Café Latte', 'Café con leche espumosa', 350.00, 'Cafés', 50),
('Capuccino', 'Café con leche y espuma de cacao', 380.00, 'Cafés', 40),
('Americano', 'Café suave con más agua', 270.00, 'Cafés', 60),
('Mocha', 'Café con chocolate y crema', 420.00, 'Cafés', 30);

-- 🍵 Categoría: Tés
INSERT INTO product (nombre, descripcion, precio, categoria, stock) VALUES
('Té Verde', 'Infusión antioxidante', 200.00, 'Tés', 70),
('Té Negro', 'Infusión clásica y fuerte', 190.00, 'Tés', 80),
('Té Chai', 'Té especiado con leche', 250.00, 'Tés', 40),
('Té de Manzanilla', 'Infusión relajante', 180.00, 'Tés', 60),
('Té Frutal', 'Mezcla de frutas tropicales', 220.00, 'Tés', 50);

-- 🥐 Categoría: Pastelería
INSERT INTO product (nombre, descripcion, precio, categoria, stock) VALUES
('Medialuna', 'Facturas clásicas argentinas', 120.00, 'Pastelería', 200),
('Brownie', 'Bizcocho de chocolate húmedo', 250.00, 'Pastelería', 80),
('Muffin de Arándanos', 'Muffin esponjoso con frutas', 220.00, 'Pastelería', 60),
('Tarta de Manzana', 'Clásica tarta con manzanas caramelizadas', 300.00, 'Pastelería', 40),
('Cheesecake', 'Tarta de queso con base de galleta', 350.00, 'Pastelería', 30);

-- 🥪 Categoría: Sandwiches
INSERT INTO product (nombre, descripcion, precio, categoria, stock) VALUES
('Sandwich de Jamón y Queso', 'Clásico tostado argentino', 280.00, 'Sandwiches', 100),
('Sandwich Veggie', 'Verduras grilladas y hummus', 320.00, 'Sandwiches', 50),
('Sandwich de Pollo', 'Pollo grillado con mayonesa', 350.00, 'Sandwiches', 40),
('Sandwich Caprese', 'Tomate, mozzarella y albahaca', 330.00, 'Sandwiches', 60),
('Sandwich de Roast Beef', 'Carne asada con mostaza', 400.00, 'Sandwiches', 30);

-- 🥤 Categoría: Bebidas Frías
INSERT INTO product (nombre, descripcion, precio, categoria, stock) VALUES
('Limonada', 'Refrescante con menta y jengibre', 200.00, 'Bebidas Frías', 70),
('Iced Coffee', 'Café frío con hielo', 280.00, 'Bebidas Frías', 50),
('Smoothie de Frutilla', 'Batido natural de frutilla', 320.00, 'Bebidas Frías', 40),
('Milkshake de Vainilla', 'Batido con helado de vainilla', 350.00, 'Bebidas Frías', 30),
('Agua Mineral', 'Botella de agua sin gas', 150.00, 'Bebidas Frías', 100);