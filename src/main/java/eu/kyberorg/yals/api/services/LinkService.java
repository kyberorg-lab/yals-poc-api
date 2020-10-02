package eu.kyberorg.yals.api.services;

import eu.kyberorg.yals.api.models.Link;
import eu.kyberorg.yals.api.models.dao.LinkDao;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
			throw new Exception("Failed to save new link");
		}
	}

	public Optional<Link> getLinkByIdent(String ident) {
		return linkDao.findSingleByIdent(ident);
	}

	public long howManyLinksWeHave() {
		return linkDao.count();
	}
}
