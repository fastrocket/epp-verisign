/***********************************************************
Copyright (C) 2004 VeriSign, Inc.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-0107  USA

http://www.verisign.com/nds/naming/namestore/techdocs.html
***********************************************************/
package com.verisign.epp.codec.nameWatch;


//----------------------------------------------
//
// imports...
//
//----------------------------------------------
// W3C Imports
import org.w3c.dom.*;

// EPP Imports
import com.verisign.epp.codec.gen.*;


/**
 * Represents a nameWatch Status. A nameWatch object MUST always have at least
 * one associated status value. Status values MAY be set only by the client
 * that sponsors a nameWatch object and by the server on which the object
 * resides.  A client MAY change the status of a nameWatch object using the
 * EPP &lt;update&gt; command. Each status value MAY be accompanied by a
 * string of human-readable text that describes the rationale for the status
 * applied to the object. <br>
 * <br>
 * A client MUST NOT alter status values set by the server.  A server MAY
 * alter or override status values set by a client subject to local server
 * policies. <br>
 * <br>
 * Status values that may be added or removed by a client are prefixed with
 * "client".  Corresponding status values that may be added or removed by a
 * server are prefixed with "server".  Status values that do not begin with
 * either "client" or "server" are server-managed. <br>
 * <br>
 * Status Value Descriptions: <br>
 * 
 * <ul>
 * <li>
 * clientDeleteProhibited, serverDeleteProhibited: Requests to delete the
 * object MUST be rejected.
 * </li>
 * <li>
 * clientHold, serverHold: Delegation information MUST be withheld from
 * publication in the object's nominal zone.
 * </li>
 * <li>
 * clientRenewProhibited, serverRenewProhibited: Requests to renew the object
 * MUST be rejected.
 * </li>
 * <li>
 * clientTransferProhibited, serverTransferProhibited: Requests to transfer the
 * object MUST be rejected.
 * </li>
 * <li>
 * clientUpdateProhibited, serverUpdateProhibited: Requests to update the
 * object (other than to remove this status) MUST be rejected.
 * </li>
 * <li>
 * ok: This is the nominal status value for an object that has no pending
 * perations or prohibitions.
 * </li>
 * <li>
 * pendingDelete: A delete request has been received for the object, but the
 * object has not yet been purged from the server database.
 * </li>
 * <li>
 * pendingTransfer: A transfer request has been received for the object, and
 * completion of the request is pending.  Transform commands other than
 * &lt;transfer&gt; MUST be rejected while an object is in this state.
 * </li>
 * <li>
 * <code>ok</code> status MUST NOT be combined with any other status.
 * </li>
 * <li>
 * <code>pendingDelete</code> status MUST NOT be combined with either
 * </li>
 * <li>
 * <code>clientDeleteProhibited</code> or <code>serverDeleteProhibited</code>
 * status.
 * </li>
 * <li>
 * <code>pendingTransfer</code> status MUST NOT be combined with either
 * <code>clientTransferProhibited</code> or
 * <code>serverTransferProhibited</code> status.
 * </li>
 * <li>
 * Allother status value combinations are valid.
 * </li>
 * </ul>
 * 
 * <br><br>
 *
 * @author $Author: jim $
 * @version $Revision: 1.1.1.1 $
 */
