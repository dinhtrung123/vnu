<#macro registrationLayout bodyClass="" displayInfo=false displayMessage=true displayWide=false>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="${properties.kcHtmlClass!}">

<head>
    <meta charset="utf-8">
    <meta page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="robots" content="noindex, nofollow">

    <#if properties.meta?has_content>
        <#list properties.meta?split(' ') as meta>
            <meta name="${meta?split('==')[0]}" content="${meta?split('==')[1]}"/>
        </#list>
    </#if>
    <title>${msg("loginTitle",(realm.displayName!''))}</title>
    <link rel="icon" href="${url.resourcesPath}/img/favicon.ico" />
    <#if properties.styles?has_content>
        <#list properties.styles?split(' ') as style>
            <link href="${url.resourcesPath}/${style}" rel="stylesheet" />
        </#list>
    </#if>
    <#if properties.scripts?has_content>
        <#list properties.scripts?split(' ') as script>
            <script src="${url.resourcesPath}/${script}" type="text/javascript"></script>
        </#list>
    </#if>
    <#if scripts??>
        <#list scripts as script>
            <script src="${script}" type="text/javascript"></script>
        </#list>
    </#if>
	
	<script> 
	if(window.location.href.indexOf("kc_locale")==-1){
	console.log(0);
		if(window.location.href.indexOf("?")==-1){
		console.log(1);
		    window.location.href= window.location.href+"?kc_locale=vi";
		}
		else{
		  console.log(2);
			window.location.href= window.location.href+"&kc_locale=vi";
		}
	}
	console.log(3);
	</script>
</head>

<body class="${properties.kcBodyClass!}" style="background: url('${url.resourcesPath}/img/bg_login.jpg') !important;
    background-size: cover !important; background-position: bottom center !important; background-repeat: no-repeat !important; height: 100vh;margin-top: -140px !important;">
  <div class="container-fluid">
    <p class="text-center mbt-30"><img src="${url.resourcesPath}/img/logo-vnpost.svg" class="text-center mbt-30" width="300" alt=""></p>
    
    <div class="${properties.kcFormCardClass!} <#if displayWide>${properties.kcFormCardAccountClass!}</#if> form-signin">
      <header class="${properties.kcFormHeaderClass!}">
        <#if realm.internationalizationEnabled  && locale.supported?size gt 1>
            <div id="kc-locale">
                <div id="kc-locale-wrapper" class="${properties.kcLocaleWrapperClass!}">
                    <div class="kc-dropdown" id="kc-locale-dropdown">
                        <a href="#" id="kc-current-locale-link">${locale.current}</a>
                        <ul>
                            <#list locale.supported as l>
                                <li class="kc-dropdown-item"><a href="${l.url}">${l.label}</a></li>
                            </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </#if>
        <h1 id="kc-page-title" style="display:none"><#nested "header"></h1>
      </header>
      <div id="kc-content">
        <div id="kc-content-wrapper">

          <#if displayMessage && message?has_content>
              <div class="alert alert-${message.type}">
                  <#if message.type = 'success'><span class="${properties.kcFeedbackSuccessIcon!}"></span></#if>
                  <#if message.type = 'warning'><span class="${properties.kcFeedbackWarningIcon!}"></span></#if>
                  <#if message.type = 'error'><span class="${properties.kcFeedbackErrorIcon!}"></span></#if>
                  <#if message.type = 'info'><span class="${properties.kcFeedbackInfoIcon!}"></span></#if>
                  <span class="kc-feedback-text">${kcSanitize(message.summary)?no_esc}</span>
              </div>
          </#if>

          <#nested "form">

          <#if displayInfo>
              <div id="kc-info" class="${properties.kcSignUpClass!}">
                  <div id="kc-info-wrapper" class="${properties.kcInfoAreaWrapperClass!}">
                      <#nested "info">
                  </div>
              </div>
          </#if>
        </div>
      </div>

    </div>
  </div>
   <div class="footer-login container-fluid">
			 <h6 style="margin-bottom: 0.5rem;font-weight: 700; line-height: 1.2;font-size:14px;">TỔNG CÔNG TY BƯU ĐIỆN VIỆT NAM - VIETNAM POST</h6>
			  <p class="">Địa chỉ: Số 05 đường Phạm Hùng - Mỹ Đình 2 - Nam Từ Liêm - Hà Nội - Việt Nam</p>
		  </div>
</body>
</html>
</#macro>
