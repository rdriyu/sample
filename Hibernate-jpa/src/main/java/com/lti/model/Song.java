package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_song")
public class Song {

	@Id
	@SequenceGenerator(name = "songSeq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songSeq")
	@Column(name = "song_id")
	int songId;
	String songTtitle;
	String singer;
	String lyricst;

	@ManyToOne
	@JoinColumn(name = "album_id")
	Album album;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTtitle() {
		return songTtitle;
	}

	public void setSongTtitle(String songTtitle) {
		this.songTtitle = songTtitle;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLyricst() {
		return lyricst;
	}

	public void setLyricst(String lyricst) {
		this.lyricst = lyricst;
	}

}