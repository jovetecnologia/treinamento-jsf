package com.jove.web.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jove.domain.enums.TipoServicoEnum;
import com.jove.domain.model.CalculadoraFrete;
import com.jove.domain.model.Frete;
import com.jove.endereco.Endereco;
import com.jove.infrastructure.factory.CalculadoraFreteFactory;
import com.jove.infrastructure.util.Mensagens;

@Named
@ViewScoped
public class FreteBean implements Serializable {
	private static final long serialVersionUID = -697985219991392567L;

	private Frete frete;
	private int tipoServico;

	@PostConstruct
	public void inicializar() {
		frete = new Frete();
		frete.setOrigem(new Endereco());
		frete.setDestino(new Endereco());
	}

	public void calcularFrete() {
		if (!validar()) {
			return;
		}
		TipoServicoEnum tipoServicoEnum = TipoServicoEnum.recuperarServico(tipoServico);
		CalculadoraFrete calculadoraFrete = CalculadoraFreteFactory.criarCalculadora(tipoServicoEnum);
		
		Frete freteCalculado = calculadoraFrete.calcular(frete.getOrigem().getCep(), frete.getDestino().getCep(), frete.getPeso());
		frete.setValor(freteCalculado.getValor());
		
		if (frete.getValor() == 0) {
			Mensagens.adicionarError("O frete não pode ser calculado");
			return;
		}
		
		System.out.println("O frete calculado é: " + frete.getValor());
	}

	private boolean validar() {
		if (frete.getOrigem().getCep() == null || frete.getOrigem().getCep().isEmpty()) {
			Mensagens.adicionarWarn("Informe o CEP de origem direito FILHO DA DILMA! VOLTA FHC");
		}
		if (frete.getDestino().getCep() == null || frete.getDestino().getCep().isEmpty()) {
			Mensagens.adicionarWarn("Informe o CEP de destino direito FILHO DO LULA! ASSUME AECIO");
		}
		if (frete.getPeso() <= 0 ) {
			Mensagens.adicionarWarn("Peso deve ser maior que 0 FILHO DA DILMA! FICA COLLOR");
		}
		if (tipoServico == 0) {
			Mensagens.adicionarWarn("Informe o tipo de servico direito FILHO DA DILMA! BOSLOMITO MITANDO NOVAMENTE");
		}
		return !Mensagens.possuiMensagensParaEnviar();
	}

	/**
	 * @return the frete
	 */
	public Frete getFrete() {
		return frete;
	}

	/**
	 * @param frete the frete to set
	 */
	public void setFrete(Frete frete) {
		this.frete = frete;
	}

	/**
	 * @return the tipoServico
	 */
	public int getTipoServico() {
		return tipoServico;
	}

	/**
	 * @param tipoServico the tipoServico to set
	 */
	public void setTipoServico(int tipoServico) {
		this.tipoServico = tipoServico;
	}
}
