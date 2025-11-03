package com.joinup.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Intercepts HTTP requests to enforce authentication and authorization rules.
 * <p>
 * Allows public paths without authentication and restricts access to certain
 * paths based on user role.
 */
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * Checks each HTTP request before it reaches a controller.
     *
     * @param req     the HTTP request
     * @param res     the HTTP response
     * @param handler the chosen handler to execute
     * @return true if the request should proceed, false otherwise
     * @throws Exception if an error occurs while handling the request
     */
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

    /**
     * Checks if the request is for a user editing or updating their own account.
     *
     * @param req the HTTP request
     * @param uri the requested URI
     * @param me  the ID of the currently logged-in user
     * @return true if the user is allowed to edit/update themselves, false otherwise
     */
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
