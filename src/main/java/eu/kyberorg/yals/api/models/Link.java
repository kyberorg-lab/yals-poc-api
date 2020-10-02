package eu.kyberorg.yals.api.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "links")
public class Link {
	private static final String IDENT_COLUMN = "ident";
	private static final String LINK_COLUMN = "link";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = IDENT_COLUMN, unique = true, nullable = false)
	private String ident;

	@Column(name = LINK_COLUMN, nullable = false)
	private String link;
}
