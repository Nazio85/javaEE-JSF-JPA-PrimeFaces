package pro.khairutdinov.dz.Proxy;

import pro.khairutdinov.dz.dao.ProductRepository;
import pro.khairutdinov.dz.model.Product;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

public class Logger {
    @AroundInvoke
    public Object logCreateProduct(InvocationContext invocationContext) throws Exception {
        Method method = invocationContext.getMethod();
        if (method.equals(ProductRepository.class.getMethod("merge", Product.class))) System.out.println("Создан продукт");
        else if (method.equals(ProductRepository.class.getMethod("remove", int.class))) System.out.println("Продукт удален");
        return invocationContext.proceed();
    }
}
