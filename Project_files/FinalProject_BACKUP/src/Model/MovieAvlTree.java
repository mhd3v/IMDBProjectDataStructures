package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class MovieAvlTree {

	ActorsAvlTree actors = new ActorsAvlTree();
	DirectorAvlTree directors = new DirectorAvlTree();
	MovieAvlTree[] table;
	MovieAvlTree movieTree;
	MovieAvlNode root;
	MovieNode movie;
	ObjectOutputStream output;
   	ObjectInputStream input;
	

    public MovieAvlTree() {
		this.root = null;
		
	}
	 public void createTree() {

		movieTree = new MovieAvlTree();
		movieTree.insertAllData();
	}

	

	public void insertInHashTable(MovieNode movie) {
		int pos = hashCode(movie.movie_title);
		table[pos].insertAVL(movie);
		
	}

	private int hashCode(String name) {
		
		
		
		int code = 0;
		char ch = name.charAt(0);
		switch (ch) {
		case 'A':
			code = 1;
			break;
		case 'B':
			code = 2;
			break;
		case 'C':
			code = 3;
			break;
		case 'D':
			code = 4;
			break;
		case 'E':
			code = 5;
			break;
		case 'F':
			code = 6;
			break;
		case 'G':
			code = 7;
			break;
		case 'H':
			code = 8;
			break;
		case 'I':
			code = 9;
			break;
		case 'J':
			code = 10;
			break;
		case 'K':
			code = 11;
			break;
		case 'L':
			code = 12;
			break;
		case 'M':
			code = 13;
			break;
		case 'N':
			code = 14;
			break;
		case 'O':
			code = 15;
			break;
		case 'P':
			code = 16;
			break;
		case 'Q':
			code = 17;
			break;
		case 'R':
			code = 18;
			break;
		case 'S':
			code = 19;
			break;
		case 'T':
			code = 20;
			break;
		case 'U':
			code = 21;
			break;
		case 'V':
			code = 22;
			break;
		case 'W':
			code = 23;
			break;
		case 'X':
			code = 24;
			break;
		case 'Y':
			code = 25;
			break;
		case 'Z':
			code = 26;
			break;
		}

		return code;
	}

	/// SIMPLY INSERT KEY in the TREE.
	private MovieAvlNode insert(MovieNode key) {
		MovieAvlNode newMovieAvlNode = new MovieAvlNode();
		newMovieAvlNode.movie = key;

		if (root == null) {
			root = newMovieAvlNode;
	
			return root;
		}
		
		MovieAvlNode current = root;
		MovieAvlNode parent = null;

		while (true) {
			parent = current;
			if (key.movie_title.compareTo(current.movie.movie_title) < 0) {
				current = current.left;
				if (current == null) {
					parent.left = newMovieAvlNode;
	
					return root;
				}

			} else {
				current = current.right;
				if (current == null) {
					parent.right = newMovieAvlNode;
				
					return root;

				}
			}

		}

	}

	private MovieAvlNode insertAVL(MovieNode key) {

		MovieAvlNode t = insert(key);
		checkBalanceFactor(null, root);
		return t;
	}

	private void checkBalanceFactor(MovieAvlNode parent, MovieAvlNode MovieAvlNode) {
		if (MovieAvlNode == null)
			return;
		else {
			int balanceFactor = getBalanceFactor(MovieAvlNode);
			if (balanceFactor == -2 || balanceFactor == 2) {
				
				if (balanceFactor == 2) {
					
					MovieAvlNode x = MovieAvlNode;
					MovieAvlNode y = MovieAvlNode.left;
					if (getHeight(y.left) < getHeight(y.right)) {
						singleLeftRotation(x, y);
						singleRightRotation(parent, x);
					} else {
						singleRightRotation(parent, x);
					}
				} else {
					
					MovieAvlNode x = MovieAvlNode;
					MovieAvlNode y = MovieAvlNode.right;
					if (getHeight(y.left) > getHeight(y.right)) {
						singleRightRotation(x, y);
						singleLeftRotation(parent, x);
					} else {
						singleLeftRotation(parent, x);
					}
				}
			}
			checkBalanceFactor(MovieAvlNode, MovieAvlNode.left);
			checkBalanceFactor(MovieAvlNode, MovieAvlNode.right);
		}
	}

	private int getHeight(MovieAvlNode MovieAvlNode) {
		
		if (MovieAvlNode == null)
			return 0;
		else {
			int leftTree = getHeight(MovieAvlNode.left);
			int rightTree = getHeight(MovieAvlNode.right);
			
			if (leftTree > rightTree)
				return leftTree + 1;
			else
				return rightTree + 1;
		}
	}

	int getBalanceFactor(MovieAvlNode MovieAvlNode) {
		return getHeight(MovieAvlNode.left) - getHeight(MovieAvlNode.right);
	}

	private void singleLeftRotation(MovieAvlNode parent, MovieAvlNode x) {
		MovieAvlNode y = x.right;
		x.right = y.left;
		y.left = x;

		if (x == root)
			root = y;
		else {
			if (parent.left == x)
				parent.left = y;
			else if (parent.right == x)
				parent.right = y;
		}

	}

	private void singleRightRotation(MovieAvlNode parent, MovieAvlNode x) {
		MovieAvlNode y = x.left;
		x.left = y.right;
		y.right = x;

		if (x == root)
			root = y;
		else {
			if (parent.left == x)
				parent.left = y;
			else if (parent.right == x)
				parent.right = y;
		}

	}

	public void inOrder(MovieAvlNode loc) {
		if (loc != null) {
			inOrder(loc.left);
			System.out.println(loc.movie.movie_title);
			inOrder(loc.right);
		}
	}
//===========================================================
	public MovieNode readFile()
	{
	try {
		input = new ObjectInputStream(new FileInputStream("movies.ser"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	while(true)
	{
		try {
			movie = (MovieNode)input.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
	
	//==================================================================
	void insertAllData() {

		String csvFile = "C:\\Users\\Mahad\\Desktop\\Project\\IMDB_Top5000.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int count = 0;
		ActorNode actor1 = null;
		ActorNode actor2 = null;
		ActorNode actor3 = null;
		DirectorNode director = null;
		table = new MovieAvlTree[27];
		for(int i=0; i <table.length; i++){
			table[i] = new MovieAvlTree();
		}

		try {
			output = new ObjectOutputStream(new FileOutputStream("movies.ser"));
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				if (count != 0) {

					String[] abc = line.split(cvsSplitBy);
					
					movie = new MovieNode();
					movie.actors_of_movie = new ActorsOfAMovieList();
					movie.color = abc[0];
					movie.cast_total_facbook_likes = abc[2];
					movie.duration = abc[3];
					movie.gross = abc[8];
					movie.genre = abc[9];
					movie.movie_title = abc[11];
					movie.num_voted_user = abc[12];
					movie.cast_total_facbook_likes = abc[13];
					movie.facenumber_in_poster = abc[15];
					movie.plot_keywords = abc[16];
					movie.movie_imdb_link = abc[17];
					movie.num_users_for_reviews = abc[18];
					movie.language = abc[19];
					movie.country = abc[20];
					movie.content_rating = abc[21];
					movie.budget = abc[22];
					movie.title_year = abc[23];
					movie.imdb_score = abc[25];
                    movie.aspect_ratio = abc[26];
                    movie.movie_facebook_likes = abc[27];
					
					movie.setMovie_title(abc[11]);
					movie.setColor(abc[0]);
					movie.setGross(abc[8]);
					movie.setGenre(abc[9]);
					movie.setCast_total_facbook_likes(abc[2]);
					movie.setDuration(abc[3]);
					movie.setNum_voted_user(abc[12]);
					movie.setLanguage(abc[19]);
					movie.setTitle_year(abc[23]);
					movie.setImdb_score(abc[25]);
					output.writeObject(movie);

					/* =============== Adding actors ================== */

					if (actorAlreadyExists(abc[6]) == null) {
						actor1 = new ActorNode();
						actor1.name = abc[6];
						MoviesOfActor movies1 = new MoviesOfActor();
						movies1.insert(movie);
						actor1.movies_of_actor = movies1;
						movie.actors_of_movie.insert(actor1);

						actors.insertAVL(actor1);
					}

					else {
						ActorAvlNode existingActor = actorAlreadyExists(abc[6]);
						existingActor.actor.movies_of_actor.insert(movie);
						movie.actors_of_movie.insert(existingActor.actor);
					}

					if (actorAlreadyExists(abc[10]) == null) {
						actor2 = new ActorNode();
						actor2.name = abc[10];
						MoviesOfActor movies2 = new MoviesOfActor();
						movies2.insert(movie);
						actor2.movies_of_actor = movies2;
						movie.actors_of_movie.insert(actor2);

						actors.insertAVL(actor2);
					} else {
						ActorAvlNode existingActor = actorAlreadyExists(abc[10]);
						existingActor.actor.movies_of_actor.insert(movie);
						movie.actors_of_movie.insert(existingActor.actor);
					}
					if (actorAlreadyExists(abc[14]) == null) {
						actor3 = new ActorNode();
						actor3.name = abc[14];
						MoviesOfActor movies3 = new MoviesOfActor();
						movies3.insert(movie);
						actor3.movies_of_actor = movies3;
						movie.actors_of_movie.insert(actor3);

						actors.insertAVL(actor3);
					} else {
						ActorAvlNode existingActor = actorAlreadyExists(abc[14]);
						existingActor.actor.movies_of_actor.insert(movie);
						movie.actors_of_movie.insert(existingActor.actor);
					}

					/* ================================= */

					/* ================ Director Insertion ================= */
					if (directorAlreadyExists(abc[1]) == null) {

						director = new DirectorNode();
						director.name = abc[1];
						MoviesOfDirector movies = new MoviesOfDirector();
						movies.insert(movie);
						director.movies_of_director = movies;
						movie.director = director;

						directors.insertAVL(director);
					}

					else
						directorAlreadyExists(abc[1]).director.movies_of_director.insert(movie);

					/* ================================= */

					insertInHashTable(movie);

					
		
					
				}

				count++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
	
	
	
	
	ActorAvlNode actorAlreadyExists(String name) {
		ActorAvlNode current = actors.getRoot();

		while (current != null) {
			if (current.actor.name.equals(name)) {
				return current;
			} else if (current.actor.name.compareTo(name) > 0) {
				current = current.left;
			} else
				current = current.right;
		}

		return null;
	}

	DirectorAvlNode directorAlreadyExists(String name) {
		DirectorAvlNode current = directors.getRoot();

		while (current != null) {
			if (current.director.name.equals(name)) {
				return current;
			} else if (current.director.name.compareTo(name) > 0) {
				current = current.left;
			} else
				current = current.right;
		}

		return null;
	}

	// =============================== search by year
	// ===============================

	public void SearchByYear(String year) {
		int i = 0;

		while (i < 27) {

			MovieAvlNode mov = movieTree.table[i].root;
			SearchByYear(year, mov);
			i++;
		}
	}

	private void SearchByYear(String year, MovieAvlNode root) {
		if (root == null)
			return;
		else {
			SearchByYear(year, root.left);
			SearchByYear(year, root.right);
		}
		if (root.movie.title_year.compareTo(year) == 0) {
			JOptionPane.showMessageDialog(null, "Title: " + root.movie.movie_title + "\n Year: " + root.movie.title_year + "\n IMDB Rating" + root.movie.imdb_score );
			System.out.println(root.movie.movie_title);
		}
		
	}

	// ======================== Search By Movie Title =====================================
	
	
	public void searchByMovieTitle(String movieTitle){
		MovieAvlNode movieNode = movieTree.table[hashCode(movieTitle)].root;
		boolean status = searchByTitle(movieTitle, movieNode);
		if(status == false){
			JOptionPane.showMessageDialog(null, "Movie not found in record!");
			System.out.println("Movie " + movieTitle + " not found!");
		}
	}

	boolean searchByTitle(String movieName, MovieAvlNode node) {
		
		boolean found = false;
		while ((node != null) && !found) {
			
			if (movieName.compareTo(node.movie.movie_title) < 0)
				node = node.left;
			else if (movieName.compareTo(node.movie.movie_title) > 0)
				node = node.right;
			else {
				System.out.println("Movie found!");
				node.movie.actors_of_movie.print();
				JOptionPane.showMessageDialog(null, "Title: " + node.movie.movie_title + "\n Year: " + node.movie.title_year + "\n IMDB Rating:" + node.movie.imdb_score + 
						"\n Actors: \n" + node.movie.actors_of_movie.Start.actor.name + "\n" + node.movie.actors_of_movie.Start.next.actor.name
						 + "\n" + node.movie.actors_of_movie.Start.next.next.actor.name);
				found = true;
				break;
			}
			found = searchByTitle(movieName, node);
		}

		
		return found;
		
	}
	
	// ============================ Search By Genre ===================================
    public 	void SearchByGenre(String gen)
	{
		for(int i = 0 ; i < movieTree.table.length ; i++)
		{
			MovieAvlNode root = movieTree.table[i].root;
			SearchGenre(root , gen);
		}
	}

	private void SearchGenre(MovieAvlNode root, String gen) {
		
		if(root == null)
			return;
		else
		{
			SearchGenre(root.left , gen);
			SearchGenre(root.right , gen);
		}
		
		if(root.movie.genre.contains(gen))
		{
			JOptionPane.showMessageDialog(null, "Title: " + root.movie.movie_title + "\n Year: " + root.movie.title_year + "\n IMDB Rating:" + root.movie.imdb_score + 
					"\n Actors: \n" + root.movie.actors_of_movie.Start.actor.name + "\n" + root.movie.actors_of_movie.Start.next.actor.name
					 + "\n" + root.movie.actors_of_movie.Start.next.next.actor.name);
		  System.out.println(root.movie.movie_title + "||  imdb score =   " + root.movie.imdb_score + " || year =  " + root.movie.title_year);	
		}
			

	}



	
	// ============================= Search By Rating Range ==============================
	public void SearchByRatingRange(String rating1, String rating2) {
		int i = 0;
		while (i < 27) {
			MovieAvlNode mov = movieTree.table[i].root;
			SearchRating(mov, rating1, rating2);
			i++;
		}
	}

	private void SearchRating(MovieAvlNode m, String r1, String r2) {
		if (m == null)
			return;
		else {
			SearchRating(m.left, r1, r2);
			SearchRating(m.right, r1, r2);

		}
		if ((m.movie.imdb_score.compareTo(r1) > 0 || m.movie.imdb_score.compareTo(r1) == 0)
				&& (m.movie.imdb_score.compareTo(r2) < 0 || m.movie.imdb_score.compareTo(r2) == 0)) {
			JOptionPane.showMessageDialog(null, m.movie.movie_title + "\n" + m.movie.imdb_score);
			System.out.println(m.movie.movie_title + " - " + m.movie.imdb_score);
		}
	}

	public void searchByDirector(String directorName) {
		DirectorNode dirc = new DirectorNode();
		dirc.searchMovieDirector(directorName, movieTree);
	}

	public void searchByActor(String actorName) {
		ActorNode actor = new ActorNode();
		actor.searchMovieActor(actorName, movieTree);
	}

	public void searchCoActors(String ActorName) {
		ActorNode actor = new ActorNode();
		actor.searchMovieCoActors(ActorName, movieTree);
	}

	public void coActorsInAParticularMovie(String actorName, String movieName){
		ActorNode actor = new ActorNode();
		actor.coActorsInParticular(actorName, movieName, movieTree.table[hashCode(movieName)].root);
		
	}
	
}
