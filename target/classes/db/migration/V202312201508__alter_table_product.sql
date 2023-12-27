ALTER TABLE product ADD price INTEGER;
ALTER TABLE product ADD active BOOLEAN;
UPDATE product SET price = 0;
UPDATE product SET active = true;