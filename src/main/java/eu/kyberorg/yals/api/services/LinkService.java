package eu.kyberorg.yals.api.services;

import eu.kyberorg.yals.api.models.Link;
import eu.kyberorg.yals.api.models.dao.LinkDao;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

	private final LinkDao linkDao;

	public LinkService(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	public Link storeNew(final String ident, final String link) throws Exception {
		Link linkObject = new Link();
		linkObject.setIdent(ident);
		linkObject.setLink(link);
		try {
			return linkDao.saveAndFlush(linkObject);
		} catch (Exception e) {
			throw new Exception("Failed to save");
		}
	}
}
