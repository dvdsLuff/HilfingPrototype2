# CREATE SCHEMA IF NOT EXISTS 'hilfling';
# USE 'hilfling';
#
# CREATE TABLE IF NOT EXISTS hilfling.products
# (
#     'id'          INT(11)      NOT NULL AUTO_INCREMENT,
#     'name'        VARCHAR(100) NOT NULL,
#     'price'       int(100)     not null,
#     'stocknumber' VARCHAR(45)  NOT NULL,
#      PRIMARY KEY ('id')
# )
#     ENGINE = InnoDB
#     AUTO_INCREMENT = 1
#     DEFAULT CHARACTER SET = utf8;
#
#
#
# insert into Products (name, price, stocknumber)
# values ('Stor vase', 200, 250),
#        ('lille vase', 100, 150),
#        ('mellem vase', 150, 300),
#        ('hvid mundbind', 50, 1000),
#        ('sort mundbind', 75, 1500)