public class EPPNameWatchStatus
	implements com.verisign.epp.codec.gen.EPPCodecComponent {
	/** Value of the OK status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_OK = "ok";

	/** Value of the server hold status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_SERVER_HOLD = "serverHold";

	/** Value of the server renew prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_SERVER_RENEW_PROHIBITED =
		"serverRenewProhibited";

	/** Value of the server transfer prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_SERVER_TRANSFER_PROHIBITED =
		"serverTransferProhibited";

	/** Value of the server update prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_SERVER_UPDATE_PROHIBITED =
		"serverUpdateProhibited";

	/** Value of the server delete prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_SERVER_DELETE_PROHIBITED =
		"serverDeleteProhibited";

	/** Value of the pending delete status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_PENDING_DELETE =
		"pendingDelete";

	/** Value of the pending transfer status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_PENDING_TRANSFER =
		"pendingTransfer";

	/** Value of the client hold status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_CLIENT_HOLD = "clientHold";

	/** Default Language -- English "en" */
	public final static java.lang.String ELM_DEFAULT_LANG = "en";

	/** Value of the client transfer prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_CLIENT_TRANSFER_PROHIBITED =
		"clientTransferProhibited";

	/** Value of the client update prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_CLIENT_UPDATE_PROHIBITED =
		"clientUpdateProhibited";

	/** Value of the client renew prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_CLIENT_RENEW_PROHIBITED =
		"clientRenewProhibited";

	/** Value of the client delete prohibited status in nameWatch mapping */
	public final static java.lang.String ELM_STATUS_CLIENT_DELETE_PROHIBITED =
		"clientDeleteProhibited";

	/** XML Element Name of <code>EPPNameWatchStatus</code> root element. */
	final static java.lang.String ELM_NAME = "nameWatch:status";

	/**
	 * XML Element Status Attribute Name of <code>EPPNameWatchStatus</code>
	 * root element.
	 */
	final static java.lang.String ELM_STATUS = "s";

	/**
	 * XML Element Language Attribute Name of <code>EPPNameWatchStatus</code>
	 * root element.
	 */
	final static java.lang.String ELM_LANG = "lang";

	/** NameWatch status. */
	private java.lang.String status = ELM_STATUS_OK;

	/** Language of the nameWatch status. */
	private java.lang.String lang = ELM_DEFAULT_LANG;

	/** Description of the status rationale. */
	private String description = null;

	/**
	 * <code>EPPNameWatchStatus</code> default constructor.
	 */
	public EPPNameWatchStatus() {
	}

	// End EPPNameWatchStatus.EPPNameWatchStatus()

	/**
	 * <code>EPPNameWatchStatus</code> constructor that takes the namewatch
	 * status as argument.
	 *
	 * @param aStatus String    NameWatch staus
	 */
	public EPPNameWatchStatus(String aStatus) {
		status = aStatus;
	}

	// End EPPNameWatchStatus.EPPNameWatchStatus(String)

	/**
	 * <code>EPPNameWatchStatus</code> constructor that takes the namewatch
	 * status and a status description.
	 *
	 * @param aStatus NameWatch status which should be one of the
	 * 		  <code>ELM_STATUS</code> constants.
	 * @param aDesc A description of the status change
	 */
	public EPPNameWatchStatus(String aStatus, String aDesc) {
		status		    = aStatus;
		description     = aDesc;
	}

	// End EPPNameWatchStatus.EPPNameWatchStatus(String, String)

	/**
	 * <code>EPPNameWatchStatus</code> constructor that takes the namewatch
	 * status and the language as arguments.
	 *
	 * @param aStatus NameWatch status which should be one of the
	 * 		  <code>ELM_STATUS</code> constants.
	 * @param aDesc A description of the status change
	 * @param aLang Language of the status description
	 */
	public EPPNameWatchStatus(String aStatus, String aDesc, String aLang) {
		status		    = aStatus;
		description     = aDesc;
		lang		    = aLang;
	}

	// End EPPNameWatchStatus.EPPNameWatchStatus(String, String, String)

	/**
	 * Clone <code>EPPNameWatchStatus</code>.
	 *
	 * @return clone of <code>EPPNameWatchStatus</code>
	 *
	 * @exception CloneNotSupportedException standard Object.clone exception
	 */
	public Object clone() throws CloneNotSupportedException {
		EPPNameWatchStatus clone = null;

		clone = (EPPNameWatchStatus) super.clone();

		return clone;
	}

	// End EPPNameWatchStatus.clone()

	/**
	 * Decode the EPPNameWatchStatus attributes from the aElement DOM Element
	 * tree.
	 *
	 * @param aElement - Root DOM Element to decode EPPNameWatchStatus from.
	 *
	 * @exception EPPDecodeException Unable to decode aElement
	 */
	public void decode(Element aElement) throws EPPDecodeException {
		// Status
		status = aElement.getAttribute(ELM_STATUS);

		// Description
		Node descNode = aElement.getFirstChild();

		if (descNode != null) {
			description     = descNode.getNodeValue();

			// Description Language
			lang = aElement.getAttribute(ELM_LANG);
		}
	}

	// End EPPNameWatchStatus.doDecode(Element)

	/**
	 * Encode a DOM Element tree from the attributes of the EPPNameWatchStatus
	 * instance.
	 *
	 * @param aDocument - DOM Document that is being built.  Used as an Element
	 * 		  factory.
	 *
	 * @return Element    - Root DOM Element representing the
	 * 		   EPPNameWatchStatus instance.
	 *
	 * @exception EPPEncodeException - Unable to encode EPPNameWatchStatus
	 * 			  instance.
	 */
	public Element encode(Document aDocument) throws EPPEncodeException {
		if (status == null) {
			throw new EPPEncodeException("required attribute status is not set");
		}

		// Status with Attributes
		Element root =
			aDocument.createElementNS(EPPNameWatchMapFactory.NS, ELM_NAME);

		// add attribute status
		root.setAttribute(ELM_STATUS, status);

		// Description specified?
		if (description != null) {
			// Non-default language specified?
			if (!lang.equals(ELM_DEFAULT_LANG)) {
				root.setAttribute(ELM_LANG, lang);
			}

			Text descVal = aDocument.createTextNode(description);
			root.appendChild(descVal);
		}

		return root;
	}

	// End EPPNameWatchStatus.encode(Document)

	/**
	 * implements a deep <code>EPPNameWatchStatus</code> compare.
	 *
	 * @param aObject <code>EPPNameWatchStatus</code> instance to compare with
	 *
	 * @return DOCUMENT ME!
	 */
	public boolean equals(Object aObject) {
		if (!(aObject instanceof EPPNameWatchStatus)) {
			return false;
		}

		EPPNameWatchStatus theComp = (EPPNameWatchStatus) aObject;

		// status
		if (!status.equals(theComp.status)) {
			return false;
		}

		// description
		if (
			!(
					(description == null) ? (theComp.description == null)
											  : description.equals(theComp.description)
				)) {
			return false;
		}

		// lang
		if (!lang.equals(theComp.lang)) {
			return false;
		}

		return true;
	}

	// End EPPNameWatchStatus.equals(Object)

	/**
	 * Get language of the status.
	 *
	 * @return String  Language
	 */
	public String getLang() {
		return lang;
	}

	// End EPPNameWatchStatus.getLang()

	/**
	 * Get namewatch status.
	 *
	 * @return String  NameWatch Status
	 */
	public String getStatus() {
		return status;
	}

	// End EPPNameWatchStatus.getStatus()

	/**
	 * Set language of namewatch status.
	 *
	 * @param newLang String
	 */
	public void setLang(String newLang) {
		lang = newLang;
	}

	// End EPPNameWatchStatus.setLang(String)

	/**
	 * Set namewatch status.
	 *
	 * @param newStatus String
	 */
	public void setStatus(String newStatus) {
		status = newStatus;
	}

	// End EPPNameWatchStatus.setLang(String)

	/**
	 * Gets the status description, which is free form text describing the
	 * rationale for the status.
	 *
	 * @return DOCUMENT ME!
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the status description, which is free form text describing the
	 * rationale for the status.
	 *
	 * @param aDesc status description
	 */
	public void setDescription(String aDesc) {
		description = aDesc;
	}

	/**
	 * Implementation of <code>Object.toString</code>, which will result in an
	 * indented XML <code>String</code> representation of the concrete
	 * <code>EPPCodecComponent</code>.
	 *
	 * @return Indented XML <code>String</code> if successful;
	 * 		   <code>ERROR</code> otherwise.
	 */
	public String toString() {
		return EPPUtil.toString(this);
	}

	// End EPPNameWatchStatus.toString()
}
