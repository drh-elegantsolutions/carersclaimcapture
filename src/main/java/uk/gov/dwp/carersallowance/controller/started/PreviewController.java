package uk.gov.dwp.carersallowance.controller.started;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.gov.dwp.carersallowance.controller.AbstractFormController;

import uk.gov.dwp.carersallowance.session.SessionManager;
import uk.gov.dwp.carersallowance.transformations.TransformationManager;

@Controller
public class PreviewController extends AbstractFormController {
    private static final Logger LOG = LoggerFactory.getLogger(PreviewController.class);

    private static final String PAGE_NAME     = "page.preview";
    private static final String CURRENT_PAGE  = "/preview";

//    private static final String[] FIELDS = {};

    @Autowired
    public PreviewController(final SessionManager sessionManager, final MessageSource messageSource, final TransformationManager transformationManager) {
        super(sessionManager, messageSource, transformationManager);
    }

    @Override
    public String getCurrentPage(HttpServletRequest request) {
        return CURRENT_PAGE;
    }

    @Override
    public String getPageName() {
        return PAGE_NAME;
    }

//    @Override
//    public String[] getFields() {
//        return FIELDS;
//    }

    @RequestMapping(value=CURRENT_PAGE, method = RequestMethod.GET)
    public String getForm(HttpServletRequest request, Model model) {
        return "redirect:" + getNextPage(request);
    }

    @RequestMapping(value=CURRENT_PAGE, method = RequestMethod.POST)
    public String postForm(HttpServletRequest request, Model model) {
        return super.postForm(request, model);
    }

    /**
     * Might use BindingResult, and spring Validator, not sure yet
     * don't want to perform type conversion prior to controller as we have no control
     * over the (rather poor) reporting behaviour
     * @return
     */
    protected void validate(String[] fields, Map<String, String[]> fieldValues, Map<String, String[]> allFieldValues) {
        LOG.trace("Starting BenefitsController.validate");

        LOG.trace("Ending BenefitsController.validate");
    }
}
