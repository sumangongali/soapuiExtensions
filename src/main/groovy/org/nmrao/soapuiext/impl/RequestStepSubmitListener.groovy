package org.nmrao.soapuiext.impl
import com.eviware.soapui.model.iface.Submit
import com.eviware.soapui.model.iface.SubmitContext
import com.eviware.soapui.model.iface.SubmitListener
import org.apache.logging.log4j.Logger

import org.apache.logging.log4j.LogManager;
import static org.nmrao.soapuiext.SoapUIGroovyScriptEngineHelper.getInstance

class RequestStepSubmitListener implements SubmitListener {

      private final static Logger log = LogManager.getLogger(RequestStepSubmitListener)

    @Override
    boolean beforeSubmit(Submit submit, SubmitContext context) {
        def scriptEngineHelper = getInstance('REQUEST_STEP_BEFORE_SUBMIT', context, null, log)
        scriptEngineHelper.scriptEngine.setVariable('submit', submit)
        scriptEngineHelper.run()
        return true
    }

    @Override
    void afterSubmit(Submit submit, SubmitContext context) {
        def scriptEngineHelper = getInstance('REQUEST_STEP_AFTER_SUBMIT', context, null, log)
        scriptEngineHelper.scriptEngine.setVariable('submit', submit)
        scriptEngineHelper.run()
    }

}
