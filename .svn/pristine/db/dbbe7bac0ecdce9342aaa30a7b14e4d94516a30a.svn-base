package pmcg.imti.view.ext;

import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Messagebox;

import pmcg.imti.dao.ibatis.ArqanxDAO;
import pmcg.imti.domain.ArqanxVO;

public class Manuais extends Index {
	private static final long serialVersionUID = 1L;

	public void download(Integer nr) throws InterruptedException {
		ArqanxVO arqanxVO = new ArqanxDAO().getRegByCodComplex(Long.parseLong(nr.toString()));
		// Busca arquivo no DBIMGFCN
		if (arqanxVO == null) {
			Messagebox.show("Arquivo não encontrado.");
		} else {
			Filedownload.save((byte[]) arqanxVO.getAnxarq(), "adobe/pdf", arqanxVO.getNomarq());
		}
	}
}
