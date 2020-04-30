package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle{
	ArrayList<Song> songs = new ArrayList<Song>();
	Song song1 = new Song("https://www.youtube.com/watch?v=Oy_JlG7C-T8");
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
				
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
	}
}