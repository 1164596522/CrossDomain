package crossDomainFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, IOException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletRequest.setCharacterEncoding("UTF-8");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;


        String suibains = req.getServletContext().getInitParameter("suibain");
        String[] allowList = suibains.split(",");

        String origin = req.getHeader("Origin");

        if (origin != null && !origin.isEmpty()) {
            boolean isOrigin = false;
            for (String allow : allowList) {
                if (origin.equals(allow)|| allow.equals("*")) {
                    isOrigin = true;
                    break;
                }
            }
            if (isOrigin) {
                resp.setHeader("Access-Control-Allow-Origin", origin);
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
