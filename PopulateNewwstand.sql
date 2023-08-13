INSERT INTO products VALUES (0, 'The Economist', 15.00, '2023-01-01', 'YEARLY');
INSERT INTO products VALUES (1, 'Time', 17.50, '2023-03-21', 'MONTHLY');
INSERT INTO products VALUES (14, 'Time', 17.50, '2023-04-21', 'MONTHLY');
INSERT INTO products VALUES (15, 'Time', 17.50, '2023-05-21', 'MONTHLY');
INSERT INTO products VALUES (16, 'Time', 17.50, '2023-06-21', 'MONTHLY');
INSERT INTO products VALUES (2, 'Corriere Della Sera', 3.00, '2023-03-22', 'DAILY');
INSERT INTO products VALUES (3, 'Diabolik', 5.50, null, null);
INSERT INTO products VALUES (4, 'Tex', 4.50, null, null);
INSERT INTO products VALUES (5, 'Naruto', 4.50, null, null);
INSERT INTO products VALUES (6, 'DragonBall', 5.50, null, null);
INSERT INTO products VALUES (7, 'Carte Collezionabili', 6.50, null, null);
INSERT INTO products VALUES (8, 'Amici Cucciolotti 2023', 3.00, null, null);
INSERT INTO products VALUES (9, 'Funny Friends', 5.00, null, null);
INSERT INTO products VALUES (10, 'Cartoline San Valentino', 5.00, null, null);
INSERT INTO products VALUES (11, 'Altroconsumo', 5.00, null, null);
INSERT INTO products VALUES (12, 'La Settimana Enigmistica', 1.50, null, null);
INSERT INTO products VALUES (13, 'SuperBike Italia', 5.50, null, null);

INSERT INTO storages VALUES('Magazzino', 0);
INSERT INTO storages VALUES('Allestimento Interno', 1);
INSERT INTO storages VALUES('Allestimento Esterno', 0);

INSERT INTO inventory VALUES('Magazzino', 0, 10);
INSERT INTO inventory VALUES('Magazzino', 5, 3);
INSERT INTO inventory VALUES('Magazzino', 4, 2);
INSERT INTO inventory VALUES('Magazzino', 7, 5);
INSERT INTO inventory VALUES('Magazzino', 12, 9);
INSERT INTO inventory VALUES('Allestimento Interno', 0, 1);
INSERT INTO inventory VALUES('Allestimento Interno', 1, 3);
INSERT INTO inventory VALUES('Allestimento Interno', 2, 4);
INSERT INTO inventory VALUES('Allestimento Interno', 3, 3);
INSERT INTO inventory VALUES('Allestimento Interno', 4, 5);
INSERT INTO inventory VALUES('Allestimento Interno', 5, 4);
INSERT INTO inventory VALUES('Allestimento Interno', 6, 6);
INSERT INTO inventory VALUES('Allestimento Interno', 7, 1);
INSERT INTO inventory VALUES('Allestimento Interno', 8, 2);
INSERT INTO inventory VALUES('Allestimento Interno', 9, 9);
INSERT INTO inventory VALUES('Allestimento Interno', 13, 4);
INSERT INTO inventory VALUES('Allestimento Interno', 11, 6);
INSERT INTO inventory VALUES('Allestimento Esterno', 0, 2);
INSERT INTO inventory VALUES('Allestimento Esterno', 1, 1);
INSERT INTO inventory VALUES('Allestimento Esterno', 2, 3);
INSERT INTO inventory VALUES('Allestimento Esterno', 12, 2);

INSERT INTO coupons VALUES(0, '2024-03-01', null, 0.90, 'Sconto del 10% sul totale valido fino al 22-03-2024, uso singolo');
INSERT INTO coupons VALUES(1, '2024-01-01', '2023-01-01', 0.80, 'Sconto del 20% sul totale valido per tutto il 2023');
INSERT INTO coupons VALUES(2, null, null, 0.95, 'Sconto del 5% sul totale sempre valido');
INSERT INTO coupons VALUES(4, null, null, 0.85, 'Sconto del 15% su tutte le riviste del Time sempre valido');
INSERT INTO coupons VALUES(3, null, null, 0.90, 'Sconto del 10% sui Funny Friends, sempre valido');

