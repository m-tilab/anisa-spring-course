package com.example.springbootrest.security;

import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.model.Permission;

public class CustomPermission extends BasePermission {

   public static final Permission APPROVE = new CustomPermission(1 << 5, 'V'); // 32

   protected CustomPermission(int mask) {
      super(mask);
   }

   protected CustomPermission(int mask, char code) {
      super(mask, code);
   }
}