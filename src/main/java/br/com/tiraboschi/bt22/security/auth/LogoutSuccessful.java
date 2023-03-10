package br.com.tiraboschi.bt22.security.auth;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LogoutSuccessful implements LogoutSuccessHandler {

  @Autowired
  ObjectMapper objectMapper;

  @Override
  public void onLogoutSuccess(final HttpServletRequest httpServletRequest,
                              final HttpServletResponse response,final Authentication authentication)
      throws IOException, ServletException {
    Map<String, String> result = new HashMap<>();
    result.put("result", "success");
    response.setContentType("application/json");
    response.getWriter().write(objectMapper.writeValueAsString(result));
    response.setStatus(HttpServletResponse.SC_OK);

  }

}