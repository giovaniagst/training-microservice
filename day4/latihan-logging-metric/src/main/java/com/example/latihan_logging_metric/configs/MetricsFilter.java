package com.example.latihan_logging_metric.configs;

import io.micrometer.core.instrument.MeterRegistry;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MetricsFilter implements Filter {
    private final MeterRegistry meterRegistry;

    @Autowired
    public MetricsFilter(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        chain.doFilter(request, response);

        String method = httpServletRequest.getMethod();
        String uri = httpServletRequest.getRequestURI();
        int statusCode = httpServletResponse.getStatus();
        meterRegistry.counter("http_requests_total", "method", method, "uri", uri, "status", String.valueOf(statusCode)).increment();
    }

    @Override
    public void destroy() {}
}