INSERT INTO suppliers VALUES(0, '3331234567', 'Mario Rossi', 'Via Aldo Moro', 'Roma', 'Italia', '00042');
INSERT INTO suppliers VALUES(1, '3337654321', 'Luigi Verdi', 'Via Aldo Biondo', 'Milano', 'Italia', '20019');
INSERT INTO suppliers VALUES(2, '3281324576', 'Marcello Bianchi', 'Via Trento', 'Pavia', 'Italia', '27100');
INSERT INTO suppliers VALUES(3, '7987654321', 'Joseph Mortius', 'Downing Street', 'Londra', 'Inghilterra', 'SW1A 2AA');

INSERT INTO members VALUES(0, 'Paolo Brasio', 'pbrasio@gmail.com');
INSERT INTO members VALUES(1, 'Giovanni Mulaccia', 'gmulaccia@gmail.com');
INSERT INTO members VALUES(2, 'Riccardo Flotti', 'rflotti@gmail.com');
INSERT INTO members VALUES(3, 'Matteo Murlattieri', 'mmurlattieri@gmail.com');
INSERT INTO members VALUES(4, 'Simone Persaglia', 'spersaglia@gmail.com');
INSERT INTO members VALUES(5, 'Matteo Faddoli', 'mfaddoli@gmail.com');
INSERT INTO members VALUES(6, 'Luca De Pratis', 'ldpratis@gmail.com');
INSERT INTO members VALUES(7, 'Alessandro Tremotti', 'atremotti@gmail.com');
INSERT INTO members VALUES(8, 'Giuseppe Esposito', 'gesposito@gmail.com');
INSERT INTO members VALUES(9, 'Marco Verdini', 'mverdini@gmail.com');
INSERT INTO members VALUES(10, 'Nicholas Burbiera', 'nburbiera@gmail.com');
INSERT INTO members VALUES(11, 'Giancarlo Motti', 'gmotti@gmail.com');

INSERT INTO accounting VALUES(0, '20-03-22T10:30', 'Sell');
INSERT INTO accounting VALUES(1, '20-03-22T15:34', 'Sell');
INSERT INTO accounting VALUES(2, '21-03-22T9:25', 'Sell');
INSERT INTO accounting VALUES(3, '22-03-22T18:46', 'Sell');
INSERT INTO accounting VALUES(4, '20-03-22T8:34', 'Buy');
INSERT INTO accounting VALUES(5, '21-03-22T8:25', 'Buy');
INSERT INTO accounting VALUES(6, '22-03-22T8:46', 'Buy');
INSERT INTO accounting VALUES(7, '28-02-22T8:34', 'Refunds');
INSERT INTO accounting VALUES(8, '30-03-22T8:25', 'Refunds');
INSERT INTO accounting VALUES(9, '29-04-22T8:46', 'Refunds');

INSERT INTO circulation_coupons VALUES('abc', 0);
INSERT INTO circulation_coupons VALUES('def', 0);
INSERT INTO circulation_coupons VALUES('hai', 0);

INSERT INTO coupon_product VALUES(3, 9);
INSERT INTO coupon_product VALUES(4, 1);
INSERT INTO coupon_product VALUES(4, 14);
INSERT INTO coupon_product VALUES(4, 15);
INSERT INTO coupon_product VALUES(4, 16);

INSERT INTO shoppingcarts VALUES(0, 0, 3);
INSERT INTO shoppingcarts VALUES(0, 2, 4);
INSERT INTO shoppingcarts VALUES(1, 3, 1);
INSERT INTO shoppingcarts VALUES(1, 2, 2);
INSERT INTO shoppingcarts VALUES(2, 8, 6);
INSERT INTO shoppingcarts VALUES(2, 0, 1);
INSERT INTO shoppingcarts VALUES(3, 9, 2);
INSERT INTO shoppingcarts VALUES(4, 3, 4);
INSERT INTO shoppingcarts VALUES(5, 5, 3);
INSERT INTO shoppingcarts VALUES(6, 6, 7);
INSERT INTO shoppingcarts VALUES(7, 9, 2);
INSERT INTO shoppingcarts VALUES(8, 4, 3);
INSERT INTO shoppingcarts VALUES(9, 1, 4);






