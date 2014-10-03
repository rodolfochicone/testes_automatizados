package br.ce.treinamento.locadora.negocio;

import java.util.Calendar;
import java.util.Date;

import br.ce.treinamento.locadora.entidades.Filme;
import br.ce.treinamento.locadora.entidades.Locacao;
import br.ce.treinamento.locadora.entidades.Usuario;

public class Locadora {

	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte, exceto quando o dia seguinte � domingo... nesse caso, a entrega fica para segunda
		Calendar dataEntrega = Calendar.getInstance();
		dataEntrega.add(Calendar.DAY_OF_MONTH, 1);
		if(dataEntrega.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			dataEntrega.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		locacao.setDataRetorno(dataEntrega.getTime());
		
		return locacao;
	}
}