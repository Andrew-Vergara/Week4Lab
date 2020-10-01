package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Andrew
 */
public class viewNoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String fileTitle = br.readLine();
        String fileContents = br.readLine();
        br.close();
        Note note = new Note(fileTitle, fileContents);
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        BufferedWriter pw = new BufferedWriter(new FileWriter(path, false));
        pw.write(title);
        pw.newLine();
        pw.write(contents);
        pw.flush();
        pw.close();
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
    }

}
