package uk.gov.dwp.carersallowance.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.gov.dwp.carersallowance.session.SessionManager;

@Controller
public class FosteringAllowanceController extends AbstractFormController {
    private static final Logger LOG = LoggerFactory.getLogger(FosteringAllowanceController.class);

    private static final String PAGE_NAME     = "page.fostering-allowance";
    private static final String CURRENT_PAGE  = "/your-income/fostering-allowance";

    @Autowired
    public FosteringAllowanceController(SessionManager sessionManager, MessageSource messageSource) {
        super(sessionManager, messageSource);
    }

    @Override
    public String getPreviousPage(HttpServletRequest request) {
        return super.getPreviousPage(request, YourIncomeController.getIncomePageList(request.getSession()));
    }

    @Override
    public String getCurrentPage(HttpServletRequest request) {
        return CURRENT_PAGE;
    }

    @Override
    public String getNextPage(HttpServletRequest request) {
        return super.getNextPage(request, YourIncomeController.getIncomePageList(request.getSession()));
    }

    @Override
    protected String getPageName() {
        return PAGE_NAME;
    }

    @RequestMapping(value=CURRENT_PAGE, method = RequestMethod.GET)
    public String showForm(HttpServletRequest request, Model model) {
        return super.showForm(request, model);
    }

    @RequestMapping(value=CURRENT_PAGE, method = RequestMethod.POST)
    public String postForm(HttpServletRequest request, HttpSession session, Model model) {
        return super.postForm(request, session, model);
    }

    /**
     * Might use BindingResult, and spring Validator, not sure yet
     * don't want to perform type conversion prior to controller as we have no control
     * over the (rather poor) reporting behaviour
     * @return
     */
    protected void validate(Map<String, String[]> fieldValues, String[] fields) {
        LOG.trace("Starting BenefitsController.validate");

        validateMandatoryField(fieldValues, "fosteringAllowancePay");
        if(fieldValue_Equals(fieldValues, "fosteringAllowancePay", "Other")) {
            validateMandatoryField(fieldValues, "fosteringAllowancePayOther");
        }

        validateMandatoryField(fieldValues, "fosteringAllowanceStillBeingPaidThisPay");
        if(fieldValue_Equals(fieldValues, "fosteringAllowanceStillBeingPaidThisPay", "no")) {
            validateMandatoryDateField(fieldValues, "fosteringAllowanceWhenDidYouLastGetPaid");
        }

        validateMandatoryField(fieldValues, "fosteringAllowanceWhoPaidYouThisPay");
        validateMandatoryField(fieldValues, "fosteringAllowanceAmountOfThisPay");

        validateMandatoryField(fieldValues, "fosteringAllowanceHowOftenPaidThisPay");
        if(fieldValue_Equals(fieldValues, "fosteringAllowanceHowOftenPaidThisPay", "Other")) {
            validateMandatoryField(fieldValues, "fosteringAllowanceHowOftenPaidThisPayOther");
        }

        LOG.trace("Ending BenefitsController.validate");
    }
}
