package com.hf.domain.Annatation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAuthorize {
    //书写格式 	@MyAuthorize(Role = {"ROLE_USER","ROLE_ADMIN"})
    String[] Role() default "";
}
