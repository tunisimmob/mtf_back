package com.ingarch.promoteur.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String nom;
	private String adresse;
	private String act;
	private String tel;
	private String gsm;
	private String fax;
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

	private String password;


	private List<String> roles;

	public JwtResponse(String password,String accessToken, Long id, String username, String email,String nom,String adresse,String act,String tel,String gsm,String fax,
					   String gouvernorat,String ville,String web,String logo,Integer ordre,String statut,String facebook,String instagram,
					   String twitter,String skype,String linkedin,String position,String aboutme,List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.adresse = adresse;
		this.nom = nom;
		this.act = act;
		this.tel = tel;
		this.gsm = gsm;
		this.fax = fax;
		this.gouvernorat = gouvernorat;
		this.ville = ville;
		this.web = web;
		this.logo = logo;
		this.ordre = ordre;
		this.statut = statut;
		this.facebook = facebook;
		this.instagram = instagram;
		this.twitter = twitter;
		this.skype = skype;
		this.linkedin = linkedin;
		this.position = position;
		this.aboutme = aboutme;


	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}

	public String getAdresse() {
		return adresse;
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

	public String getGouvernorat() {
		return gouvernorat;
	}

	public String getVille() {
		return ville;
	}

	public String getWeb() {
		return web;
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

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
