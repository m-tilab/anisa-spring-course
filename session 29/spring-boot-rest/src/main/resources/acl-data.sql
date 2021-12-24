INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 0, 'ROLE_CUSTOMER'),
(2, 0, 'ROLE_ADMIN');

INSERT INTO acl_class (id, class) VALUES
(1, 'com.example.springbootrest.model.entity.UserEntity');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 60, NULL, 2, 0),
(2, 1, 61, NULL, 2, 0),
(3, 1, 62, NULL, 2, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 1, 1, 1),
(4, 2, 1, 2, 1, 1, 1, 1);