<%
//*********************************
//security
//*********************************
%>
<%@ taglib uri="/WEB-INF/auth.tld" prefix="mc" %>
<mc:auth module="admin" />
<%
//*********************************
//define
//*********************************
%>
<%@ page import="org.myconf.*" %>
<%@ page import="org.myconf.dao.*" %>
<%@ page import="org.myconf.beans.*" %>
<%@ page import="org.myconf.util.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
//*********************************
//variable
//*********************************
%>
<%
Locale loc=RequestUtils.getUserLocale(request, null);
if(loc==null)
	throw new Exception(Globals.getMessage("common", "error.language.null"));

//get userinfo
UserBean user=UserDAO.getUserByID(RequestUtils.getParam(request, "id", 0));
if(user==null){
	throw new Exception(Globals.getMessage("common", "error.unknow"));
}
%>

<html>
<%
//*********************************
//head
//*********************************
%>
<jsp:include page="/inc/head.jsp" />

<body onLoad="init()">
<%
//*********************************
//top
//*********************************
%>
<jsp:include page="/inc/logo_admin.jsp" />
<%
//*********************************
//content
//*********************************
%>
<table width="778" height="31" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="10" class="channel_bar_left">&nbsp;</td>
    <td width="448" class="channel_bar_bg"><span class="bartitle">&nbsp;<bean:message key="page.useredit.title" bundle="admin"/></span></td>
    <td width="310" style="PADDING-TOP: 2px;" align="right" class="channel_bar_bg">&nbsp; 
      </td>
    <td width="10" class="channel_bar_right">&nbsp;</td>
  </tr>
