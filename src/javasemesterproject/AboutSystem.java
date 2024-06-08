package javasemesterproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class AboutSystem extends JFrame  {
    JTree actor;
    JPanel treePanel;
    JLabel title;
    public AboutSystem() {
        super("About System");
        setSize(400,400);
        setLocation(530, 260);
        setLayout(new BorderLayout());
        
        // Create the JTree with some sample data
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("System");
        DefaultMutableTreeNode actors = new DefaultMutableTreeNode("Actors");
        actors.add(new DefaultMutableTreeNode("Admin"));
        actors.add(new DefaultMutableTreeNode("Teacher"));
        actors.add(new DefaultMutableTreeNode("Student"));
        rootNode.add(actors);
        DefaultMutableTreeNode course = new DefaultMutableTreeNode("Course");
        course.add(new DefaultMutableTreeNode("Object Oriented and Visual Programming"));
        course.add(new DefaultMutableTreeNode("Database System"));
        course.add(new DefaultMutableTreeNode("Web Application Development"));
        course.add(new DefaultMutableTreeNode("Probability and Statistics"));
        course.add(new DefaultMutableTreeNode("Business Process Analysis"));
        course.add(new DefaultMutableTreeNode("Management Information System"));
        course.add(new DefaultMutableTreeNode("Economic Survival"));
        course.add(new DefaultMutableTreeNode("Fluency and Speed Development"));
        rootNode.add(course);
        actor = new JTree(rootNode);

        // Create the panel for the JTree
        treePanel = new JPanel();
        treePanel.setLayout(new BorderLayout());
        add(actor);

        // Create the title label
        title = new JLabel("About System", JLabel.CENTER);
        title.setFont(new Font(Font.SERIF, Font.BOLD, 26));
        title.setBackground(Color.BLACK);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        AboutSystem actors = new AboutSystem();
    }

    AboutSystem(Main main) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
