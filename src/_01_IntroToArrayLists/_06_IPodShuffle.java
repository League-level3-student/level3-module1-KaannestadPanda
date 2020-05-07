package _01_IntroToArrayLists;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JButton butone = new JButton("Play random");
	JButton buttwo = new JButton("Stop songs");
	
	ArrayList<Song> songs = new ArrayList<Song>();
	ArrayList<Song> playingSongs = new ArrayList<Song>();
	Song song1 = new Song("harehareya.mp3");
	//Song song2 = new Song("y2mate.com - FIREWORK FULL COVER (JONTRON OFFICIAL)_Oy_JlG7C-T8.mp3");
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				JFrame frame = new JFrame();
				JPanel panel = new JPanel();
				Dimension d = new Dimension(400, 400);
				
				butone.addActionListener(this);
				butone.setPreferredSize(d);
				
				buttwo.addActionListener(this);
				buttwo.setPreferredSize(d);
				
				frame.add(panel);
				panel.add(butone);
				panel.add(buttwo);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		_06_IPodShuffle a = new _06_IPodShuffle();
		
		a.songs.add(a.song1);
		//a.songs.add(a.song2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("action");
		// TODO Auto-generated method stub
		JButton check = (JButton) e.getSource();
		if(check== butone) {
			playSong();
			System.out.println("if");
		}
		if(check== buttwo) {
			System.out.println("stopif");
			stopSongs();
		}
	}
	
	
	
	void playSong(){
		
		Random ran = new Random();
		int ranInt = ran.nextInt(songs.size());
		
		playingSongs.add(songs.get(ranInt));
		songs.get(ranInt).play();
		
	}
	
	void stopSongs() {
		if(playingSongs.size()>=0) {
		for(int i = playingSongs.size()-1;i>=0;i--) {
			playingSongs.get(i).stop();
		}
		}
	}
	
	
}