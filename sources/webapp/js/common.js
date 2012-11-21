/*
 | change style
 */
var ie4 = (document.all) ? true : false;
var ns4 = (document.layers) ? true : false;
var ns6 = (document.getElementById && !document.all) ? true : false;
function changeStyle(obj, cls) {
	if (ie4) {document.all[obj].className = cls;}
	if (ns4) {document.layers[obj].className = cls;}
	if (ns6) {document.getElementById([obj]).className = cls;}
}

/*
 | show & hide layer
 */
function hideLayer(lay) {
	if (ie4) {document.all[lay].style.display = "none";}
	if (ns4) {document.layers[lay].visibility = "hide";}
	if (ns6) {document.getElementById([lay]).style.display = "none";}
}
function showLayer(lay) {
	if (ie4) {document.all[lay].style.display = "block";}
	if (ns4) {document.layers[lay].visibility = "show";}
	if (ns6) {document.getElementById([lay]).style.display = "block";}
}

/*
 | about cookie
 */
function trim(str){
	if(str && str.length>0){
		if(str.charAt(0)==' ')
			return trim(str.substring(1,str.length));
		else if(str.charAt(str.length-1)==' ')
			return trim(str.substring(0,str.length-1));
		else
			return str;
	}
	
	return "";
}

function setCookie(sName,sValue)
{
	document.cookie = sName + "=" + escape(sValue) + ";expires=Mon,31 Dec 2049 23:59:59 UTC;";
}

function getCookie(sName)
{
	var aCookie = document.cookie.split(";");
	for (var i=0; i < aCookie.length; i++)
	{
		var aCrumb = aCookie[i].split("=");
		if (sName == trim(aCrumb[0]))
			return unescape(aCrumb[1]);
	}
	return null;
}

/*
 | check email format
 */
function isEmail(theStr)
{
	var unchar="/\\;:,";
	var atIndex = theStr.indexOf('@');
	var dotIndex = theStr.indexOf('.', atIndex);
	var flag = true;
	for (i=0;i<theStr.length;i++){	
		if (unchar.indexOf(theStr.substr(i,1)) > -1){
			return false;		
		}
	}
	theSub = theStr.substring(0, dotIndex+1)
	if ((atIndex < 1)||(atIndex != theStr.lastIndexOf('@'))||(dotIndex < atIndex + 2)||(theStr.length <= theSub.length)) 
	{	flag = false; }
	else { flag = true; }
	return(flag);
}

/*
 | check string range, there is one not, return false
 */
function isRange (sV,sR){
	var sTmp;
	if(sV.length==0){ return (false);}
	for (var i=0; i < sV.length; i++){
		sTmp= sV.substring (i, i+1);
		if (sR.indexOf (sTmp, 0)==-1) {return (false);}
	}
	return (true);
}
