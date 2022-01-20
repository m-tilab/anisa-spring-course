create table currency_exchange (
                                   id                  bigint not null,
                                   conversion_multiple decimal(19, 2),
                                   environment         varchar(255),
                                   from_               varchar(255),
                                   to                  varchar(255),
                                   primary key (id)
);

insert into currency_exchange
(id,from_,to,conversion_multiple,environment)
values(10001,'USD','IRR',270000,'');
insert into currency_exchange
(id,from_,to,conversion_multiple,environment)
values(10002,'EUR','IRR',320000,'');
insert into currency_exchange
(id,from_,to,conversion_multiple,environment)
values(10003,'AUD','IRR',220000,'');