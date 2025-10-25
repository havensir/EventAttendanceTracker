package com.joinup.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String uri = req.getRequestURI();

        // Public paths
        if (uri.equals("/") ||
            uri.equals("/mock-fetch.html") ||
            uri.startsWith("/login") ||
            uri.startsWith("/api/") ||
            uri.startsWith("/error") ||
            uri.startsWith("/css/") ||
            uri.startsWith("/js/") ||
            uri.startsWith("/images/") ||
            uri.startsWith("/webjars/") ||
            uri.equals("/favicon.ico")) {
            return true;
        }

        var session = req.getSession(false);
        if (session == null || (session.getAttribute("userName") == null && session.getAttribute("userId") == null)) {
            res.sendRedirect("/login");
            return false;
        }

        // SUPER_ADMIN-only access to Users admin area, with carve-outs so a user can edit themself.
        if (uri.startsWith("/users")) {
            String role = String.valueOf(session.getAttribute("userRole")); // e.g. "SUPER_ADMIN"
            Long me = (Long) session.getAttribute("userId");

            // allow self edit GET /users/{id}/edit
            // and self update POST /users/{id}
            // everything else under /users requires SUPER_ADMIN
            if (isSelfEditOrUpdate(req, uri, me)) {
                return true;
            }
            if (!"SUPER_ADMIN".equals(role)) {
                res.sendError(403, "Forbidden: SUPER_ADMIN required");
                return false;
            }
        }

        return true;
    }

    private boolean isSelfEditOrUpdate(HttpServletRequest req, String uri, Long me) {
        if (me == null) return false;

        // match /users/{id}/edit (GET)
        if (uri.matches("^/users/\\d+/edit$")) {
            Long id = Long.valueOf(uri.split("/")[2]);
            return id.equals(me);
        }
        // match POST /users/{id}
        if ("POST".equalsIgnoreCase(req.getMethod()) && uri.matches("^/users/\\d+$")) {
            Long id = Long.valueOf(uri.split("/")[2]);
            return id.equals(me);
        }
        return false;
    }
}
