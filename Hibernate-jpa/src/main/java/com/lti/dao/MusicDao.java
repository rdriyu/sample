package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Account;
import com.lti.model.Album;
import com.lti.model.Customer;
import com.lti.model.Song;

public class MusicDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public MusicDao() {

		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addAAlbum(Album album) {
		tx.begin();
		em.merge(album);
		tx.commit();
		System.out.println("Album added......");
	}

	public void addASong(Song song) {
		tx.begin();
		em.merge(song);
		tx.commit();
		System.out.println("Song added......");
	}

	public Album findAAlbum(int albumid) {
		Album alb = em.find(Album.class, albumid);
		return alb;
	}

	public void addNewAlbumWithNewSong(Album album) {

		tx.begin();
		em.merge(album);
		tx.commit();
		System.out.println("Album and Song created.....");
	}

}