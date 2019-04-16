package br.fepi.si.util.jsf.tratamentoErrosLog;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Classe Fábrica de ExceptionHandler Modo de usar: Extends
 * JsfExceptionHandlerFactory e passe para o atibuto paginaErro o path de sua
 * página para tratamento. Ex: paginaErro = "/Error.xhtml" Declare o método
 * herdado getExceptionHandler().
 * 
 * Adicionar o arquivo src/mais/resources/log4j2.xml.
 * 
 * Adcionar ao faces-config.xml:
 * 
 * <factory>
 *		<exception-handler-factory>
 *			path_classe_que_extende_JsfExceptionHandlerFactory</exception-handler-factory>
 *	</factory>
 * 
 * Versão do Log4J: 2.7 
 * Versão do Commons Logging: 1.2
 * 
 * @version 1.0
 * @author lduarte
 */
public abstract class JsfExceptionHandlerFactory extends ExceptionHandlerFactory {

	protected ExceptionHandlerFactory parent;
	protected String paginaErro;

	public JsfExceptionHandlerFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new JsfExceptionHandler(parent.getExceptionHandler(), paginaErro);
	}

}
