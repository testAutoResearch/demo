package com.coveros.training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.coveros.training.persistence.PersistenceLayer.cleanAndMigrateDatabase;

@WebServlet(name = "DbServlet", urlPatterns = {"/dbclean"}, loadOnStartup = 1)
public class DbServlet extends HttpServlet {

  static Logger logger = LogManager.getLogger();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    cleanAndMigrateDatabase();
    request.setAttribute("result", "cleaned and migrated");
    ServletUtils.forwardToResult(request, response, logger);
  }


}