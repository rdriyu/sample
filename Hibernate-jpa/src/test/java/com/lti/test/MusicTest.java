package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.MusicDao;
import com.lti.model.Account;
import com.lti.model.AccountType;
import com.lti.model.Album;
import com.lti.model.Customer;
import com.lti.model.Song;

public class MusicTest {

	MusicDao dao=new MusicDao();
	
	@Test
	public void AddAAlbum() {
		Album alb=new Album();
		alb.setAlbumName("20's Collection");
		alb.setGenre("Party");
		alb.setReleaseDate(LocalDate.of(2018, 10, 05));
		dao.addAAlbum(alb);
		
	}
	
	@Test
	public void AddASong() {
		Song s=new Song();
		s.setLyricst("Amitabh");
		s.setSinger("Arijit");
		s.setSongTtitle("La La La");
		Album album =dao.findAAlbum(100);
		s.setAlbum(album);
		dao.addASong(s);
	}
	
	
	/* @Test
    public void addNewAlbumWithSong(){
        

		Album alb=new Album();
		alb.setAlbumName("20's Collection");
		alb.setGenre("Party");
		alb.setReleaseDate(LocalDate.of(2018, 10, 05));
        
		Song s=new Song();
		s.setLyricst("Amitabh");
		s.setSinger("Arijit");
		s.setSongTtitle("La La La");
		Album album =dao.findAAlbum(100);
		s.setAlbum(album);
		
		
		
		
		dao.addNewAlbumWithNewSong(album);
        
        s.setAlbum(alb);
        alb.setEmployees();
        dao.addNewCustomerWithNewAccount(customer);
    } */
	
	

}