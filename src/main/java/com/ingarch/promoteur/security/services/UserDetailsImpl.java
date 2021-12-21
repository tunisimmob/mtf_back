package com.ingarch.promoteur.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ingarch.promoteur.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	private String nom;

	private String prenom;

	private String act;

	private String tel;

	private String gsm;

	private String fax;

	private String adresse;

	private String gouvernorat;

	private String ville;

	private String web;

	private String logo;

	private Integer ordre;

	private String statut;

	private String facebook;

	private String instagram;

	private String twitter;

	private String skype;

	private String linkedin;

	private String position;

	private String aboutme;



	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNom() {
		return nom;
	}

	public String getAct() {
		return act;
	}

	public String getTel() {
		return tel;
	}

	public String getGsm() {
		return gsm;
	}

	public String getFax() {
		return fax;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public String getVille() {
		return ville;
	}

	public String getWeb() {
		return web;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getLogo() {
		return logo;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public String getStatut() {
		return statut;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
