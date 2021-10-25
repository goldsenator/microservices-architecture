create table users (
    user_id bigint not null primary key,
    firstname varchar (255),
    lastname varchar (255),
    middlemen varchar (255),
    password varchar (255),
    photo oid,
    email varchar (255),
    contacting varchar (255),
    status varchar (255)
);

create type user_roles_type as enum (
    'FOUNDER', 'ADMIN', 'CLIENT'
);

create table roles (
    role_id bigint not null primary key,
    role_name user_roles_type,
    description varchar (1000)
);

create table user_role (
    id bigint not null primary key,
    user_id bigint,
    role_id bigint
);


ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_roles_fk FOREIGN KEY (role_id) REFERENCES roles(role_id);

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_users_fk FOREIGN KEY (user_id) REFERENCES users(user_id);