</table>
<SCRIPT language="javascript">
function init(){
	edituser.title.value='<%=StringUtils.exportString(user.getName().getTitle())%>';
	edituser.country.value='<%=StringUtils.exportString(user.getCountry())%>';
}
function checkForm()
{
	if (edituser.email.value.length == 0) {
		alert("<bean:message key="error.email.not.null"/>");
		edituser.email.focus();
		return false;
	}
	if (!isEmail(edituser.email.value)) {
		alert("<bean:message key="error.email.wrong.format"/>");
		edituser.email.focus();
		edituser.email.select();
		return false;
	}
	if (edituser.password.value.length == 0) {
		alert("<bean:message key="error.password.not.null"/>");
		edituser.password.focus();
		return false;
	}
	if (edituser.firstName.value.length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		edituser.firstName.focus();
		return false;
	}
	if (edituser.lastName.value.length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		edituser.lastName.focus();
		return false;
	}
	if (edituser.workLocation.value.length == 0) {
		alert("<bean:message key="error.staritem.not.null"/>");
		edituser.workLocation.focus();
		return false;
	}
	return true;
}
</script>
<table width="778" border="0" align="center" cellpadding="0" cellspacing="0" style="MARGIN-TOP: 10px;">
  <tr> 
    <td valign="top" class="pagecontent"><form action="<html:rewrite page="/user.do"/>" method="post" name="edituser" id="edituser">
        <input name="eventSubmit_EditUser" type="hidden" id="eventSubmit_EditUser" value="1">
        <input name="email" type="hidden" id="email" value="<%=user.getEmail()%>">
        <br>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="form">&nbsp;</td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_note">
          <tr> 
            <td><div class="spacer_5"></div>
              <li><bean:message key="page.useradd.ins1" bundle="admin"/></li>
              <div class="spacer_5"></div></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title">*<bean:message key="common.textbox.email"/></td>
            <td class="form_row_content">&nbsp;&nbsp;<span class="blackbold"><%=user.getEmail()%></span></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title">*<bean:message key="common.textbox.password"/></td>
            <td class="form_row_content"><input name="password" type="text" id="password" size="48" value="<%=user.getPassword()%>"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" class="form_row_title"><bean:message key="common.textbox.user.role"/></td>
            <td class="form_row_content"> &nbsp;&nbsp;{<bean:message key="page.useradd.ins2" bundle="admin"/>}</td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td class="form_row_content"> <div class="spacer_5"></div>
                <input name="isAuthor" type="checkbox" id="isAuthor" value="1"<%if(user.getIsAuthor()==UserBean.TRUE){out.print(" checked");}%>>
                <bean:message key="menu.left.user.author" bundle="admin"/> 
                <input name="isExpert" type="checkbox" id="isExpert" value="1"<%if(user.getIsExpert()==UserBean.TRUE){out.print(" checked");}%>>
                <bean:message key="menu.left.user.expert" bundle="admin"/> 
                <input name="isContent" type="checkbox" id="isContent" value="1"<%if(user.getIsContent()==UserBean.TRUE){out.print(" checked");}%>>
                <bean:message key="menu.left.user.site" bundle="admin"/> 
                <input name="isAdmin" type="checkbox" id="isAdmin" value="1"<%if(user.getIsAdmin()==UserBean.TRUE){out.print(" checked");}%>>
                <bean:message key="menu.left.user.admin" bundle="admin"/> 
              <div class="spacer_10"></div></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title"><bean:message key="page.subpage.form.ctitle" bundle="author"/></td>
            <td width="30%" class="form_row_content"><select name="title" id="title">
                <option> </option>
                <option value="Mr.">Mr.</option>
                <option value="Ms.">Ms.</option>
                <option value="Dr.">Dr.</option>
                <option value="Prof.">Prof.</option>
                <%if(loc.equals(Locale.SIMPLIFIED_CHINESE) || loc.equals(Locale.TRADITIONAL_CHINESE)){%>
                <option value="<bean:message key="common.title.mr"/>"><bean:message key="common.title.mr"/></option>
                <option value="<bean:message key="common.title.ms"/>"><bean:message key="common.title.ms"/></option>
                <option value="<bean:message key="common.title.dr"/>"><bean:message key="common.title.dr"/></option>
                <option value="<bean:message key="common.title.prof"/>"><bean:message key="common.title.prof"/></option>
                <%}%>
              </select></td>
            <td width="20%" class="form_row_content">&nbsp;</td>
            <td width="30%" class="form_row_content">&nbsp;</td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.firstname" bundle="author"/></td>
            <td width="30%" class="form_row_grid"><input name="firstName" type="text" id="firstName" size="22" value="<%=StringUtils.exportString(user.getName().getFirstName())%>"></td>
            <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.fax" bundle="author"/></td>
            <td width="30%" class="form_row_content"><input name="fax" type="text" id="fax" size="22" value="<%=StringUtils.exportString(user.getFax())%>"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.lastname" bundle="author"/></td>
            <td width="30%" class="form_row_grid"> <input name="lastName" type="text" id="lastName" size="22" value="<%=StringUtils.exportString(user.getName().getLastName())%>"></td>
            <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.address" bundle="author"/></td>
            <td width="30%" class="form_row_content"><input name="address" type="text" id="address" size="22" value="<%=StringUtils.exportString(user.getAddress())%>"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title">*<bean:message key="page.subpage.form.worklocation" bundle="author"/></td>
            <td width="30%" class="form_row_grid"><input name="workLocation" type="text" id="workLocation" size="22" value="<%=StringUtils.exportString(user.getWorkLocation())%>"></td>
            <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.state" bundle="author"/></td>
            <td width="30%" class="form_row_content"><input name="state" type="text" id="state" size="22" value="<%=StringUtils.exportString(user.getState())%>"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title"><bean:message key="page.subpage.form.research" bundle="author"/></td>
            <td width="30%" class="form_row_grid"> <input name="research" type="text" id="research" size="22" value="<%=StringUtils.exportString(user.getResearch())%>"></td>
            <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.country" bundle="author"/></td>
            <td width="30%" class="form_row_content"> <SELECT name=country size=1 id="country" style="width:150px;">
                <OPTION value="" selected><bean:message key="common.list.please.select"/></OPTION>
                <OPTION value="Afghanistan">Afghanistan</OPTION>
                <OPTION value="Albania">Albania</OPTION>
                <OPTION value="Algeria">Algeria</OPTION>
                <OPTION value="American Samoa">American Samoa</OPTION>
                <OPTION value="Andorra">Andorra</OPTION>
                <OPTION value="Angola">Angola</OPTION>
                <OPTION value="Anguilla">Anguilla</OPTION>
                <OPTION value="Antarctica">Antarctica</OPTION>
                <OPTION value="Antigua and Barbuda">Antigua and Barbuda</OPTION>
                <OPTION value="Argentina">Argentina</OPTION>
                <OPTION value="Armenia">Armenia</OPTION>
                <OPTION value="Aruba">Aruba</OPTION>
                <OPTION value="Australia">Australia</OPTION>
                <OPTION value="Austria">Austria</OPTION>
                <OPTION value="Azerbaijan">Azerbaijan</OPTION>
                <OPTION value="Bahamas">Bahamas</OPTION>
                <OPTION value="Bahrain">Bahrain</OPTION>
                <OPTION value="Bangladesh">Bangladesh</OPTION>
                <OPTION value="Barbados">Barbados</OPTION>
                <OPTION value="Belarus">Belarus</OPTION>
                <OPTION value="Belgium">Belgium</OPTION>
                <OPTION value="Belize">Belize</OPTION>
                <OPTION value="Benin">Benin</OPTION>
                <OPTION value="Bermuda">Bermuda</OPTION>
                <OPTION value="Bhutan">Bhutan</OPTION>
                <OPTION value="Bolivia">Bolivia</OPTION>
                <OPTION value="Bosnia and Herzegovina">Bosnia and Herzegovina</OPTION>
                <OPTION value="Botswana">Botswana</OPTION>
                <OPTION value="Brazil">Brazil</OPTION>
                <OPTION value="British Indian Ocean Territory">British Indian 
                Ocean Territory</OPTION>
                <OPTION value="Brunei Darussalam">Brunei Darussalam</OPTION>
                <OPTION value="Bulgaria">Bulgaria</OPTION>
                <OPTION value="Burkina Faso">Burkina Faso</OPTION>
                <OPTION value="Burundi">Burundi</OPTION>
                <OPTION value="Cambodia">Cambodia</OPTION>
                <OPTION value="Cameroon">Cameroon</OPTION>
                <OPTION value="Canada">Canada</OPTION>
                <OPTION value="Cape Verde">Cape Verde</OPTION>
                <OPTION value="Cayman Islands">Cayman Islands</OPTION>
                <OPTION value="Central African Republic">Central African Republic</OPTION>
                <OPTION value="Chad">Chad</OPTION>
                <OPTION value="Chile">Chile</OPTION>
                <OPTION value="China">China</OPTION>
                <OPTION value="China, Hong Kong">China, Hong Kong</OPTION>
                <OPTION value="China, Taiwan">China, Taiwan</OPTION>
                <OPTION value="Colombia">Colombia</OPTION>
                <OPTION value="Comoros">Comoros</OPTION>
                <OPTION value="Congo">Congo</OPTION>
                <OPTION value="Congo, Dem. Republic of the">Congo, Dem. Republic 
                of the</OPTION>
                <OPTION value="Cook Islands">Cook Islands</OPTION>
                <OPTION value="Costa Rica">Costa Rica</OPTION>
                <OPTION value="Croatia">Croatia</OPTION>
                <OPTION value="Cuba">Cuba</OPTION>
                <OPTION value="Cyprus">Cyprus</OPTION>
                <OPTION value="Czech Republic">Czech Republic</OPTION>
                <OPTION value="Denmark">Denmark</OPTION>
                <OPTION value="Djibouti">Djibouti</OPTION>
                <OPTION value="Dominica">Dominica</OPTION>
                <OPTION value="Dominican Republic">Dominican Republic</OPTION>
                <OPTION value="East Timor">East Timor</OPTION>
                <OPTION value="Ecuador">Ecuador</OPTION>
                <OPTION value="Egypt">Egypt</OPTION>
                <OPTION value="El Salvador">El Salvador</OPTION>
                <OPTION value="Equatorial Guinea">Equatorial Guinea</OPTION>
                <OPTION value="Eritrea">Eritrea</OPTION>
                <OPTION value="Estonia">Estonia</OPTION>
                <OPTION value="Ethiopia">Ethiopia</OPTION>
                <OPTION value="Falkland Islands">Falkland Islands</OPTION>
                <OPTION value="Faroe Islands">Faroe Islands</OPTION>
                <OPTION value="Fiji">Fiji</OPTION>
                <OPTION value="Finland">Finland</OPTION>
                <OPTION value="France">France</OPTION>
                <OPTION value="French Guiana">French Guiana</OPTION>
                <OPTION value="French olynesia">French olynesia</OPTION>
                <OPTION value="Gabon">Gabon</OPTION>
                <OPTION value="Gambia">Gambia</OPTION>
                <OPTION value="Georgia">Georgia</OPTION>
                <OPTION value="Germany">Germany</OPTION>
                <OPTION value="Ghana">Ghana</OPTION>
                <OPTION value="Gibraltar">Gibraltar</OPTION>
                <OPTION value="Greece">Greece</OPTION>
                <OPTION value="Greenland">Greenland</OPTION>
                <OPTION value="Grenada">Grenada</OPTION>
                <OPTION value="Guadeloupe">Guadeloupe</OPTION>
                <OPTION value="Guam">Guam</OPTION>
                <OPTION value="Guatemala">Guatemala</OPTION>
                <OPTION value="Guinea">Guinea</OPTION>
                <OPTION value="Guinea-Bissau">Guinea-Bissau</OPTION>
                <OPTION value="Guyana">Guyana</OPTION>
                <OPTION value="Haiti">Haiti</OPTION>
                <OPTION value="Honduras">Honduras</OPTION>
                <OPTION value="Hungary">Hungary</OPTION>
                <OPTION value="Iceland">Iceland</OPTION>
                <OPTION value="India">India</OPTION>
                <OPTION value="Indonesia">Indonesia</OPTION>
                <OPTION value="Iran">Iran</OPTION>
                <OPTION value="Iraq">Iraq</OPTION>
                <OPTION value="Ireland">Ireland</OPTION>
                <OPTION value="Israel">Israel</OPTION>
                <OPTION value="Italy">Italy</OPTION>
                <OPTION value="Ivory Coast">Ivory Coast</OPTION>
                <OPTION value="Jamaica">Jamaica</OPTION>
                <OPTION value="Japan">Japan</OPTION>
                <OPTION value="Jordan">Jordan</OPTION>
                <OPTION value="Kazakstan">Kazakstan</OPTION>
                <OPTION value="Kenya">Kenya</OPTION>
                <OPTION value="Kiribati">Kiribati</OPTION>
                <OPTION value="Korea, North">Korea, North</OPTION>
                <OPTION value="Korea, South">Korea, South</OPTION>
                <OPTION value="Kuwait">Kuwait</OPTION>
                <OPTION value="Kyrgyzstan">Kyrgyzstan</OPTION>
                <OPTION value="Laos">Laos</OPTION>
                <OPTION value="Latvia">Latvia</OPTION>
                <OPTION value="Lebanon">Lebanon</OPTION>
                <OPTION value="Lesotho">Lesotho</OPTION>
                <OPTION value="Liberia">Liberia</OPTION>
                <OPTION value="Libya">Libya</OPTION>
                <OPTION value="Liechtenstein">Liechtenstein</OPTION>
                <OPTION value="Lithuania">Lithuania</OPTION>
                <OPTION value="Luxembourg">Luxembourg</OPTION>
                <OPTION value="Macau">Macau</OPTION>
                <OPTION value="Macedonia">Macedonia</OPTION>
                <OPTION value="Madagascar">Madagascar</OPTION>
                <OPTION value="Malawi">Malawi</OPTION>
                <OPTION value="Malaysia">Malaysia</OPTION>
                <OPTION value="Maldives">Maldives</OPTION>
                <OPTION value="Mali">Mali</OPTION>
                <OPTION value="Malta">Malta</OPTION>
                <OPTION value="Marshall Islands">Marshall Islands</OPTION>
                <OPTION value="Martinique">Martinique</OPTION>
                <OPTION value="Mauritania">Mauritania</OPTION>
                <OPTION value="Mauritius">Mauritius</OPTION>
                <OPTION value="Mayotte">Mayotte</OPTION>
                <OPTION value="Mexico">Mexico</OPTION>
                <OPTION value="Micronesia, Federated States of">Micronesia, Federated 
                States of</OPTION>
                <OPTION value="Moldova">Moldova</OPTION>
                <OPTION value="Monaco">Monaco</OPTION>
                <OPTION value="Mongolia">Mongolia</OPTION>
                <OPTION value="Montserrat">Montserrat</OPTION>
                <OPTION value="Morocco">Morocco</OPTION>
                <OPTION value="Mozambique">Mozambique</OPTION>
                <OPTION value="Myanmar">Myanmar</OPTION>
                <OPTION value="Namibia">Namibia</OPTION>
                <OPTION value="Nauru">Nauru</OPTION>
                <OPTION value="Nepal">Nepal</OPTION>
                <OPTION value="Netherlands">Netherlands</OPTION>
                <OPTION value="Netherlands Antilles">Netherlands Antilles</OPTION>
                <OPTION value="New Caledonia">New Caledonia</OPTION>
                <OPTION value="New Zealand">New Zealand</OPTION>
                <OPTION value="Nicaragua">Nicaragua</OPTION>
                <OPTION value="Niger">Niger</OPTION>
                <OPTION value="Nigeria">Nigeria</OPTION>
                <OPTION value="Niue">Niue</OPTION>
                <OPTION value="Norfolk Island">Norfolk Island</OPTION>
                <OPTION value="Northern Mariana Islands">Northern Mariana Islands</OPTION>
                <OPTION value="Norway">Norway</OPTION>
                <OPTION value="Oman">Oman</OPTION>
                <OPTION value="Pakistan">Pakistan</OPTION>
                <OPTION value="Palau">Palau</OPTION>
                <OPTION value="Palestinian Territory">Palestinian Territory</OPTION>
                <OPTION value="Panama">Panama</OPTION>
                <OPTION value="Papua New Guinea">Papua New Guinea</OPTION>
                <OPTION value="Paraguay">Paraguay</OPTION>
                <OPTION value="Peru">Peru</OPTION>
                <OPTION value="Philippines">Philippines</OPTION>
                <OPTION value="Pitcairn">Pitcairn</OPTION>
                <OPTION value="Poland">Poland</OPTION>
                <OPTION value="Portugal">Portugal</OPTION>
                <OPTION value="Puerto Rico">Puerto Rico</OPTION>
                <OPTION value="Qatar">Qatar</OPTION>
                <OPTION value="Reunion">Reunion</OPTION>
                <OPTION value="Romania">Romania</OPTION>
                <OPTION value="Russia">Russia</OPTION>
                <OPTION value="Rwanda">Rwanda</OPTION>
                <OPTION value="Saint Helena">Saint Helena</OPTION>
                <OPTION value="Saint Kitts and Nevis">Saint Kitts and Nevis</OPTION>
                <OPTION value="Saint Lucia">Saint Lucia</OPTION>
                <OPTION value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</OPTION>
                <OPTION value="Saint Vincent and the Grenadines">Saint Vincent 
                and the Grenadines</OPTION>
                <OPTION value="Samoa">Samoa</OPTION>
                <OPTION value="San Marino">San Marino</OPTION>
                <OPTION value="Sao Tome and Principe">Sao Tome and Principe</OPTION>
                <OPTION value="Saudi Arabia">Saudi Arabia</OPTION>
                <OPTION value="Senegal">Senegal</OPTION>
                <OPTION value="Seychelles">Seychelles</OPTION>
                <OPTION value="Sierra Leone">Sierra Leone</OPTION>
                <OPTION value="Singapore">Singapore</OPTION>
                <OPTION value="Slovakia">Slovakia</OPTION>
                <OPTION value="Slovenia">Slovenia</OPTION>
                <OPTION value="Solomon Islands">Solomon Islands</OPTION>
                <OPTION value="Somalia">Somalia</OPTION>
                <OPTION value="South Africa">South Africa</OPTION>
                <OPTION value="Spain">Spain</OPTION>
                <OPTION value="Sri Lanka">Sri Lanka</OPTION>
                <OPTION value="Sudan">Sudan</OPTION>
                <OPTION value="Suriname">Suriname</OPTION>
                <OPTION value="Swaziland">Swaziland</OPTION>
                <OPTION value="Sweden">Sweden</OPTION>
                <OPTION value="Switzerland">Switzerland</OPTION>
                <OPTION value="Syria">Syria</OPTION>
                <OPTION value="Tajikistan">Tajikistan</OPTION>
                <OPTION value="Tanzania">Tanzania</OPTION>
                <OPTION value="Thailand">Thailand</OPTION>
                <OPTION value="Togo">Togo</OPTION>
                <OPTION value="Tokelau">Tokelau</OPTION>
                <OPTION value="Tonga">Tonga</OPTION>
                <OPTION value="Trinidad And Tobago">Trinidad And Tobago</OPTION>
                <OPTION value="Tunisia">Tunisia</OPTION>
                <OPTION value="Turkey">Turkey</OPTION>
                <OPTION value="Turkmenistan">Turkmenistan</OPTION>
                <OPTION value="Turks and Caicos Islands">Turks and Caicos Islands</OPTION>
                <OPTION value="Tuvalu">Tuvalu</OPTION>
                <OPTION value="Uganda">Uganda</OPTION>
                <OPTION value="Ukraine">Ukraine</OPTION>
                <OPTION value="United Arab Emirates">United Arab Emirates</OPTION>
                <OPTION value="United Kingdom">United Kingdom</OPTION>
                <OPTION value="United States">United States</OPTION>
                <OPTION value="United States Minor Outlying Islands">United States 
                Minor Outlying Islands</OPTION>
                <OPTION value="Uruguay">Uruguay</OPTION>
                <OPTION value="Uzbekistan">Uzbekistan</OPTION>
                <OPTION value="Vanuatu">Vanuatu</OPTION>
                <OPTION value="Vatican City">Vatican City</OPTION>
                <OPTION value="Venezuela">Venezuela</OPTION>
                <OPTION value="Viet Nam">Viet Nam</OPTION>
                <OPTION value="Virgin Islands, British">Virgin Islands, British</OPTION>
                <OPTION value="Virgin Islands, U.S.">Virgin Islands, U.S.</OPTION>
                <OPTION value="Wallis and Futuna">Wallis and Futuna</OPTION>
                <OPTION value="Western Sahara">Western Sahara</OPTION>
                <OPTION value="Yemen">Yemen</OPTION>
                <OPTION value="Zambia">Zambia</OPTION>
                <OPTION value="Zimbabwe">Zimbabwe</OPTION>
                <OPTION value="other">other</OPTION>
              </SELECT></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td width="20%" height="25" class="form_row_title"><bean:message key="page.subpage.form.phone" bundle="author"/></td>
            <td width="30%" class="form_row_grid"> <input name="phone" type="text" id="phone" size="22" value="<%=StringUtils.exportString(user.getPhone())%>"></td>
            <td width="20%" class="form_row_title"><bean:message key="page.subpage.form.postcode" bundle="author"/></td>
            <td width="30%" class="form_row_content"><input name="postcode" type="text" id="postcode" size="22" value="<%=StringUtils.exportString(user.getPostcode())%>"></td>
          </tr>
        </table>
        <table width="88%" border="0" align="center" cellpadding="0" cellspacing="0" class="form_row">
          <tr> 
            <td nowrap class="form_row_submit"><input name="sub" type="submit" class="button" id="sub" value="<bean:message key="common.button.edit.user"/>">
              <input name="back" type="button" class="button" id="back" onClick="window.close()" value="<bean:message key="common.button.back"/>"> 
            </td>
          </tr>
        </table>
        </form></td>
  </tr>
</table>
<%
//*********************************
//end content
//*********************************
%>
<%
//**********************************
//footer
//**********************************
%>
<jsp:include page="/inc/footer.jsp" />
</body>
</html>