package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.MovieAvlTree;


@SuppressWarnings("serial")
public class Director  extends JFrame {
	
	JButton SearchByYear , SearchByRating , SearchByCoActor , SearchByDirector , SearchByActor , SearchByTitle;
	//BufferedImage myImage, wPic;
	JPanel top, left, bottom, right, center;
    JButton back;
    JButton search  , searchByGenre;
    JTextField dir;
    MovieAvlTree m;
    JLabel bgImage;

    Director() {
		setLayout(new BorderLayout());
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		Icon titleIcon = new ImageIcon(getClass().getResource("movie.png"));
		Icon directorIcon = new ImageIcon(getClass().getResource("director.png"));
		Icon coActorsIcon = new ImageIcon(getClass().getResource("coActors.png"));
		Icon ratingIcon = new ImageIcon(getClass().getResource("ratings.png"));
		Icon actorIcon = new ImageIcon(getClass().getResource("actor.png"));
		Icon genreIcon = new ImageIcon(getClass().getResource("genre.png"));
		Icon yearIcon = new ImageIcon(getClass().getResource("year.png"));
		Icon backIcon = new ImageIcon(getClass().getResource("back.png"));
		
		bgImage = new JLabel();
		bgImage.setBounds(0, 0, 1366, 768);
		bgImage.setIcon(new ImageIcon(getClass().getResource("bckgrd.jpg")));
	   	
		top = new JPanel(new FlowLayout());
		top.setBackground(Color.GRAY);
		left = new JPanel(new GridLayout(8 ,1));
		right = new JPanel(new GridLayout(1,1));
		center = new JPanel(new FlowLayout());
		bottom = new JPanel(new FlowLayout());

	    dir = new JTextField(20);

		JLabel l1 = new JLabel("Search By Director");
		l1.setFont(new Font(l1.getName() , Font.BOLD , 55));
        top.add(l1 );
	
        
	    Handler h = new Handler();
		
	    SearchByYear = new JButton(yearIcon); 
	    SearchByYear.setContentAreaFilled(false);
	    SearchByYear.setBorder(null);
	    
	    SearchByTitle = new JButton(titleIcon);
	    SearchByTitle.setContentAreaFilled(false);
	    SearchByTitle.setBorder(null);
	    
	    SearchByDirector = new JButton(directorIcon);
	    SearchByDirector.setContentAreaFilled(false);
	    SearchByDirector.setBorder(null);
	   
	    SearchByRating = new JButton(ratingIcon);
	    SearchByRating.setContentAreaFilled(false);
	    SearchByRating.setBorder(null);
		   
	    SearchByCoActor = new JButton(coActorsIcon);
	    SearchByCoActor.setContentAreaFilled(false);
	    SearchByCoActor.setBorder(null);
	    
	    SearchByActor = new JButton(actorIcon);
	    SearchByActor.setContentAreaFilled(false);
	    SearchByActor.setBorder(null);
	    
	    searchByGenre = new JButton(genreIcon);
	    searchByGenre.setContentAreaFilled(false);
	    searchByGenre.setBorder(null);
	    
	    back = new JButton(backIcon);
	    back.setContentAreaFilled(false);
	    back.setBorder(null);
	    
	    search = new JButton("Search");
	    
	    SearchByYear.addActionListener(h);
	    SearchByTitle.addActionListener(h);
	    SearchByRating.addActionListener(h);
	    SearchByDirector.addActionListener(h);
	    SearchByCoActor.addActionListener(h);
	    SearchByActor.addActionListener(h);
	    searchByGenre.addActionListener(h);
	    back.addActionListener(h);
	    search.addActionListener(h);
	    
	    add(SearchByTitle).setBounds(40, 100, 200, 60);
	    add(SearchByDirector).setBounds(40, 160, 200, 60);
	    add(SearchByCoActor).setBounds(40, 220, 200, 60);
	    add(SearchByRating).setBounds(40, 280, 200, 60);
	    add(SearchByActor).setBounds(40, 340, 200, 60);
	    add(searchByGenre).setBounds(40, 400, 200, 60);
	    add(SearchByYear).setBounds(40, 460, 200, 60);
	    add(back).setBounds(40, 550, 200, 60);
	
	  
	    add(dir).setBounds(450, 110, 400, 35);
	    add(search).setBounds(900, 110, 100, 35);
	    
	    add(right , BorderLayout.EAST);
	    add(center , BorderLayout.CENTER);
	    add(top , BorderLayout.NORTH );
	    add(left , BorderLayout.WEST);
		setSize(screen);
		add(bgImage).setBounds(0, 0, 1366, 768);
	}
	
	class Handler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			if(a.getSource() == SearchByYear)
			{
				Year y = new Year();
				y.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == search)
			{
				FirstPage.m.searchByDirector(dir.getText());
				dir.setText("");
			}
			
			else if (a.getSource() == SearchByRating) {
				Rating r = new Rating();
				r.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			} 
			else if(a.getSource() == SearchByDirector)
			{
				Director d = new Director();
				d.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == SearchByCoActor)
			{
				CoActor c = new CoActor();
				c.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == SearchByActor)
			{
				Actor ae = new Actor();
				ae.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == SearchByTitle)
			{
				Title t = new Title();
				t.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == searchByGenre)
			{
				Genre g = new Genre();
				g.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			else if(a.getSource() == back)
			{
				FirstPage f = new FirstPage();
				f.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
			
		}
		
	}

}
	




