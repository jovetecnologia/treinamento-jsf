package com.jove.infrastructure.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagens {

	public static void adicionarInfo(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
	}

	public static void adicionarInfo(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensagem));
	}

	public static void adicionarWarn(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", mensagem));
	}

	public static void adicionarWarn(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensagem));
	}

	public static void adicionarError(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", mensagem));
	}

	public static void adicionarError(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensagem));
	}

	public static void adicionarFatal(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "", mensagem));
	}

	public static void adicionarFatal(String titulo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, mensagem));
	}

	public static boolean possuiMensagensParaEnviar() {
		return (FacesContext.getCurrentInstance().getMessageList().size() > 0);
	}
}
