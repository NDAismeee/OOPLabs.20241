package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class StoreScreen extends JFrame {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem smAddBook = new JMenuItem("Add Book");
        JMenuItem smAddCD = new JMenuItem("Add CD");
        JMenuItem smAddDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(smAddBook);
        smUpdateStore.add(smAddCD);
        smUpdateStore.add(smAddDVD);        

        smAddBook.addActionListener(new btnMenuListener());
        smAddCD.addActionListener(new btnMenuListener());
        smAddDVD.addActionListener(new btnMenuListener());

        menu.add(smUpdateStore);

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        JMenuItem viewCartMenu = new JMenuItem("View cart");
        menu.add(viewStoreMenu);
        menu.add(viewCartMenu);
        viewStoreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store);
            }
        });
        viewCartMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

	
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			} else if (command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store);
			} else if (command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store);
			} 
		}
	}
	
	JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
    
        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        cartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
	
	JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));


        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }
        
        return center;
    }
	
	public static void initializeStore() {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        CompactDisc cd1 = new CompactDisc("With you", "Music", "Twice", 15.26f);
        Track track1Cd1 = new Track("One Spark", 3);
        Track track2Cd1 = new Track("I Got You", 3);
        Track track3Cd1 = new Track("Bloom", 2);
        Track track4Cd1 = new Track("Rush", 3);
        cd1.addTrack(track1Cd1);
        cd1.addTrack(track2Cd1);
        cd1.addTrack(track3Cd1);
        cd1.addTrack(track4Cd1);
        
        CompactDisc cd2 = new CompactDisc("Say Yes", "Music", "Twice", 14.67f);
        Track track1Cd2 = new Track("Yes or Yes", 3);
        Track track2Cd2 = new Track("Lalala", 3);
        Track track3Cd2 = new Track("Say You Love Me", 2);
        cd2.addTrack(track1Cd2);
        cd2.addTrack(track2Cd2);
        cd2.addTrack(track3Cd2);
        
        CompactDisc cd3 = new CompactDisc("Eyes Wide Open", "Music", "Twice", 16.67f);
        Track track1Cd3 = new Track("I can't stop me", 3);
        Track track2Cd3 = new Track("Cry For Me", 3);
        Track track3Cd3 = new Track("Go Hard", 2);
        cd3.addTrack(track1Cd3);
        cd3.addTrack(track2Cd3);
        cd3.addTrack(track3Cd3);
        
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        
        Book book1 = new Book("Harry Potter: The Prequel", "Fantasy Novels", 20.34f);
        Book book2 = new Book("Harry Potter and the Sorcerer’s Stone", "Fantasy Novels", 21.44f);
        Book book3 = new Book("Christmas at Hogwarts", "Fantasy Novels", 18.42f);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
	}
	
	public StoreScreen(Store store) {
		StoreScreen.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	public static void main(String[] args) {
		initializeStore();
		new StoreScreen(store);
	}
}
