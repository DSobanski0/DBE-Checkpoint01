package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.ProfileDao;
import br.com.fiap.model.Profile;

@Named
@RequestScoped
public class ProfileBean {
	
	Profile profile = new Profile();
	
	public void save() {
		new ProfileDao().save(this.profile);
		System.out.println("Salvando..." + this.profile);
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage("Profile cadastrado com sucesso"));
	}
	
	public List<Profile> getProfiles() {
		return new ProfileDao().getAll();
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
