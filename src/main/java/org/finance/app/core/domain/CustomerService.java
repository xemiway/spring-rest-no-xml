package org.finance.app.core.domain;

import org.finance.app.core.domain.common.Form;
import org.finance.app.core.domain.events.impl.ExtendTheLoanRequest;
import org.finance.app.core.domain.events.impl.RequestWasSubmitted;
import org.finance.app.core.domain.common.Loan;
import org.finance.app.ddd.annotation.AggregateRoot;
import org.finance.app.ddd.system.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;

@AggregateRoot
public class CustomerService {

    private DomainEventPublisher eventPublisher;

    private Form submittedForm;

    @Autowired
    public CustomerService (DomainEventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    public void applyForaLoan(){

        if( submittedForm != null ){
            Form formToSend = submittedForm;
            cleanUpForm();
            eventPublisher.publish(new RequestWasSubmitted(formToSend));
        } else {
            throw new IllegalStateException("Before applying for a Loan Form must be submitted"); //TODO: create spifi class
        }
    }

    public Loan browseLoanHistory(){

        return null;
    }

    public Boolean submitTheForm(Form form){
        Boolean isCorrectlyFilled = validateForm(form);

        if(isCorrectlyFilled){
            this.submittedForm = form;
        }

        return isCorrectlyFilled;
    }

    public void extendTheLoan(Loan loan){
        eventPublisher.publish(new ExtendTheLoanRequest(loan));
    }

    private Boolean validateForm(Form form) {
        return true; //TODO: Implement validator
    }

    private void cleanUpForm(){
        this.submittedForm = null;
    }

}
