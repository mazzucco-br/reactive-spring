package com.mazzucco.reactivespring.mscommons.api.common;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;

public abstract class BaseBusinessService <I extends Payload, O extends Payload> {

	public Publisher<O> execute(I request) {
		try {	
			return this.execution(request);
		} catch (Exception e) {
			this.getLogger().error("execution", e);
			throw e;
		}
	}

	protected abstract Logger getLogger();

	protected abstract Publisher<O> execution(I request);
}
