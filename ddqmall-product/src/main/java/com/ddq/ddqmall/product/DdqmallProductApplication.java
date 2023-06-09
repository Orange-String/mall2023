package com.ddq.ddqmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
JSR303:数据校验相关
1.给bean的属性添加校验注解，并且可以定义自己的message提示
2.开启校验功能：@Valid
    给使用该bean做方法参数的时候，在其旁边加上Valid注解，表示是需要进行校验的
    效果：校验错误会有默认的响应
    如果需要拿到校验结果，封装到自定义的响应格式中，可以紧跟被校验参数后面，新增一个BindingResult类型的参数，该参数封装了前面参数的校验结果
3.可以把校验抽离，放到统一异常处理中，有了这个就不需要加BindingResult类型的参数了
4.分组校验
    (1)校验注解中都有一个属性：groups,它要求的是一个类型数组，这个类型必须是接口（需要自定义,不需要实现，起一个标识作用）
    (2)在具体方法上使用@Validated注解代替@Valid，来指定具体的校验分组。
    (3)默认没有指定分组的校验注解，在分期校验情况下不生效。只会在不分组的情况下生效。
    【即：@Validated注解使用后并且指定了分组，那么其他没有指定分组的校验注解将不会生效；若没有指定分组，那么则反过来，指定了分组的校验注解不生效，没指定校验分组的注解会生效。在不是判空校验的情况下，不写该字段，校验也会通过】
5.自定义校验
    (1)编写一个自定义的校验注解:要求要有这三属性
        String message() default "{com.ddq.common.vaild.ListValue.message}";//这个值可以在自定义的ValidationMessages.properties配置文件中指定
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    (2)编写一个自定义的校验器:eg:public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer>
        要求实现ConstraintValidator并且指定具体的自定义注解和需要校验的类型
    (3)关联自定义的校验器和自定义校验注解:
        @Constraint( //指定校验器,是自定义注解和自定义校验器关联起来
        validatedBy = {ListValueConstraintValidator.class}
        )
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DdqmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdqmallProductApplication.class, args);
    }
}
