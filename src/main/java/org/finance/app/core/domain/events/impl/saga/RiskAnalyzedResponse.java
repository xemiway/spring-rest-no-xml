package org.finance.app.core.domain.events.impl.saga;

import org.finance.app.core.domain.common.AggregateId;
import org.finance.app.core.ddd.annotation.Event;
import org.finance.app.core.domain.risk.Risk;

import java.io.Serializable;

@Event
public class RiskAnalyzedResponse implements Serializable {

    private final AggregateId sagaDataId;

    private final Risk risk;

    public RiskAnalyzedResponse(AggregateId sagaDataId, Risk risk){
        this.sagaDataId = sagaDataId;
        this.risk = risk;
    }

    public AggregateId getSagaDataId() {
        return sagaDataId;
    }

    public Risk getRisk() {
        return risk;
    }
}
