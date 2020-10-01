/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.*;

/**
 *
 * @author Andrew
 */
public class note implements Serializable {

    private String title;
    private String contents;

    public note() {
        title = "";
        contents = "";
    }

    public note(String title, String contents) {
        this.contents = contents;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void readFile() throws FileNotFoundException, IOException {
        String fileContent = "";
        BufferedReader br = new BufferedReader(new FileReader(new File("/WEB-INF/note.txt")));
        setTitle(br.readLine());
        while (br.readLine() != null) {
            fileContent += br.readLine();
        }
        setContents(fileContent);
        br.close();
    }

    public void writeFile() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("/WEB-INF/note.txt", false)));
        pw.write(getTitle());
        pw.write(getContents());
        pw.flush();
        pw.close();
    }
}
