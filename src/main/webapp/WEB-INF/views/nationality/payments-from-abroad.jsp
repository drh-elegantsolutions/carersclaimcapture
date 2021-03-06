<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>

<t:mainPage>
    <t:pageContent errors="${validationErrors}" backLink="${previousPage}">

        <t:yesnofield name="eeaGuardQuestion" />

        <t:hiddenPanel id="eeaWrapper" triggerId="eeaGuardQuestion" triggerValue="yes">
            <t:pre>
                <p><t:message code="eeaCountryHelp.label" /><br><t:message code="eeaCountryHelp" /></p>
           </t:pre>

           <t:yesnofield name="benefitsFromEEADetails" />

            <t:hiddenPanel id="benefitsFromEEADetailsWrapper" triggerId="benefitsFromEEADetails" triggerValue="yes">
                <t:textarea name="benefitsFromEEADetails_field" showRemainingChars="true" />
            </t:hiddenPanel>

            <t:yesnofield name="workingForEEADetails" />

            <t:hiddenPanel id="workingForEEADetailsWrapper" triggerId="workingForEEADetails" triggerValue="yes">
                <t:textarea name="workingForEEADetails_field" showRemainingChars="true" />
            </t:hiddenPanel>

        </t:hiddenPanel>

    </t:pageContent>
</t:mainPage>   
