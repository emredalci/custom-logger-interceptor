package org.example.customloggerinterceptor.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

@Getter
@Setter
public class ApplicationInfo {

    private static final ThreadLocal<ApplicationInfo> APPLICATION_INFO_THREAD_LOCAL = new ThreadLocal<>();

    private String uri;
    private String remoteAddress;
    private String method;

    private ApplicationInfo() {
    }

    public static ApplicationInfo of(String uri, String remoteAddress, String method) {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.setUri(uri);
        applicationInfo.setRemoteAddress(remoteAddress);
        applicationInfo.setMethod(method);
        return applicationInfo;
    }

    public static ApplicationInfo getInstance() {
        return APPLICATION_INFO_THREAD_LOCAL.get();
    }

    public static void setApplicationInfoThreadLocal(ApplicationInfo applicationInfo) {
        APPLICATION_INFO_THREAD_LOCAL.set(applicationInfo);
    }

    public static void remove() {
        APPLICATION_INFO_THREAD_LOCAL.remove();
    }

    @Override
    public String toString() {
        return "ApplicationInfo{" +
                "uri='" + uri + '\'' +
                ", remoteAddress='" + remoteAddress + '\'' +
                '}';
    }
}
