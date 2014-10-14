package hello;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
                HttpServletRequest req = (HttpServletRequest) request;
                HttpServletResponse res = (HttpServletResponse) response;
                res.setHeader("Access-Control-Allow-Origin", req.getHeader("origin") );
                res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
                res.setHeader("Access-Control-Max-Age", "3600");
                res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
                chain.doFilter(request, response);
    }

    @Override
    public void destroy(){}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
}
